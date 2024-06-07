package luckytnt.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import luckytnt.registry.EntityRegistry;
import luckytnt.registry.SoundRegistry;
import luckytntlib.entity.LExplosiveProjectile;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity.PickupPermission;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class VacuumCleaner extends Item {

	public int soundCooldown = 0;
	
	public VacuumCleaner() {
		super(new Item.Settings().maxCount(1).maxDamage(1000));
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}
	
	@Override
	public void appendTooltip(ItemStack stack, @Nullable World level, List<Text> components, TooltipContext flag) {
		super.appendTooltip(stack, level, components, flag);
		components.add(Text.translatable("item.vacuum_cleaner.info"));
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
		usageTick(level, player, player.getStackInHand(hand) , player.getStackInHand(hand).getCount());
		if(!player.getStackInHand(hand).getOrCreateNbt().getBoolean("using")) {
			soundCooldown = 42;
			player.getStackInHand(hand).getOrCreateNbt().putBoolean("using", true);
		}
		else if(player.getStackInHand(hand).getOrCreateNbt().getBoolean("using")) {
			player.getStackInHand(hand).getOrCreateNbt().putBoolean("using", false);
		}
		if(player.getStackInHand(hand).getOrCreateNbt().getBoolean("using"))
			level.playSoundFromEntity(null, player, SoundRegistry.VACUUM_CLEANER_START.get(), SoundCategory.MASTER, 2, 1);
		return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, player.getStackInHand(hand));
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World level, Entity entity, int count, boolean inHand) {		
		if(stack.getOrCreateNbt().getBoolean("using") && inHand) {
			if(!level.isClient)
				soundCooldown--;
			if(soundCooldown == 0) {
				level.playSoundFromEntity(null, entity, SoundRegistry.VACUUM_CLEANER.get(), SoundCategory.MASTER, 2, 1);
				if(!level.isClient)
					soundCooldown = 22;
			}
			if(entity instanceof PlayerEntity player) {
				if(!player.isCreative()) {
					stack.setDamage(stack.getDamage() + 1);
					if(stack.getDamage() > 1960)
						stack.decrement(1);
				}
				LExplosiveProjectile shot = EntityRegistry.VACUUM_SHOT.get().create(level);
				shot.setPosition(player.getLerpedPos(1f).add(0, player.getStandingEyeHeight(), 0));
				shot.setVelocity(player.getRotationVec(1).x, player.getRotationVec(1).y, player.getRotationVec(1).z, 4, 0);
				shot.pickupType = PickupPermission.DISALLOWED;
				level.spawnEntity(shot);
			}
		}
		else
			stack.getOrCreateNbt().putBoolean("using", false);
	}
}

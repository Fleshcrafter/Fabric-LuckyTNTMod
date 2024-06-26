package luckytnt.entity;

import luckytntlib.entity.LExplosiveProjectile;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageScaling;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DeathMessageType;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class HailstoneProjectile extends LExplosiveProjectile {

	public HailstoneProjectile(EntityType<LExplosiveProjectile> type, World level, PrimedTNTEffect effect) {
		super(type, level, effect);
	}

	@Override
	public void onBlockHit(BlockHitResult result) {
		super.onBlockHit(result);
		getWorld().playSound(null, new BlockPos(MathHelper.floor(x()), MathHelper.floor(y()), MathHelper.floor(z())), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 0.5f, 1f);
		for(int count = 0; count < 10; count++)
			getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.SNOW.getDefaultState()), x(), y(), z(), 0, 0, 0);
		destroy();
	}
	
	@Override
	public void onEntityHit(EntityHitResult result) {
		super.onEntityHit(result);
		if(result.getEntity() instanceof LivingEntity lent) {
			DamageType type = new DamageType("hailstone", DamageScaling.NEVER, 0f, DamageEffects.HURT, DeathMessageType.DEFAULT);
			DamageSource source = new DamageSource(RegistryEntry.of(type), this, owner());
			
			lent.damage(source, 4f);
		}
	} 
}

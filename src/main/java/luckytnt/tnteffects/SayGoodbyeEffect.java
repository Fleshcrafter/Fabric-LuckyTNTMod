package luckytnt.tnteffects;

import luckytnt.registry.BlockRegistry;
import luckytnt.registry.SoundRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageScaling;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DeathMessageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;

public class SayGoodbyeEffect extends PrimedTNTEffect{

	@Override
	public void explosionTick(IExplosiveEntity entity) {
		if(entity.getTNTFuse() == 30) {
			entity.getLevel().playSound(null, entity.x(), entity.y(), entity.z(), SoundRegistry.SAY_GOODBYE.get(), SoundCategory.HOSTILE, 20, 1);
		}
	}
	
	@Override
	public void serverExplosion(IExplosiveEntity entity) {		
		PlayerEntity ent = entity.getLevel().getClosestPlayer((Entity)entity, 60);
		if(ent != null) {
			DamageType type = new DamageType("say_goodbye", DamageScaling.NEVER, 0f, DamageEffects.HURT, DeathMessageType.DEFAULT);
			DamageSource source = new DamageSource(RegistryEntry.of(type), (Entity)entity, entity.owner());
			
			ImprovedExplosion explosion = new ImprovedExplosion(ent.getWorld(), (Entity) entity, source, ent.getX(), ent.getY(), ent.getZ(), 20);
			explosion.doEntityExplosion(2f, true);
			explosion.doBlockExplosion(1f, 1f, 1f, 1.5f, false, false);
			if(entity.getLevel() instanceof ServerWorld sLevel) {
				sLevel.spawnParticles(ParticleTypes.EXPLOSION, ent.getX(), ent.getY(), ent.getZ(), 60, 2, 2, 2, 0);
			}
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.SAY_GOODBYE.get();
	}
}

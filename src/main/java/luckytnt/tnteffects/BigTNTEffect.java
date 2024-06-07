package luckytnt.tnteffects;

import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;

public class BigTNTEffect extends PrimedTNTEffect{

	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		ImprovedExplosion explosion = new ImprovedExplosion(entity.getLevel(), (Entity)entity, entity.getPos(), 15);
		explosion.doEntityExplosion(2f, true);
		explosion.doBlockExplosion();
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity entity) {
		entity.getLevel().addParticle(ParticleTypes.SMOKE, entity.x(), entity.y() + 2f, entity.z(), 0, 0, 0);
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.TNT.get();
	}
	
	@Override
	public float getSize(IExplosiveEntity entity) {
		return 2f;
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity entity) {
		return 120;
	}
}

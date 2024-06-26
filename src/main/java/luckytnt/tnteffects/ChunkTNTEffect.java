package luckytnt.tnteffects;

import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.particle.ParticleTypes;

public class ChunkTNTEffect extends CubicTNTEffect {

	public ChunkTNTEffect() {
		super(50);
	}
	
	@Override
	public void explosionTick(IExplosiveEntity ent) {
		if(ent.getTNTFuse() == 160) {
			Entity lighting = new LightningEntity(EntityType.LIGHTNING_BOLT, ent.getLevel());
			lighting.setPosition(ent.getPos());
			ent.getLevel().spawnEntity(lighting);
		}
	}

	@Override
	public void spawnParticles(IExplosiveEntity ent) {
		for(float i = 0; i < 3.25f; i += 0.25f) {
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() + 1.5f, ent.y() - 1 + i, ent.z() + 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() - 1.5f, ent.y() - 1 + i, ent.z() - 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() + 1.5f, ent.y() - 1 + i, ent.z() - 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() - 1.5f, ent.y() - 1 + i, ent.z() + 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() - 1.5f + i, ent.y() - 1, ent.z() + 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() - 1.5f, ent.y() - 1, ent.z() - 1.5f + i, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() - 1.5f + i, ent.y() + 2, ent.z() + 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() - 1.5f, ent.y() + 2, ent.z() - 1.5f + i, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() + 1.5f - i, ent.y() - 1, ent.z() - 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() + 1.5f, ent.y() - 1, ent.z() + 1.5f - i, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() + 1.5f - i, ent.y() + 2, ent.z() - 1.5f, 0, 0, 0);
			ent.getLevel().addParticle(ParticleTypes.FLAME, ent.x() + 1.5f, ent.y() + 2, ent.z() + 1.5f - i, 0, 0, 0);
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.CHUNK_TNT.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return 160;
	}
}

package luckytnt.tnteffects;

import org.joml.Vector3f;

import luckytnt.registry.BlockRegistry;
import luckytnt.registry.EntityRegistry;
import luckytntlib.entity.PrimedLTNT;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.particle.DustParticleEffect;

public class EyeOfTheSaharaEffect extends PrimedTNTEffect {

	@Override
	public void serverExplosion(IExplosiveEntity ent) {
		for(double angle = 0; angle < 360; angle += 6D) {
			PrimedLTNT tnt = EntityRegistry.TNT_X20.get().create(ent.getLevel());
			tnt.setTNTFuse(160);
			tnt.setOwner(ent.owner());
			double x = ent.x() + 80 * Math.cos(angle * Math.PI / 180);
			double z = ent.z() + 80 * Math.sin(angle * Math.PI / 180);
			double y = RingTNTEffect.getFirstMotionBlockingBlock(ent.getLevel(), x, z);
			tnt.setPosition(x, y + 1D, z);
			ent.getLevel().spawnEntity(tnt);
		}
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity ent) {
		for(double angle = 0; angle < 360; angle += 4D) {
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(0f, 0f, 0f), 1f), ent.x() + 2 * Math.cos(angle * Math.PI / 180), ent.y() + 0.5d, ent.z() + 2 * Math.sin(angle * Math.PI / 180), 0d, 0d, 0d);
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.EYE_OF_THE_SAHARA.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return 120;
	}
}

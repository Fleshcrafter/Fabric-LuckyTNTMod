package luckytnt.tnteffects;

import luckytnt.config.LuckyTNTConfigValues;
import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ExplosionHelper;
import luckytntlib.util.explosions.IForEachBlockExplosionEffect;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ReversedTNTEffect extends PrimedTNTEffect {

	@Override
	public void serverExplosion(IExplosiveEntity ent) {
		ExplosionHelper.doSphericalExplosion(ent.getLevel(), ent.getPos(), 30, new IForEachBlockExplosionEffect() {
			
			@Override
			public void doBlockExplosion(World level, BlockPos pos, BlockState state, double distance) {
				BlockPos posTop = new BlockPos(pos.getX(), MathHelper.floor(ent.y() + (-(pos.getY() - ent.y())) + LuckyTNTConfigValues.ISLAND_HEIGHT.get()), pos.getZ());
				BlockState stateTop = level.getBlockState(posTop);
				if(state.getBlock().getBlastResistance() <= 200 && stateTop.isAir() && !state.isAir() && Math.abs(ent.y() - pos.getY()) <= 20D) {
					level.setBlockState(posTop, state, 3);
				}
			}
		});
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity ent) {
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() + 0.7f, ent.y() + 1f, ent.z(), 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() - 0.7f, ent.y() + 1f, ent.z(), 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x(), ent.y() + 1f, ent.z() + 0.7f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x(), ent.y() + 1f, ent.z() - 0.7f, 0, -0.1f, 0);

		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() + 0.6f, ent.y() + 1f, ent.z() + 0.6f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() - 0.6f, ent.y() + 1f, ent.z() - 0.6f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() - 0.6f, ent.y() + 1f, ent.z() + 0.6f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() + 0.6f, ent.y() + 1f, ent.z() - 0.6f, 0, -0.1f, 0);

		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() + 0.3f, ent.y() + 1.5f, ent.z(), 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() - 0.3f, ent.y() + 1.5f, ent.z(), 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x(), ent.y() + 1.5f, ent.z() + 0.3f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x(), ent.y() + 1.5f, ent.z() - 0.3f, 0, -0.1f, 0);

		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() + 0.2f, ent.y() + 1.5f, ent.z() + 0.2f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() - 0.2f, ent.y() + 1.5f, ent.z() - 0.2f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() - 0.2f, ent.y() + 1.5f, ent.z() + 0.2f, 0, -0.1f, 0);
		ent.getLevel().addParticle(ParticleTypes.SMOKE, ent.x() + 0.2f, ent.y() + 1.5f, ent.z() - 0.2f, 0, -0.1f, 0);
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.REVERSED_TNT.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return 140;
	}
}

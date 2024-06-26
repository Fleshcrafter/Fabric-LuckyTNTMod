package luckytnt.tnteffects;

import org.joml.Vector3f;

import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ExplosionHelper;
import luckytntlib.util.explosions.IForEachBlockExplosionEffect;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class LavaOceanTNTEffect extends PrimedTNTEffect{

	private final int radius;
	private final int radiusY;
	
	public LavaOceanTNTEffect(int radius, int radiusY) {
		this.radius = radius;
		this.radiusY = radiusY;
	}
	
	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		ExplosionHelper.doCylindricalExplosion(entity.getLevel(), entity.getPos(), radius, radiusY, new IForEachBlockExplosionEffect() {
			
			@Override
			public void doBlockExplosion(World level, BlockPos pos, BlockState state, double distance) {
				if(pos.getY() <= entity.getPos().y) {
					if((!state.isSideSolidFullSquare(level, pos, Direction.UP) && state.getBlock().getBlastResistance() < 100) || state.getBlock().getBlastResistance() < 4) {
						state.getBlock().onDestroyedByExplosion(level, pos, ImprovedExplosion.dummyExplosion(entity.getLevel()));
						level.setBlockState(pos, Blocks.LAVA.getDefaultState());
					}
				}
			}
		});
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity entity) {
		entity.getLevel().addParticle(new DustParticleEffect(new Vector3f(1f, 0.5f, 0.1f), 1f), entity.x(), entity.y() + 1f, entity.z(), 0, 0, 0);
	}

	@Override
	public Block getBlock() {
		return BlockRegistry.LAVA_OCEAN_TNT.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity entity) {
		return 160;
	}
}

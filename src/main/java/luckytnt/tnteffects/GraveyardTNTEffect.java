package luckytnt.tnteffects;

import org.joml.Vector3f;

import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class GraveyardTNTEffect extends PrimedTNTEffect {

	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		for(int offX = -20; offX <= 20; offX++) {
			for(int offY = 0; offY <= 10; offY++) {
				for(int offZ = -20; offZ <= 20; offZ++) {
					double distance = Math.sqrt(offX * offX + offY * offY + offZ * offZ);
					BlockPos pos = toBlockPos(new Vec3d(entity.x() + offX, entity.y() + offY - 10, entity.z() + offZ));
					if(distance <= 20 && entity.getLevel().getBlockState(pos).getBlock().getBlastResistance() <= 100 && !entity.getLevel().getBlockState(pos).isFullCube(entity.getLevel(), pos)) {
						entity.getLevel().getBlockState(pos).getBlock().onDestroyedByExplosion(entity.getLevel(), pos, ImprovedExplosion.dummyExplosion(entity.getLevel()));
						entity.getLevel().setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
					}
				}
			}
		}
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity entity) {
		for(int count = 0; count <= 20; count++) {
			entity.getLevel().addParticle(new DustParticleEffect(new Vector3f(0.5f, 0.2f, 0f), 0.75f), entity.x(), entity.y() + 1D + 0.05D * count, entity.z(), 0, 0, 0);
			entity.getLevel().addParticle(new DustParticleEffect(new Vector3f(0.5f, 0.2f, 0f), 0.75f), entity.x() - 0.5D + count * 0.05D, entity.y() + 1D + (2D / 3D), entity.z(), 0, 0, 0);
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.GRAVEYARD_TNT.get();
	}
}

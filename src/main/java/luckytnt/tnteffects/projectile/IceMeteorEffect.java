package luckytnt.tnteffects.projectile;

import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ExplosionHelper;
import luckytntlib.util.explosions.IForEachBlockExplosionEffect;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IceMeteorEffect extends PrimedTNTEffect{
	
	private final int strength;
	private final float size;
	
	public IceMeteorEffect(int strength, float size) {
		this.strength = strength;
		this.size = size;
	}
	
	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		ImprovedExplosion explosion = new ImprovedExplosion(entity.getLevel(), (Entity)entity, entity.getPos(), strength);
		explosion.doEntityExplosion(3, true);
		ExplosionHelper.doSphericalExplosion(entity.getLevel(), entity.getPos(), strength, new IForEachBlockExplosionEffect() {
			
			@Override
			public void doBlockExplosion(World level, BlockPos pos, BlockState state, double distance) {
				if(!state.isAir()) {
					if(distance <= (strength - strength / 8) && state.getBlock().getBlastResistance() <= 100) {
						state.getBlock().onDestroyedByExplosion(level, pos, explosion);
						level.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
					}
					else if(Math.random() < 0.6f && state.getBlock().getBlastResistance() <= 100) {
						state.getBlock().onDestroyedByExplosion(level, pos, explosion);
						level.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
						if(Math.random() < 0.25f) {
							level.setBlockState(pos, Math.random() < 0.5f ? Blocks.BLUE_ICE.getDefaultState() : Blocks.PACKED_ICE.getDefaultState());
						}
					}
				}
			}
		});
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity entity) {
		entity.getLevel().addParticle(ParticleTypes.ITEM_SNOWBALL, entity.x(), entity.y() + size, entity.z(), 0, 0, 0);
	}

	@Override
	public float getSize(IExplosiveEntity entity) {
		return size;
	}

	@Override
	public Block getBlock() {
		return Blocks.PACKED_ICE;
	}
}

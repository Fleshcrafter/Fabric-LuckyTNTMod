package luckytnt.tnteffects;

import org.joml.Vector3f;

import luckytnt.registry.SoundRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ExplosionHelper;
import luckytntlib.util.explosions.IForEachBlockExplosionEffect;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DeathRayEffect extends PrimedTNTEffect {

	@Override
	public void explosionTick(IExplosiveEntity ent) {
		if(ent.getTNTFuse() == 480) {
			NbtCompound tag = ent.getPersistentData();
			tag.putInt("explosionSize", 1);
			tag.putInt("particleSize", 1);
			ent.setPersistentData(tag);
			ent.getLevel().playSound(null, ent.x(), ent.y(), ent.z(), SoundRegistry.DEATH_RAY.get(), SoundCategory.HOSTILE, 20, 1);
			((Entity)ent).setVelocity(0, 0, 0);
		}
		
		if(ent.getTNTFuse() < 80) {
			((Entity)ent).setVelocity(0, 0, 0);
			((Entity)ent).setPosition(((Entity)ent).prevX, ((Entity)ent).prevY, ((Entity)ent).prevZ);
			
			ExplosionHelper.doSphericalExplosion(ent.getLevel(), ent.getPos(), ent.getPersistentData().getInt("explosionSize"), new IForEachBlockExplosionEffect() {
				
				@Override
				public void doBlockExplosion(World level, BlockPos pos, BlockState state, double distance) {
					if(distance >= 75) {
						if(state.getBlock().getBlastResistance() < 2000 && !state.isAir()) {
							if(Math.random() < 0.1f) {
								level.setBlockState(pos, Blocks.LAVA.getDefaultState(), 3);
							} else if(Math.random() < 0.8f) {
								level.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), 3);
							}
						}
					} else if(state.getBlock().getBlastResistance() < 2000 && !state.isAir()) {
						state.getBlock().onDestroyedByExplosion(level, pos, ImprovedExplosion.dummyExplosion(ent.getLevel()));
						level.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
					}
				}
			});
			
			NbtCompound tag = ent.getPersistentData();
			tag.putInt("explosionSize", ent.getPersistentData().getInt("explosionSize") + 1);
			ent.setPersistentData(tag);
		}
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity ent) {
		if(ent.getTNTFuse() > 120) {
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(0.8f, 0f, 0f), 1f), true, ent.x(), ent.y(), ent.z(), 0, 0, 0);
		}
		if(ent.getTNTFuse() < 140) {
			for(int count = 0; count < 200; count++) {
				ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(0.5f, 0f, 2f), 10f), true, ent.x() + Math.random() - Math.random(), ent.y() + 135f - Math.random() * ent.getPersistentData().getInt("particleSize"), ent.z() + Math.random() - Math.random(), 0, 0, 0);
			}
			NbtCompound tag = ent.getPersistentData();
			tag.putInt("particleSize", ent.getPersistentData().getInt("particleSize") + 2);
			ent.setPersistentData(tag);
		}
	}
	
	@Override
	public Block getBlock() {
		return Blocks.AIR;
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return 480;
	}
}

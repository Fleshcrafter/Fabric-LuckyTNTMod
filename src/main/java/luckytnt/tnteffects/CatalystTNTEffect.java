package luckytnt.tnteffects;

import java.util.Random;

import org.joml.Vector3f;

import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class CatalystTNTEffect extends PrimedTNTEffect {

	@Override
	public void explosionTick(IExplosiveEntity ent) {
		if(ent.getTNTFuse() < 200) {
			if(ent.getPersistentData().getInt("nextExplosion") <= 0) {
				double x = ent.x() + Math.random() * 40 - Math.random() * 40;
				double y = ent.y() + Math.random() * 15 - Math.random() * 15;
				double z = ent.z() + Math.random() * 40 - Math.random() * 40;
				if(!ent.getLevel().isClient()) {
					ImprovedExplosion explosion = new ImprovedExplosion(ent.getLevel(), (Entity)ent, new Vec3d(x, y, z), 25 + new Random().nextInt(16));
					explosion.doEntityExplosion(2f, true);
					explosion.doBlockExplosion(1f, 1f, 0.75f, 1f, false, false);
				}
				ent.getLevel().playSound(null, new BlockPos(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z)), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4, (1.0F + (ent.getLevel().getRandom().nextFloat() - ent.getLevel().getRandom().nextFloat()) * 0.2F) * 0.7F);
				NbtCompound tag = ent.getPersistentData();
				tag.putInt("nextExplosion", 4 + (int)Math.round(Math.random()));
				ent.setPersistentData(tag);
			}
			NbtCompound tag = ent.getPersistentData();
			tag.putInt("nextExplosion", ent.getPersistentData().getInt("nextExplosion") - 1);
			ent.setPersistentData(tag);
		}
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity ent) {
		for(double i = 0D; i < 1D; i += 0.05D) {
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(1f, 0f, 0f), 1f), ent.x() + 0.5D, ent.y() + i, ent.z() + 0.5D, 0, 0, 0);
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(1f, 0f, 0f), 1f), ent.x() - 0.5D, ent.y() + i, ent.z() + 0.5D, 0, 0, 0);
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(1f, 0f, 0f), 1f), ent.x() + 0.5D, ent.y() + i, ent.z() - 0.5D, 0, 0, 0);
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(1f, 0f, 0f), 1f), ent.x() - 0.5D, ent.y() + i, ent.z() - 0.5D, 0, 0, 0);
		}
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.CATALYST_TNT.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return 340;
	}
}

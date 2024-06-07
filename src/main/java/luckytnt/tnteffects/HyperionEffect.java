package luckytnt.tnteffects;

import org.joml.Vector3f;

import luckytnt.LuckyTNTMod;
import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.IForEachBlockExplosionEffect;
import luckytntlib.util.explosions.ImprovedExplosion;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class HyperionEffect extends PrimedTNTEffect {

	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		ImprovedExplosion explosion = new ImprovedExplosion(entity.getLevel(), (Entity)entity, entity.getPos(), 50);
		explosion.doBlockExplosion(new IForEachBlockExplosionEffect() {
			
			@SuppressWarnings("resource")
			@Override
			public void doBlockExplosion(World level, BlockPos pos, BlockState state, double distance) {
				if(state.isSideSolidFullSquare(level, pos, Direction.UP) && state.getBlock().getBlastResistance() < 100 && !state.isAir() && (level.getBlockState(pos.up()).isAir() || level.getBlockState(pos.up()).getBlock().getHardness() <= 0.2f)) {
					level.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
					if(Math.random() < 0.015f) {
						int random = level.random.nextInt(6);
						String string = "";
						switch (random) {
							case 0: string = "giant_acaciatree"; break;
							case 1: string = "giant_sprucetree"; break;
							case 2: string = "giant_oaktree"; break;
							case 3: string = "giant_darkoaktree"; break;
							case 4: string = "giant_birchtree"; break;
							case 5: string = "giant_jungletree"; break;
						}
						StructureTemplate template = ((ServerWorld)entity.getLevel()).getStructureTemplateManager().getTemplateOrBlank(new Identifier(LuckyTNTMod.MODID, string));
						if(template != null) {
							template.place((ServerWorld)entity.getLevel(), pos.add(-5, 0, -5), pos.add(-5, 0, -5), new StructurePlacementData(), entity.getLevel().random, 3);
						}
					}
				}
			}
		});
	}
	
	@Override
	public void spawnParticles(IExplosiveEntity ent) {
		for(int count = 0; count < 10; count++) {
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(0.5f, 0.3f, 0f), 1f), ent.x() + (Math.random() * 0.5D - 0.25D), ent.y() + 1f + Math.random() * 2f, ent.z() + (Math.random() * 0.5D - 0.25D), 0, 0, 0);
		}
		for(int count = 0; count < 40; count++) {
			ent.getLevel().addParticle(new DustParticleEffect(new Vector3f(0f, 0.5f, 0f), 1f), ent.x() + (Math.random() * 2D - 1D), ent.y() + 3f + (Math.random() * 2D - 1D), ent.z() + (Math.random() * 2D - 1D), 0, 0, 0);
		}
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity ent) {
		return 140;
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.HYPERION.get();
	}
}

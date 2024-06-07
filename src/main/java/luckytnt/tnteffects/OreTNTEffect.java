package luckytnt.tnteffects;

import java.util.Random;

import luckytnt.entity.OreTNTMinecart;
import luckytnt.entity.PrimedOreTNT;
import luckytnt.registry.BlockRegistry;
import luckytntlib.util.IExplosiveEntity;
import luckytntlib.util.explosions.ExplosionHelper;
import luckytntlib.util.explosions.IForEachBlockExplosionEffect;
import luckytntlib.util.tnteffects.PrimedTNTEffect;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class OreTNTEffect extends PrimedTNTEffect{

	@SuppressWarnings("resource")
	@Override
	public void explosionTick(IExplosiveEntity entity) {
		if(!entity.getLevel().isClient) {
			if(entity instanceof PrimedOreTNT tnt) {
				if(tnt.availablePos.isEmpty()) {
					fillAvailablePos(tnt);
				}
				Block block = Blocks.COAL_ORE;
				int random = new Random().nextInt(22);
				switch(random) {
					case 0: block = Blocks.COAL_ORE; break;
					case 1: block = Blocks.IRON_ORE; break;
					case 2: block = Blocks.GOLD_ORE; break;
					case 3: block = Blocks.COPPER_ORE; break;
					case 4: block = Blocks.DIAMOND_ORE; break;
					case 5: block = Blocks.EMERALD_ORE; break;
					case 6: block = Blocks.NETHER_QUARTZ_ORE; break;
					case 7: block = Blocks.NETHER_GOLD_ORE; break;
					case 8: block = Blocks.LAPIS_ORE; break;
					case 9: block = Blocks.REDSTONE_ORE; break;
					case 10: block = Blocks.DEEPSLATE_COAL_ORE; break;
					case 11: block = Blocks.DEEPSLATE_IRON_ORE; break;
					case 12: block = Blocks.DEEPSLATE_COPPER_ORE; break;
					case 13: block = Blocks.DEEPSLATE_GOLD_ORE; break;
					case 14: block = Blocks.DEEPSLATE_EMERALD_ORE; break;
					case 15: block = Blocks.DEEPSLATE_DIAMOND_ORE; break;
					case 16: block = Blocks.DEEPSLATE_LAPIS_ORE; break;
					case 17: block = Blocks.DEEPSLATE_REDSTONE_ORE; break;
					case 18: block = BlockRegistry.GUNPOWDER_ORE.get(); break;
					case 19: block = BlockRegistry.DEEPSLATE_GUNPOWDER_ORE.get(); break;
					case 20: block = BlockRegistry.URANIUM_ORE.get(); break;
					case 21: block = BlockRegistry.DEEPSLATE_URANIUM_ORE.get(); break;
				}
				for (int count = 0; count < 5; count++) {			
					if(tnt.availablePos.size() > 0) {
						int rand = new Random().nextInt(tnt.availablePos.size());
						if(tnt.availablePos.get(rand) != null) {
							BlockPos pos = tnt.availablePos.get(rand);
							tnt.availablePos.remove(rand);
							entity.getLevel().setBlockState(pos, block.getDefaultState());
							entity.getLevel().playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1f, 1f);
						}
					}
				}
			}
			else if(entity instanceof OreTNTMinecart tnt) {
				if(tnt.availablePos.isEmpty()) {
					fillAvailablePos(tnt);
				}
				Block block = Blocks.COAL_ORE;
				int random = new Random().nextInt(22);
				switch(random) {
					case 0: block = Blocks.COAL_ORE; break;
					case 1: block = Blocks.IRON_ORE; break;
					case 2: block = Blocks.GOLD_ORE; break;
					case 3: block = Blocks.COPPER_ORE; break;
					case 4: block = Blocks.DIAMOND_ORE; break;
					case 5: block = Blocks.EMERALD_ORE; break;
					case 6: block = Blocks.NETHER_QUARTZ_ORE; break;
					case 7: block = Blocks.NETHER_GOLD_ORE; break;
					case 8: block = Blocks.LAPIS_ORE; break;
					case 9: block = Blocks.REDSTONE_ORE; break;
					case 10: block = Blocks.DEEPSLATE_COAL_ORE; break;
					case 11: block = Blocks.DEEPSLATE_IRON_ORE; break;
					case 12: block = Blocks.DEEPSLATE_COPPER_ORE; break;
					case 13: block = Blocks.DEEPSLATE_GOLD_ORE; break;
					case 14: block = Blocks.DEEPSLATE_EMERALD_ORE; break;
					case 15: block = Blocks.DEEPSLATE_DIAMOND_ORE; break;
					case 16: block = Blocks.DEEPSLATE_LAPIS_ORE; break;
					case 17: block = Blocks.DEEPSLATE_REDSTONE_ORE; break;
					case 18: block = BlockRegistry.GUNPOWDER_ORE.get(); break;
					case 19: block = BlockRegistry.DEEPSLATE_GUNPOWDER_ORE.get(); break;
					case 20: block = BlockRegistry.URANIUM_ORE.get(); break;
					case 21: block = BlockRegistry.DEEPSLATE_URANIUM_ORE.get(); break;
				}
				for (int count = 0; count < 5; count++) {			
					if(tnt.availablePos.size() > 0) {
						int rand = new Random().nextInt(tnt.availablePos.size());
						if(tnt.availablePos.get(rand) != null) {
							BlockPos pos = tnt.availablePos.get(rand);
							tnt.availablePos.remove(rand);
							entity.getLevel().setBlockState(pos, block.getDefaultState());
							entity.getLevel().playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1f, 1f);
						}
					}
				}		
			}
		}
	}
	
	@Override
	public void serverExplosion(IExplosiveEntity entity) {
		if(entity instanceof PrimedOreTNT tnt) {
			if(tnt.availablePos.isEmpty()) {
				fillAvailablePos(tnt);
			}
			for (int count = 0; count < 750; count++) {			
				Block block = Blocks.COAL_ORE;
				int random = new Random().nextInt(22);
				switch(random) {
					case 0: block = Blocks.COAL_ORE; break;
					case 1: block = Blocks.IRON_ORE; break;
					case 2: block = Blocks.GOLD_ORE; break;
					case 3: block = Blocks.COPPER_ORE; break;
					case 4: block = Blocks.DIAMOND_ORE; break;
					case 5: block = Blocks.EMERALD_ORE; break;
					case 6: block = Blocks.NETHER_QUARTZ_ORE; break;
					case 7: block = Blocks.NETHER_GOLD_ORE; break;
					case 8: block = Blocks.LAPIS_ORE; break;
					case 9: block = Blocks.REDSTONE_ORE; break;
					case 10: block = Blocks.DEEPSLATE_COAL_ORE; break;
					case 11: block = Blocks.DEEPSLATE_IRON_ORE; break;
					case 12: block = Blocks.DEEPSLATE_COPPER_ORE; break;
					case 13: block = Blocks.DEEPSLATE_GOLD_ORE; break;
					case 14: block = Blocks.DEEPSLATE_EMERALD_ORE; break;
					case 15: block = Blocks.DEEPSLATE_DIAMOND_ORE; break;
					case 16: block = Blocks.DEEPSLATE_LAPIS_ORE; break;
					case 17: block = Blocks.DEEPSLATE_REDSTONE_ORE; break;
					case 18: block = BlockRegistry.GUNPOWDER_ORE.get(); break;
					case 19: block = BlockRegistry.DEEPSLATE_GUNPOWDER_ORE.get(); break;
					case 20: block = BlockRegistry.URANIUM_ORE.get(); break;
					case 21: block = BlockRegistry.DEEPSLATE_URANIUM_ORE.get(); break;
				}
				if(tnt.availablePos.size() > 0) {
					int rand = new Random().nextInt(tnt.availablePos.size());
					if(tnt.availablePos.get(rand) != null) {
						BlockPos pos = tnt.availablePos.get(rand);
						tnt.availablePos.remove(rand);
						entity.getLevel().setBlockState(pos, block.getDefaultState());
						entity.getLevel().playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1f, 1f);
					}
				}				
			}
		}
		else if(entity instanceof OreTNTMinecart tnt) {
			if(tnt.availablePos.isEmpty()) {
				fillAvailablePos(tnt);
			}
			for (int count = 0; count < 750; count++) {			
				Block block = Blocks.COAL_ORE;
				int random = new Random().nextInt(22);
				switch(random) {
					case 0: block = Blocks.COAL_ORE; break;
					case 1: block = Blocks.IRON_ORE; break;
					case 2: block = Blocks.GOLD_ORE; break;
					case 3: block = Blocks.COPPER_ORE; break;
					case 4: block = Blocks.DIAMOND_ORE; break;
					case 5: block = Blocks.EMERALD_ORE; break;
					case 6: block = Blocks.NETHER_QUARTZ_ORE; break;
					case 7: block = Blocks.NETHER_GOLD_ORE; break;
					case 8: block = Blocks.LAPIS_ORE; break;
					case 9: block = Blocks.REDSTONE_ORE; break;
					case 10: block = Blocks.DEEPSLATE_COAL_ORE; break;
					case 11: block = Blocks.DEEPSLATE_IRON_ORE; break;
					case 12: block = Blocks.DEEPSLATE_COPPER_ORE; break;
					case 13: block = Blocks.DEEPSLATE_GOLD_ORE; break;
					case 14: block = Blocks.DEEPSLATE_EMERALD_ORE; break;
					case 15: block = Blocks.DEEPSLATE_DIAMOND_ORE; break;
					case 16: block = Blocks.DEEPSLATE_LAPIS_ORE; break;
					case 17: block = Blocks.DEEPSLATE_REDSTONE_ORE; break;
					case 18: block = BlockRegistry.GUNPOWDER_ORE.get(); break;
					case 19: block = BlockRegistry.DEEPSLATE_GUNPOWDER_ORE.get(); break;
					case 20: block = BlockRegistry.URANIUM_ORE.get(); break;
					case 21: block = BlockRegistry.DEEPSLATE_URANIUM_ORE.get(); break;
				}
				if(tnt.availablePos.size() > 0) {
					int rand = new Random().nextInt(tnt.availablePos.size());
					if(tnt.availablePos.get(rand) != null) {
						BlockPos pos = tnt.availablePos.get(rand);
						tnt.availablePos.remove(rand);
						entity.getLevel().setBlockState(pos, block.getDefaultState());
						entity.getLevel().playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1f, 1f);
					}
				}
			}
		}
	}
	
	public void fillAvailablePos(PrimedOreTNT tnt) {
		ExplosionHelper.doSphericalExplosion(tnt.getWorld(), tnt.getPos(), 12, new IForEachBlockExplosionEffect() {
			@Override
			public void doBlockExplosion(World level, BlockPos pos, BlockState state, double distance) {
				if (!state.isAir() && state.getBlock().getBlastResistance() < 100 && state.isFullCube(level, pos) && !state.isIn(ConventionalBlockTags.ORES)) {
					tnt.availablePos.add(pos);
				}
			}
		});
	}
	
	public void fillAvailablePos(OreTNTMinecart tnt) {
		ExplosionHelper.doSphericalExplosion(tnt.getWorld(), tnt.getPos(), 12, new IForEachBlockExplosionEffect() {
			@Override
			public void doBlockExplosion(World level, BlockPos pos, BlockState state, double distance) {
				if (!state.isAir() && state.getBlock().getBlastResistance() < 100 && state.isFullCube(level, pos) && !state.isIn(ConventionalBlockTags.ORES)) {
					tnt.availablePos.add(pos);
				}
			}
		});
	}
	
	@Override
	public Block getBlock() {
		return BlockRegistry.ORE_TNT.get();
	}
	
	@Override
	public int getDefaultFuse(IExplosiveEntity entity) {
		return 150;
	}
}

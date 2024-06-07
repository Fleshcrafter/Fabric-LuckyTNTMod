package luckytnt.block;

import org.jetbrains.annotations.Nullable;

import luckytnt.registry.BlockRegistry;
import luckytnt.registry.EntityRegistry;
import luckytntlib.block.LTNTBlock;
import luckytntlib.entity.PrimedLTNT;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class TrollTNTMk2Block extends LTNTBlock{

	public TrollTNTMk2Block(AbstractBlock.Settings properties) {
		super(properties, EntityRegistry.TROLL_TNT_MK2, false);
	}

	@Override
	public PrimedLTNT explode(World level, boolean exploded, double x, double y, double z, @Nullable LivingEntity igniter) throws NullPointerException {
		BlockPos pos = new BlockPos(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z));
    	if(level.getBlockState(pos.up()).getBlock().getBlastResistance() < 200) {
    		level.setBlockState(pos.up(), BlockRegistry.TROLL_TNT_MK2.get().getDefaultState(), 3);
    	}
    	if(level.getBlockState(pos.down()).getBlock().getBlastResistance() < 200) {
    		level.setBlockState(pos.down(), BlockRegistry.TROLL_TNT_MK2.get().getDefaultState(), 3);
    	}
    	if(level.getBlockState(pos.north()).getBlock().getBlastResistance() < 200) {
    		level.setBlockState(pos.north(), BlockRegistry.TROLL_TNT_MK2.get().getDefaultState(), 3);
    	}
    	if(level.getBlockState(pos.east()).getBlock().getBlastResistance() < 200) {
    		level.setBlockState(pos.east(), BlockRegistry.TROLL_TNT_MK2.get().getDefaultState(), 3);
    	}
    	if(level.getBlockState(pos.south()).getBlock().getBlastResistance() < 200) {
    		level.setBlockState(pos.south(), BlockRegistry.TROLL_TNT_MK2.get().getDefaultState(), 3);
    	}
    	if(level.getBlockState(pos.west()).getBlock().getBlastResistance() < 200) {
    		level.setBlockState(pos.west(), BlockRegistry.TROLL_TNT_MK2.get().getDefaultState(), 3);
    	}
    	return super.explode(level, exploded, x, y, z, igniter);
	}
	
    @Override
    public BlockState onBreak(World level, BlockPos pos, BlockState state, PlayerEntity player) {
		explode(level, false, pos.getX(), pos.getY(), pos.getZ(), player);
    	return super.onBreak(level, pos, state, player);
    }
}

package luckytnt.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class GunpowderOreBlock extends ExperienceDroppingBlock {
	
	public GunpowderOreBlock(AbstractBlock.Settings properties) {
		super(UniformIntProvider.create(2, 5), properties);
	}
	
	@SuppressWarnings("deprecation")
	@Override
    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        if (player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem)
            return tieredItem.getTier().getLevel() >= 1;
        return false;
    }
}

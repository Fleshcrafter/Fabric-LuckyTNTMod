package luckytnt.entity;

import luckytnt.network.ClientboundStringNBTPacket;
import luckytnt.network.PacketHandler;
import luckytnt.tnteffects.StructureTNTEffect;
import luckytntlib.entity.PrimedLTNT;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class PrimedStructureTNT extends PrimedLTNT{
	
	public PrimedStructureTNT(EntityType<PrimedLTNT> type, World level) {
		super(type, level, new StructureTNTEffect());
	}
	
	@Override
	public void onAddedToWorld() {
		if(!level().isClientSide()) {
      		PacketHandler.CHANNEL.send(new ClientboundStringNBTPacket("structure", getPersistentData().getString("structure"), getId()), PacketDistributor.TRACKING_ENTITY.with(this));
      	}
	}
}

package luckytnt.network;

import luckytnt.LuckyTNTMod;
import luckytntlib.network.LuckyTNTPacket;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class HydrogenBombS2CPacket implements LuckyTNTPacket {
	
	public static Identifier NAME = new Identifier(LuckyTNTMod.MODID, "hydrogen_bomb_s2c");
	
	public final int entityId;
	
	public HydrogenBombS2CPacket(int entityId) {
		this.entityId = entityId;
	}

	@Override
	public PacketByteBuf toByteBuf() {
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeInt(entityId);
		return buf;
	}

	@Override
	public Identifier getName() {
		return NAME;
	}
}

package luckytnt.network;

import luckytnt.LevelVariables;
import luckytnt.LuckyTNTMod;
import luckytntlib.network.LuckyTNTPacket;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class LevelVariablesS2CPacket implements LuckyTNTPacket {

	public static Identifier NAME = new Identifier(LuckyTNTMod.MODID, "level_variables_s2c");
	
	public final LevelVariables variables;
	
	public LevelVariablesS2CPacket(LevelVariables variables) {
		this.variables = variables;
	}

	@Override
	public PacketByteBuf toByteBuf() {
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeNbt(variables.writeNbt(new NbtCompound()));
		return buf;
	}

	@Override
	public Identifier getName() {
		return NAME;
	}
}

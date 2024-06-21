package luckytnt.network;

import luckytnt.LuckyTNTMod;
import luckytntlib.network.ClientReadyC2SPacket;
import net.minecraft.util.Identifier;

public class LuckyTNTClientReadyC2SPacket extends ClientReadyC2SPacket {

	public static Identifier NAME = new Identifier(LuckyTNTMod.MODID, "lucky_tnt_client_ready_c2s");
	
	public LuckyTNTClientReadyC2SPacket() {
	}
	
	@Override
	public Identifier getName() {
		return NAME;
	}
}

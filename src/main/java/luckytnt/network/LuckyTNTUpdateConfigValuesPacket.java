package luckytnt.network;

import java.util.List;

import luckytnt.LuckyTNTMod;
import luckytntlib.config.common.Config.ConfigValue;
import luckytntlib.network.UpdateConfigValuesPacket;
import net.minecraft.util.Identifier;

public class LuckyTNTUpdateConfigValuesPacket extends UpdateConfigValuesPacket {

	public static Identifier NAME = new Identifier(LuckyTNTMod.MODID, "lucky_tnt_update_config_values");
	
	public LuckyTNTUpdateConfigValuesPacket(List<ConfigValue<?>> configValues) {
		super(configValues);
	}

	@Override
	public Identifier getName() {
		return NAME;
	}
}

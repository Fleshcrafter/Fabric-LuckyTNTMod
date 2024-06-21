package luckytnt.registry;

import luckytnt.LevelVariables;
import luckytnt.client.ClientAccess;
import luckytnt.config.LuckyTNTConfigValues;
import luckytnt.network.HydrogenBombS2CPacket;
import luckytnt.network.LevelVariablesS2CPacket;
import luckytnt.network.LuckyTNTUpdateConfigValuesPacket;
import luckytntlib.config.common.Config;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.PlayChannelHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;

public class ClientNetworkRegistry {
	
	private static final PlayChannelHandler UPDATE_S2C = new PlayChannelHandler() {
		
		@Override
		public void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
			NbtCompound tag = buf.readNbt();
			
			client.execute(() -> {
				Config.writeToValues(tag, LuckyTNTConfigValues.CONFIG.getConfigValues());
			});
		}
	};
	private static final PlayChannelHandler HYDROGEN_BOMB_S2C = new PlayChannelHandler() {
		
		@Override
		public void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
			int entId = buf.readInt();
			
			client.execute(() -> {
				ClientAccess.displayHydrogenBombParticles(entId);
			});
		}
	};
	private static final PlayChannelHandler LEVEL_VARIABLES_S2C = new PlayChannelHandler() {
		
		@Override
		public void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
			NbtCompound tag = buf.readNbt();
			LevelVariables variables = new LevelVariables();
			variables.read(tag);
			
			client.execute(() -> {
				ClientAccess.syncLevelVariables(variables);
			});
		}
	};
	
	
	public static void init() {
		ClientPlayNetworking.registerGlobalReceiver(LuckyTNTUpdateConfigValuesPacket.NAME, UPDATE_S2C);
		ClientPlayNetworking.registerGlobalReceiver(HydrogenBombS2CPacket.NAME, HYDROGEN_BOMB_S2C);
		ClientPlayNetworking.registerGlobalReceiver(LevelVariablesS2CPacket.NAME, LEVEL_VARIABLES_S2C);
	}
}

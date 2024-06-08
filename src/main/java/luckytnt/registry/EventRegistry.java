package luckytnt.registry;

import luckytnt.event.LevelEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;

public class EventRegistry {

	public static void init() {
		ServerTickEvents.START_WORLD_TICK.register(new ServerTickEvents.StartWorldTick() {
			
			@Override
			public void onStartTick(ServerWorld world) {
				LevelEvents.onLevelUpdate(world);
			}
		});
	}
}

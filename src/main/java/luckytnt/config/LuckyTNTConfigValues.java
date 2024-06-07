package luckytnt.config;

import luckytnt.LuckyTNTMod;
import luckytnt.util.CustomTNTConfig;
import luckytntlib.config.common.Config;

public class LuckyTNTConfigValues {
	
	public static Config CONFIG;
	
	public static Config.IntValue ISLAND_HEIGHT = new Config.IntValue(50, 20, 160, "islandHeight");
	public static Config.IntValue DROP_HEIGHT = new Config.IntValue(200, 60, 400, "dropHeight");
	public static Config.IntValue MAXIMUM_DISASTER_TIME = new Config.IntValue(12, 2, 24, "maximumTime");
	public static Config.DoubleValue AVERAGE_DIASTER_INTENSITY = new Config.DoubleValue(1d, 1d, 10d, "averageIntensity");
	
	public static Config.EnumValue<CustomTNTConfig> CUSTOM_TNT_FIRST_EXPLOSION = new Config.EnumValue<CustomTNTConfig>(CustomTNTConfig.NO_EXPLOSION, "firstExplosionType", CustomTNTConfig.values());
	public static Config.IntValue CUSTOM_TNT_FIRST_EXPLOSION_INTENSITY = new Config.IntValue(1, 1, 20, "firstExplosionIntensity");
	
	public static Config.EnumValue<CustomTNTConfig> CUSTOM_TNT_SECOND_EXPLOSION = new Config.EnumValue<CustomTNTConfig>(CustomTNTConfig.NO_EXPLOSION, "secondExplosionType", CustomTNTConfig.values());
	public static Config.IntValue CUSTOM_TNT_SECOND_EXPLOSION_INTENSITY = new Config.IntValue(1, 1, 20, "secondExplosionIntensity");
	
	public static Config.EnumValue<CustomTNTConfig> CUSTOM_TNT_THIRD_EXPLOSION = new Config.EnumValue<CustomTNTConfig>(CustomTNTConfig.NO_EXPLOSION, "thirdExplosionType", CustomTNTConfig.values());
	public static Config.IntValue CUSTOM_TNT_THIRD_EXPLOSION_INTENSITY = new Config.IntValue(1, 1, 20, "thirdExplosionIntensity");

	public static Config.BooleanValue SEASON_EVENTS_ALWAYS_ACTIVE = new Config.BooleanValue(false, "seasonEventsAlwaysActive");
	
	public static Config.BooleanValue RENDER_CONTAMINATED_OVERLAY = new Config.BooleanValue(true, "renderContaminatedOverlay");
	
	public static Config.BooleanValue PRESENT_DROP_DESTROY_BLOCKS = new Config.BooleanValue(true, "presentDropDestroy");
	
	public static void registerConfig() {
		CONFIG = Config.Builder.of(LuckyTNTMod.MODID)
				.addConfigValue(ISLAND_HEIGHT)
				.addConfigValue(DROP_HEIGHT)
				.addConfigValue(MAXIMUM_DISASTER_TIME)
				.addConfigValue(AVERAGE_DIASTER_INTENSITY)
				.addConfigValue(CUSTOM_TNT_FIRST_EXPLOSION)
				.addConfigValue(CUSTOM_TNT_FIRST_EXPLOSION_INTENSITY)
				.addConfigValue(CUSTOM_TNT_SECOND_EXPLOSION)
				.addConfigValue(CUSTOM_TNT_SECOND_EXPLOSION_INTENSITY)
				.addConfigValue(CUSTOM_TNT_THIRD_EXPLOSION)
				.addConfigValue(CUSTOM_TNT_THIRD_EXPLOSION_INTENSITY)
				.addConfigValue(SEASON_EVENTS_ALWAYS_ACTIVE)
				.addConfigValue(RENDER_CONTAMINATED_OVERLAY)
				.addConfigValue(PRESENT_DROP_DESTROY_BLOCKS)
				.build();
		
		CONFIG.init();
	}
}

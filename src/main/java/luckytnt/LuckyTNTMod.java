package luckytnt;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import luckytntlib.registry.RegistryHelper;

public class LuckyTNTMod implements ModInitializer {

	public static final String MODID = "luckytntmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final RegistryHelper RH = new RegistryHelper(MODID);

	@Override
	public void onInitialize() {
		/**FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        	SoundRegistry.SOUNDS.register(bus);
    		entityRegistry.register(bus);
    		blockEntityRegistry.register(bus);
    		blockRegistry.register(bus);
    		itemRegistry.register(bus);
    		effectRegistry.register(bus);
    		featureRegistry.register(bus);
        	MinecraftForge.EVENT_BUS.register(this);
        	LuckyTNTConfigs.register();
        	ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory(new BiFunction<Minecraft, Screen, Screen>() {		
			@Override
			public Screen apply(Minecraft mc, Screen screen) {
				return new ConfigScreen();
			}
		}));*/
	}
}
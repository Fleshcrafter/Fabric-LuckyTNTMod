package luckytnt;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import luckytnt.client.ClientAccess;
import luckytnt.config.LuckyTNTConfigValues;
import luckytnt.registry.AttributeRegistry;
import luckytnt.registry.BlockRegistry;
import luckytnt.registry.ColorRegistry;
import luckytnt.registry.CommandRegistry;
import luckytnt.registry.EffectRegistry;
import luckytnt.registry.EntityRegistry;
import luckytnt.registry.EventRegistry;
import luckytnt.registry.FeatureRegistry;
import luckytnt.registry.ItemRegistry;
import luckytnt.registry.LuckyTNTTabs;
import luckytnt.registry.ModelRegistry;
import luckytnt.registry.RendererRegistry;
import luckytnt.registry.SoundRegistry;
import luckytntlib.registry.RegistryHelper;

public class LuckyTNTMod implements ModInitializer {

	public static final String MODID = "luckytntmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final RegistryHelper RH = new RegistryHelper(MODID);

	@Override
	public void onInitialize() {
		SoundRegistry.init();
		EntityRegistry.init();
		AttributeRegistry.init();
		BlockRegistry.init();
		ItemRegistry.init();
		LuckyTNTTabs.init();
		EffectRegistry.init();
		FeatureRegistry.init();
		CommandRegistry.init();
		EventRegistry.init();
		
		if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			ColorRegistry.init();
			ModelRegistry.init();
			RendererRegistry.init();
			
			RH.registerConfigScreenFactory(Text.literal("Lucky TNT Mod"), ClientAccess.getFactory());
		}
		
		LuckyTNTConfigValues.registerConfig();
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
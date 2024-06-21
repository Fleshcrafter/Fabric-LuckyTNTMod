package luckytnt.registry;

import java.util.List;
import java.util.function.Supplier;

import luckytnt.LuckyTNTMod;
import luckytnt.item.DeathRayRayItem;
import luckytnt.item.VacuumCleaner;
import luckytntlib.item.LDynamiteItem;
import luckytntlib.item.LTNTMinecartItem;
import luckytntlib.item.LuckyDynamiteItem;
import net.minecraft.client.item.TooltipType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ItemRegistry {

	//Dynamite
	public static final Supplier<LDynamiteItem> DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("dynamite", EntityRegistry.DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> DYNAMITE_X5 = LuckyTNTMod.RH.registerDynamiteItem("dynamite_x5", EntityRegistry.DYNAMITE_X5, "dy");
	public static final Supplier<LDynamiteItem> DYNAMITE_X20 = LuckyTNTMod.RH.registerDynamiteItem("dynamite_x20", EntityRegistry.DYNAMITE_X20, "dy");
	public static final Supplier<LDynamiteItem> DYNAMITE_X100 = LuckyTNTMod.RH.registerDynamiteItem("dynamite_x100", EntityRegistry.DYNAMITE_X100, "dy");
	public static final Supplier<LDynamiteItem> DYNAMITE_X500 = LuckyTNTMod.RH.registerDynamiteItem("dynamite_x500", EntityRegistry.DYNAMITE_X500, "dy");
	public static final Supplier<LDynamiteItem> FIRE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("fire_dynamite", EntityRegistry.FIRE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> SNOW_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("snow_dynamite", EntityRegistry.SNOW_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> DYNAMITE_FIREWORK = LuckyTNTMod.RH.registerDynamiteItem("dynamite_firework", EntityRegistry.DYNAMITE_FIREWORK, "dy");
	public static final Supplier<LDynamiteItem> NUCLEAR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("nuclear_dynamite", EntityRegistry.NUCLEAR_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> FREEZE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("freeze_dynamite", EntityRegistry.FREEZE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> FLOATING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("floating_dynamite", EntityRegistry.FLOATING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> SPHERE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("sphere_dynamite", EntityRegistry.SPHERE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> FLAT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("flat_dynamite", EntityRegistry.FLAT_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> MININGFLAT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("miningflat_dynamite", EntityRegistry.MININGFLAT_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> VAPORIZE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("vaporize_dynamite", EntityRegistry.VAPORIZE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> METEOR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("meteor_dynamite", EntityRegistry.METEOR_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> CUBIC_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("cubic_dynamite", EntityRegistry.CUBIC_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> GROVE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("grove_dynamite", EntityRegistry.GROVE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ENDER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("ender_dynamite", EntityRegistry.ENDER_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ARROW_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("arrow_dynamite", EntityRegistry.ARROW_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> LIGHTNING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("lightning_dynamite", EntityRegistry.LIGHTNING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> DIGGING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("digging_dynamite", EntityRegistry.DIGGING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> COMPACT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("compact_dynamite", EntityRegistry.COMPACT_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ANIMAL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("animal_dynamite", EntityRegistry.ANIMAL_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> OCEAN_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("ocean_dynamite", EntityRegistry.OCEAN_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> SPIRAL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("spiral_dynamite", EntityRegistry.SPIRAL_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> CHEMICAL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("chemical_dynamite", EntityRegistry.CHEMICAL_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> REACTION_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("reaction_dynamite", EntityRegistry.REACTION_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> HELLFIRE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("hellfire_dynamite", EntityRegistry.HELLFIRE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> FLOATING_ISLAND_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("floating_island_dynamite", EntityRegistry.FLOATING_ISLAND_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ERUPTING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("erupting_dynamite", EntityRegistry.ERUPTING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> SHATTERPROOF_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("shatterproof_dynamite", EntityRegistry.SHATTERPROOF_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> LAVA_OCEAN_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("lava_ocean_dynamite", EntityRegistry.LAVA_OCEAN_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> WOOL_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("wool_dynamite", EntityRegistry.WOOL_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> NUCLEAR_WASTE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("nuclear_waste_dynamite", EntityRegistry.NUCLEAR_WASTE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> TIMER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("timer_dynamite", EntityRegistry.TIMER_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> GRAVITY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("gravity_dynamite", EntityRegistry.GRAVITY_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> WITHERING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("withering_dynamite", EntityRegistry.WITHERING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> SENSOR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("sensor_dynamite", EntityRegistry.SENSOR_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> RAINBOW_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("rainbow_dynamite", EntityRegistry.RAINBOW_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ROULETTE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("roulette_dynamite", EntityRegistry.ROULETTE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> BOUNCING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("bouncing_dynamite", EntityRegistry.BOUNCING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> IGNITER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("igniter_dynamite", EntityRegistry.IGNITER_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> MULTIPLYING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("multiplying_dynamite", EntityRegistry.MULTIPLYING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> RANDOM_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("random_dynamite", EntityRegistry.RANDOM_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> HOMING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("homing_dynamite", EntityRegistry.HOMING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> PULSE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("pulse_dynamite", EntityRegistry.PULSE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> PHYSICS_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("physics_dynamite", EntityRegistry.PHYSICS_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> PICKY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("picky_dynamite", EntityRegistry.PICKY_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> CLUSTER_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("cluster_dynamite", EntityRegistry.CLUSTER_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> TUNNELING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("tunneling_dynamite", EntityRegistry.TUNNELING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> XRAY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("xray_dynamite", EntityRegistry.XRAY_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> FARMING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("farming_dynamite", EntityRegistry.FARMING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> BIG_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("big_dynamite", EntityRegistry.BIG_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ICE_METEOR_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("ice_meteor_dynamite", EntityRegistry.ICE_METEOR_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> HONEY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("honey_dynamite", EntityRegistry.HONEY_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ULTRALIGHT_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("ultralight_dynamite", EntityRegistry.ULTRALIGHT_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> ACCELERATING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("accelerating_dynamite", EntityRegistry.ACCELERATING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> NETHER_GROVE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("nether_grove_dynamite", EntityRegistry.NETHER_GROVE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> LUSH_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("lush_dynamite", EntityRegistry.LUSH_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> DRIPSTONE_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("dripstone_dynamite", EntityRegistry.DRIPSTONE_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> END_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("end_dynamite", EntityRegistry.END_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> CHRISTMAS_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("christmas_dynamite", EntityRegistry.CHRISTMAS_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> PRISM_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("prism_dynamite", EntityRegistry.PRISM_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> RING_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("ring_dynamite", EntityRegistry.RING_DYNAMITE, "dy");
	public static final Supplier<LDynamiteItem> SCULK_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem("sculk_dynamite", EntityRegistry.SCULK_DYNAMITE, "dy");
	
	public static final Supplier<LDynamiteItem> LUCKY_DYNAMITE = LuckyTNTMod.RH.registerDynamiteItem(LuckyTNTMod.MODID, "lucky_dynamite", () -> new LuckyDynamiteItem(new Item.Settings(), LuckyTNTMod.RH.dynamiteLists.get("dy")), "dy", false, true);
	
	//Minecart
	public static final Supplier<LTNTMinecartItem> TNT_X5_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x5_minecart", () -> EntityRegistry.TNT_X5_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> TNT_X20_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x20_minecart", () -> EntityRegistry.TNT_X20_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> TNT_X100_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x100_minecart", () -> EntityRegistry.TNT_X100_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> TNT_X500_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("tnt_x500_minecart", () -> EntityRegistry.TNT_X500_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> DIGGING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("digging_tnt_minecart", () -> EntityRegistry.DIGGING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> DRILLING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("drilling_tnt_minecart", () -> EntityRegistry.DRILLING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> SPHERE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("sphere_tnt_minecart", () -> EntityRegistry.SPHERE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> FLOATING_ISLAND_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("floating_island_minecart", () -> EntityRegistry.FLOATING_ISLAND_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> OCEAN_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ocean_tnt_minecart", () -> EntityRegistry.OCEAN_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> HELLFIRE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("hellfire_tnt_minecart", () -> EntityRegistry.HELLFIRE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> FIRE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("fire_tnt_minecart", () -> EntityRegistry.FIRE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> SNOW_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("snow_tnt_minecart", () -> EntityRegistry.SNOW_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> FREEZE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("freeze_tnt_minecart", () -> EntityRegistry.FREEZE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> VAPORIZE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("vaporize_tnt_minecart", () -> EntityRegistry.VAPORIZE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> GRAVITY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("gravity_tnt_minecart", () -> EntityRegistry.GRAVITY_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> LIGHTNING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lightning_tnt_minecart", () -> EntityRegistry.LIGHTNING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> CUBIC_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("cubic_tnt_minecart", () -> EntityRegistry.CUBIC_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ARROW_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("arrow_tnt_minecart", () -> EntityRegistry.ARROW_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> TIMER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("timer_tnt_minecart", () -> EntityRegistry.TIMER_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> FLAT_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("flat_tnt_minecart", () -> EntityRegistry.FLAT_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> MININGFLAT_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("miningflat_tnt_minecart", () -> EntityRegistry.MININGFLAT_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> COMPACT_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("compact_tnt_minecart", () -> EntityRegistry.COMPACT_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ANIMAL_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("animal_tnt_minecart", () -> EntityRegistry.ANIMAL_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ERUPTING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("erupting_tnt_minecart", () -> EntityRegistry.ERUPTING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> GROVE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("grove_tnt_minecart", () -> EntityRegistry.GROVE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ENDER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ender_tnt_minecart", () -> EntityRegistry.ENDER_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> METEOR_SHOWER_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("meteor_shower_minecart", () -> EntityRegistry.METEOR_SHOWER_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> INVERTED_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("inverted_tnt_minecart", () -> EntityRegistry.INVERTED_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> NUCLEAR_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("nuclear_tnt_minecart", () -> EntityRegistry.NUCLEAR_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> CHEMICAL_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("chemical_tnt_minecart", () -> EntityRegistry.CHEMICAL_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> REACTION_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("reaction_tnt_minecart", () -> EntityRegistry.REACTION_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> VILLAGE_DEFENSE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("village_defense_minecart", () -> EntityRegistry.VILLAGE_DEFENSE_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ZOMBIE_APOCALYPSE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("zombie_apocalypse_minecart", () -> EntityRegistry.ZOMBIE_APOCALYPSE_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> SHATTERPROOF_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("shatterproof_tnt_minecart", () -> EntityRegistry.SHATTERPROOF_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> LAVA_OCEAN_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lava_ocean_tnt_minecart", () -> EntityRegistry.LAVA_OCEAN_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> WOOL_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("wool_tnt_minecart", () -> EntityRegistry.WOOL_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> SAY_GOODBYE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("say_goodbye_minecart", () -> EntityRegistry.SAY_GOODBYE_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ANGRY_MINERS_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("angry_miners_minecart", () -> EntityRegistry.ANGRY_MINERS_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> WITHERING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("withering_tnt_minecart", () -> EntityRegistry.WITHERING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> PUMPKIN_BOMB_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("pumpkin_bomb_minecart", () -> EntityRegistry.PUMPKIN_BOMB_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> NUCLEAR_WASTE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("nuclear_waste_tnt_minecart", () -> EntityRegistry.NUCLEAR_WASTE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> AIR_STRIKE_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("air_strike_minecart", () -> EntityRegistry.AIR_STRIKE_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> SPAMMING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("spamming_tnt_minecart", () -> EntityRegistry.SPAMMING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ROULETTE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("roulette_tnt_minecart", () -> EntityRegistry.ROULETTE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> XRAY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("xray_tnt_minecart", () -> EntityRegistry.XRAY_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> FARMING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("farming_tnt_minecart", () -> EntityRegistry.FARMING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> SWAP_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("swap_tnt_minecart", () -> EntityRegistry.SWAP_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> IGNITER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("igniter_tnt_minecart", () -> EntityRegistry.IGNITER_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> BUTTER_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("butter_tnt_minecart", () -> EntityRegistry.BUTTER_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> PHYSICS_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("physics_tnt_minecart", () -> EntityRegistry.PHYSICS_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> ORE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ore_tnt_minecart", () -> EntityRegistry.ORE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> REDSTONE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("redstone_tnt_minecart", () -> EntityRegistry.REDSTONE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> RANDOM_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("random_tnt_minecart", () -> EntityRegistry.RANDOM_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> TURRET_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("turret_tnt_minecart", () -> EntityRegistry.TURRET_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> PULSE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("pulse_tnt_minecart", () -> EntityRegistry.PULSE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> PICKY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("picky_tnt_minecart", () -> EntityRegistry.PICKY_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> BIG_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("big_tnt_minecart", () -> EntityRegistry.BIG_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> HONEY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("honey_tnt_minecart", () -> EntityRegistry.HONEY_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> EATING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("eating_tnt_minecart", () -> EntityRegistry.EATING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> LUSH_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lush_tnt_minecart", () -> EntityRegistry.LUSH_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> GEODE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("geode_tnt_minecart", () -> EntityRegistry.GEODE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> NETHER_GROVE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("nether_grove_tnt_minecart", () -> EntityRegistry.NETHER_GROVE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> DRIPSTONE_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("dripstone_tnt_minecart", () -> EntityRegistry.DRIPSTONE_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> END_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("end_tnt_minecart", () -> EntityRegistry.END_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> PRISM_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("prism_tnt_minecart", () -> EntityRegistry.PRISM_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> RING_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("ring_tnt_minecart", () -> EntityRegistry.RING_TNT_MINECART, "m");
	public static final Supplier<LTNTMinecartItem> SCULK_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("sculk_tnt_minecart", () -> EntityRegistry.SCULK_TNT_MINECART, "m");
	
	public static final Supplier<LTNTMinecartItem> LUCKY_TNT_MINECART = LuckyTNTMod.RH.registerTNTMinecartItem("lucky_tnt_minecart", () -> new LTNTMinecartItem(new Item.Settings().maxCount(1), () -> EntityRegistry.LUCKY_TNT_MINECART), "m", false, true);
	
	//Other
	public static final Supplier<Item> NUCLEAR_WASTE = registerItem("nuclear_waste", () -> new BlockItem(BlockRegistry.NUCLEAR_WASTE.get(), new Item.Settings()));
	public static final Supplier<Item> RED_CANDY = registerItem("red_candy", () -> new Item(new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().snack().nutrition(1).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 100, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 0), 1).build())));
	public static final Supplier<Item> GREEN_CANDY = registerItem("green_candy", () -> new Item(new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().snack().nutrition(1).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2), 1).build())));
	public static final Supplier<Item> BLUE_CANDY = registerItem("blue_candy", () -> new Item(new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().snack().nutrition(1).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 0), 1).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 500, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 0), 0).build())));
	public static final Supplier<Item> PURPLE_CANDY = registerItem("purple_candy", () -> new Item(new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().snack().nutrition(1).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 3), 1).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2000, 1), 1).build())));
	public static final Supplier<Item> YELLOW_CANDY = registerItem("yellow_candy", () -> new Item(new Item.Settings().food(new FoodComponent.Builder().alwaysEdible().snack().nutrition(1).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 2000, 3), 1).build())));;
	public static final Supplier<Item> URANIUM_INGOT = registerItem("uranium_ingot", () -> new Item(new Item.Settings()));
	public static final Supplier<Item> ANTIMATTER = registerItem("antimatter", () -> new Item(new Item.Settings().rarity(Rarity.EPIC)) {
		@Override
		public void appendTooltip(ItemStack stack, Item.TooltipContext level, List<Text> components, TooltipType flag) {
			super.appendTooltip(stack, level, components, flag);
			components.add(Text.translatable("item.antimatter.info"));
		}
	});
	public static final Supplier<Item> URANIUM_ORE = registerItem("uranium_ore", () -> new BlockItem(BlockRegistry.URANIUM_ORE.get(), new Item.Settings()));
	public static final Supplier<Item> DEEPSLATE_URANIUM_ORE = registerItem("deepslate_uranium_ore", () -> new BlockItem(BlockRegistry.DEEPSLATE_URANIUM_ORE.get(), new Item.Settings()));
	public static final Supplier<Item> GUNPOWDER_ORE = registerItem("gunpowder_ore", () -> new BlockItem(BlockRegistry.GUNPOWDER_ORE.get(), new Item.Settings()));
	public static final Supplier<Item> DEEPSLATE_GUNPOWDER_ORE = registerItem("deepslate_gunpowder_ore", () -> new BlockItem(BlockRegistry.DEEPSLATE_GUNPOWDER_ORE.get(), new Item.Settings()));
	public static final Supplier<Item> CONFIGURATION_WAND = registerItem("configuration_wand", () -> new Item(new Item.Settings().maxCount(1)) {
		@Override
		public void appendTooltip(ItemStack stack, Item.TooltipContext level, List<Text> components, TooltipType flag) {
			super.appendTooltip(stack, level, components, flag);
			components.add(Text.translatable("item.configuration_wand.info"));
		}
	});
	public static final Supplier<Item> OBSIDIAN_RAIL = registerItem("obsidian_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_RAIL.get(), new Item.Settings()) {
		@Override
		public void appendTooltip(ItemStack stack, Item.TooltipContext level, List<Text> components, TooltipType flag) {
			super.appendTooltip(stack, level, components, flag);
			components.add(Text.translatable("item.obsidian_rail.info"));
		}
	});
	public static final Supplier<Item> OBSIDIAN_POWERED_RAIL = registerItem("obsidian_powered_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_POWERED_RAIL.get(), new Item.Settings()) {
		@Override
		public void appendTooltip(ItemStack stack, Item.TooltipContext level, List<Text> components, TooltipType flag) {
			super.appendTooltip(stack, level, components, flag);
			components.add(Text.translatable("item.obsidian_rail.info"));
		}
	});
	public static final Supplier<Item> OBSIDIAN_ACTIVATOR_RAIL = registerItem("obsidian_activator_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_ACTIVATOR_RAIL.get(), new Item.Settings()) {
		@Override
		public void appendTooltip(ItemStack stack, Item.TooltipContext level, List<Text> components, TooltipType flag) {
			super.appendTooltip(stack, level, components, flag);
			components.add(Text.translatable("item.obsidian_rail.info"));
		}
	});
	public static final Supplier<Item> OBSIDIAN_DETECTOR_RAIL = registerItem("obsidian_detector_rail", () -> new BlockItem(BlockRegistry.OBSIDIAN_DETECTOR_RAIL.get(),new Item.Settings()) {
		@Override
		public void appendTooltip(ItemStack stack, Item.TooltipContext level, List<Text> components, TooltipType flag) {
			super.appendTooltip(stack, level, components, flag);
			components.add(Text.translatable("item.obsidian_rail.info"));
		}
	});
	public static final Supplier<LDynamiteItem> DEATH_RAY_RAY = LuckyTNTMod.RH.registerDynamiteItem(LuckyTNTMod.MODID, "death_ray_ray", () -> new DeathRayRayItem(), "none", false, true);
	public static final Supplier<Item> VACUUM_CLEANER = registerItem("vacuum_cleaner", () -> new VacuumCleaner());
	public static final Supplier<Item> TOXIC_STONE = registerItem("toxic_stone", () -> new BlockItem(BlockRegistry.TOXIC_STONE.get(), new Item.Settings()));
	
	public static Supplier<Item> registerItem(String name, Supplier<Item> itemSupplier) {
		Item ritem = Registry.register(Registries.ITEM, new Identifier(LuckyTNTMod.MODID, name), itemSupplier.get());
		return () -> ritem;
	}
	
	public static void init() {}
}

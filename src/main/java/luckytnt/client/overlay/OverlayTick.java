package luckytnt.client.overlay;

import java.lang.reflect.Field;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import luckytnt.config.LuckyTNTConfigValues;
import luckytnt.registry.EffectRegistry;
import luckytntlib.util.LuckyTNTEntityExtension;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.LayeredDrawer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class OverlayTick {

private static float contaminatedAmount = 0;
	
	@SuppressWarnings("resource")
	public static void onOverlayRender(DrawContext graphics) {
		if(MinecraftClient.getInstance().player != null) {
			ClientPlayerEntity player = MinecraftClient.getInstance().player;
			int w = graphics.getScaledWindowWidth();
			int h = graphics.getScaledWindowHeight();
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.blendFuncSeparate(GlStateManager.SrcFactor.SRC_ALPHA, GlStateManager.DstFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SrcFactor.ONE, GlStateManager.DstFactor.ZERO);
			if(player instanceof LuckyTNTEntityExtension lplayer) {
				if(lplayer.getAdditionalPersistentData().getInt("freezeTime") > 0 && !player.hasStatusEffect(RegistryEntry.of(EffectRegistry.CONTAMINATED_EFFECT.get()))) {
					RenderSystem.setShaderColor(1f, 1f, 1f, (float)(lplayer.getAdditionalPersistentData().getInt("freezeTime")) / 1200f);
					RenderSystem.setShaderTexture(0, new Identifier("luckytntmod:textures/powder_snow_outline.png"));
					graphics.drawTexture(new Identifier("luckytntmod:textures/powder_snow_outline.png"), 0, 0, 0, 0, w, h, w, h);
				} else if(player.hasStatusEffect(RegistryEntry.of(EffectRegistry.CONTAMINATED_EFFECT.get())) && LuckyTNTConfigValues.RENDER_CONTAMINATED_OVERLAY.get()) {
					RenderSystem.setShaderColor(1f, 1f, 1f, contaminatedAmount);
					RenderSystem.setShaderTexture(0, new Identifier("luckytntmod:textures/contaminated_outline.png"));
					graphics.drawTexture(new Identifier("luckytntmod:textures/contaminated_outline.png"), 0, 0, 0, 0, w, h, w, h);
					contaminatedAmount = MathHelper.clamp(contaminatedAmount + 0.025f, 0f, 1f);
				} else if(contaminatedAmount > 0){
					RenderSystem.setShaderColor(1f, 1f, 1f, contaminatedAmount);
					RenderSystem.setShaderTexture(0, new Identifier("luckytntmod:textures/contaminated_outline.png"));
					graphics.drawTexture(new Identifier("luckytntmod:textures/contaminated_outline.png"), 0, 0, 0, 0, w, h, w, h);
					contaminatedAmount = MathHelper.clamp(contaminatedAmount - 0.025f, 0f, 1f);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.disableBlend();
			RenderSystem.enableDepthTest();
			RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
		}
	}
	
	public static void onGameStart() {
		MinecraftClient minecraft = MinecraftClient.getInstance();
		InGameHud gui = minecraft.inGameHud;
		LayeredDrawer.Layer layer = new LayeredDrawer.Layer() {
			
			@Override
			public void render(DrawContext context, float tickDelta) {
				onOverlayRender(context);
			}
		};	
		
		try {
			loop: for(Field field : InGameHud.class.getDeclaredFields()) {
				field.setAccessible(true);

				if(field.get(gui) instanceof LayeredDrawer layers) {
					layers.addLayer(layer);
					break loop;
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

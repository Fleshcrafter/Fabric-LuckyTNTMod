package luckytnt.client.overlay;

public class OverlayTick {
	
	/*private static float contaminatedAmount = 0;
	
	public static void onOverlayRender(DrawContext event) {
		PlayerEntity player = MinecraftClient.getInstance().player;
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		if(player.getPersistentData().getInt("freezeTime") > 0 && !player.hasEffect(EffectRegistry.CONTAMINATED_EFFECT.get())) {
			RenderSystem.setShaderColor(1f, 1f, 1f, (float)(player.getPersistentData().getInt("freezeTime")) / 1200f);
			RenderSystem.setShaderTexture(0, new ResourceLocation("luckytntmod:textures/powder_snow_outline.png"));
			event.getGuiGraphics().blit(new ResourceLocation("luckytntmod:textures/powder_snow_outline.png"), 0, 0, 0, 0, w, h, w, h);
		} else if(player.hasEffect(EffectRegistry.CONTAMINATED_EFFECT.get()) && LuckyTNTConfigValues.RENDER_CONTAMINATED_OVERLAY.get()) {
			RenderSystem.setShaderColor(1f, 1f, 1f, contaminatedAmount);
			RenderSystem.setShaderTexture(0, new ResourceLocation("luckytntmod:textures/contaminated_outline.png"));
			event.getGuiGraphics().blit(new ResourceLocation("luckytntmod:textures/contaminated_outline.png"), 0, 0, 0, 0, w, h, w, h);
			contaminatedAmount = Mth.clamp(contaminatedAmount + 0.025f, 0f, 1f);
		} else if(contaminatedAmount > 0){
			RenderSystem.setShaderColor(1f, 1f, 1f, contaminatedAmount);
			RenderSystem.setShaderTexture(0, new ResourceLocation("luckytntmod:textures/contaminated_outline.png"));
			event.getGuiGraphics().blit(new ResourceLocation("luckytntmod:textures/contaminated_outline.png"), 0, 0, 0, 0, w, h, w, h);
			contaminatedAmount = Mth.clamp(contaminatedAmount - 0.025f, 0f, 1f);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
		RenderSystem.enableDepthTest();
		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
	}*/
}

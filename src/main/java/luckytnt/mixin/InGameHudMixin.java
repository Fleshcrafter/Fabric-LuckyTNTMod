package luckytnt.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.systems.RenderSystem;

import luckytnt.config.LuckyTNTConfigValues;
import luckytnt.registry.EffectRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
	
	@Shadow
	protected abstract void renderOverlay(DrawContext context, Identifier texture, float opacity);
	
	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet.minecraft.client.MinecraftClient;getLastFrameDuration()F"), cancellable = true)
	private void render(float tickDelta, long startTime, boolean tick, CallbackInfo info) {
		PlayerEntity player = MinecraftClient.getInstance().player;
		if(player.getPersistentData().getInt("freezeTime") > 0 && !player.hasEffect(EffectRegistry.CONTAMINATED_EFFECT.get())) {
			//RenderSystem.setShaderColor(1f, 1f, 1f, (float)(player.getPersistentData().getInt("freezeTime")) / 1200f);
			renderOverlay(new Identifier("luckytntmod:textures/powder_snow_outline.png"), (float)(player.getPersistentData().getInt("freezeTime")) / 1200f);
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
	}

}

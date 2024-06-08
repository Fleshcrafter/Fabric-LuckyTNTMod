package luckytnt.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import luckytnt.config.LuckyTNTConfigValues;
import luckytnt.registry.EffectRegistry;
import luckytntlib.util.LuckyTNTEntityExtension;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
	
	private static float contaminatedAmount = 0;
	
	@Shadow
	protected abstract void renderOverlay(DrawContext context, Identifier texture, float opacity);
	
	@SuppressWarnings("resource")
	@Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet.minecraft.client.MinecraftClient;getLastFrameDuration:F"), cancellable = true)
	private void render(DrawContext context, float tickDelta, CallbackInfo info) {
		PlayerEntity player = MinecraftClient.getInstance().player;
		if(player instanceof LuckyTNTEntityExtension lplayer) {
			if(lplayer.getAdditionalPersistentData().getInt("freezeTime") > 0 && !player.hasStatusEffect(EffectRegistry.CONTAMINATED_EFFECT.get())) {
				renderOverlay(context, new Identifier("luckytntmod:textures/powder_snow_outline.png"), (float)(lplayer.getAdditionalPersistentData().getInt("freezeTime")) / 1200f);
			} else if(player.hasStatusEffect(EffectRegistry.CONTAMINATED_EFFECT.get()) && LuckyTNTConfigValues.RENDER_CONTAMINATED_OVERLAY.get()) {
				renderOverlay(context, new Identifier("luckytntmod:textures/contaminated_outline.png"), contaminatedAmount);
				contaminatedAmount = MathHelper.clamp(contaminatedAmount + 0.025f, 0f, 1f);
			} else if(contaminatedAmount > 0){
				renderOverlay(context, new Identifier("luckytntmod:textures/contaminated_outline.png"), contaminatedAmount);
				contaminatedAmount = MathHelper.clamp(contaminatedAmount - 0.025f, 0f, 1f);
			}
		}
	}

}

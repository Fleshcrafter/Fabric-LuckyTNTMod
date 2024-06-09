package luckytnt.mixin;

import java.lang.reflect.Field;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import luckytntlib.util.LuckyTNTEntityExtension;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
	
	@Shadow
	@Final
	private Camera camera;

	@Inject(method = "renderWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;loadProjectionMatrix(Lorg/joml/Matrix4f;)V", shift = At.Shift.AFTER), cancellable = true)
	private void renderWorldInject(float tickDelta, long limitTime, MatrixStack matrices, CallbackInfo info) {
		MinecraftClient minecraft = MinecraftClient.getInstance();
		ClientPlayerEntity player = minecraft.player;
		
		float yaw = camera.getYaw();
		float pitch = camera.getPitch();
		float roll = 0f;
		
		if(player != null && player instanceof LuckyTNTEntityExtension lplayer && lplayer.getAdditionalPersistentData().getInt("shakeTime") >= 1) {
			float shakeAmount = 4f;
			yaw += (float)shakeAmount * (float)Math.cos((Math.random() * 5f + 1f) * 3d * ((float)lplayer.getAdditionalPersistentData().getInt("shakeTime")) / 20f);
			pitch += (float)shakeAmount * (float)Math.cos((Math.random() * 3f + 1f) * 3d * ((float)lplayer.getAdditionalPersistentData().getInt("shakeTime")) / 20f);
			roll += (float)shakeAmount * (float)Math.cos((Math.random() * 4f + 1f) * 3d * ((float)lplayer.getAdditionalPersistentData().getInt("shakeTime")) / 20f);
			
			try {
				Field yawField = Camera.class.getDeclaredField("yaw");
				Field pitchField = Camera.class.getDeclaredField("pitch");
				yawField.setAccessible(true);
				pitchField.setAccessible(true);
				yawField.setFloat(camera, yaw);
				pitchField.setFloat(camera, pitch);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(roll));
		}
	}
}

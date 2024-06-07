package luckytnt.effects;

import java.lang.reflect.Field;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ContaminatedEffect extends StatusEffect {

	private int duration;
	
	public ContaminatedEffect(StatusEffectCategory category, int id) {
		super(category, id);
	}

	@Override
	public Text getName() {
		return Text.translatable("effect.contaminated_effect");
	}
	
	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		this.duration = duration;
		return true;
	}

	@Override
	public void onApplied(LivingEntity entity, int amplifier) {
		DamageSources sources = entity.getWorld().getDamageSources();
		
		if(entity instanceof PlayerEntity player) {
			try {
                Field field = HungerManager.class.getDeclaredField("foodTickTimer");
                field.setAccessible(true);
                field.setInt(player.getHungerManager(), 0);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
		}
		int i = 40 >> duration;
		if (i > 0) {
			if(amplifier % i == 0) {
				if (entity.getHealth() > 4.0F) {
					entity.damage(sources.magic(), 1.0F);
				}
			}
		}
	}
}

package logan.pixl.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties FLUORITE_BOWL = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();

    public static final Consumable FLUORITE_BOWL_CONSUMEABLE = Consumables.defaultFood()
            .consumeSeconds(1f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 200, 3), 1f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 3), 1f)).build();
}

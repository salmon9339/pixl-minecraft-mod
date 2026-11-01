package logan.pixl.item;

import logan.pixl.PixlMinecraftMod;
import logan.pixl.food.ModFoods;
import logan.pixl.item.custom.ChiselItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {

    public static final Item FLUORITE = registerItem("fluorite", Item::new);
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", Item::new);
    public static final Item STONE_POLE = registerItem("stone_pole", Item::new);


    public static final Item CHISEL = registerItem("chisel", properties -> new ChiselItem(properties.durability(32)));
    public static final Item FLUORITE_BOWL = registerItem("fluorite_bowl", properties -> new Item(properties
            .food(ModFoods.FLUORITE_BOWL, ModFoods.FLUORITE_BOWL_CONSUMEABLE)) {
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.pixl-minecraft-mod.fluorite-food"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });


    public static final Item COMBUSTIBLE_FLUORITE = registerItem("fluorite_fuel", properties -> new Item(properties.stacksTo(16)
            .cookingFuel(ContextIntProviders.COOKING_TIME_BLAZE_ROD)));



    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PixlMinecraftMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PixlMinecraftMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        PixlMinecraftMod.LOGGER.info("Registering Mod Items for" + PixlMinecraftMod.MOD_ID);
    }

}

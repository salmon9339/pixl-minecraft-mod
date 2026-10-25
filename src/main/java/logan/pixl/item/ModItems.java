package logan.pixl.item;

import logan.pixl.PixlMinecraftMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.awt.image.PixelInterleavedSampleModel;
import java.util.function.Function;

public class ModItems {


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PixlMinecraftMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PixlMinecraftMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        PixlMinecraftMod.LOGGER.info("Registering Mod Items for" + PixlMinecraftMod.MOD_ID);

    }

}

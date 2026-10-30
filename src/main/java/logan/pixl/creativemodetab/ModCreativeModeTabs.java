package logan.pixl.creativemodetab;

import logan.pixl.PixlMinecraftMod;
import logan.pixl.block.ModBlocks;
import logan.pixl.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final CreativeModeTab FLUORITE_ITEM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(PixlMinecraftMod.MOD_ID, "fluorite_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FLUORITE))
                    .title(Component.translatable("creativemodetab.pixl-minecraft-mod.fluorite_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.FLUORITE);
                        output.accept(ModItems.RAW_FLUORITE);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.STONE_POLE);
                    }).build());

    public static final CreativeModeTab FLUORITE_BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(PixlMinecraftMod.MOD_ID, "fluorite_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FLUORITE_BLOCK))
                    .title(Component.translatable("creativemodetab.pixl-minecraft-mod.fluorite_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.FLUORITE_BLOCK);
                        output.accept(ModBlocks.FLUORITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_FLUORITE_ORE);
                        output.accept(ModBlocks.RAW_FLUORITE_BlOCK);
                    }).build());



    public static void registerModCreativeModeTabs() {
        PixlMinecraftMod.LOGGER.info("Registering Creative Mode Tabs for" + PixlMinecraftMod.MOD_ID);
    }
}

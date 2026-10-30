package logan.pixl.datagen;

import logan.pixl.block.ModBlocks;
import logan.pixl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.FLUORITE_BLOCK);
        dropSelf(ModBlocks.RAW_FLUORITE_BlOCK);

        add(ModBlocks.FLUORITE_ORE, createOreDrop(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE));
        add(ModBlocks.DEEPSLATE_FLUORITE_ORE, createMultipleOreDrops(ModBlocks.DEEPSLATE_FLUORITE_ORE, ModItems.RAW_FLUORITE, 3, 5));
    }

    public LootTable.Builder createMultipleOreDrops(Block block, Item item, int min_drops, int max_drops) {
            return this.createSilkTouchDispatchTable(block,
                    (LootPoolEntryContainer.Builder)this.applyExplosionDecay(block,
                            (FunctionUserBuilder)((UniformContainerBase.Builder) LootItem.lootTableItem(item)
                                    .apply(SetItemCountFunction.setCount(ContextIntProviders.between(min_drops, max_drops))))
                                    .apply(ApplyBonusCount.addOreBonusCount(this.enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

}

package logan.pixl.datagen;

import logan.pixl.block.ModBlocks;
import logan.pixl.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

@Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                List<ItemLike> FLUORITE_SMELTABLES = List.of(ModItems.RAW_FLUORITE, ModBlocks.FLUORITE_ORE, ModBlocks.DEEPSLATE_FLUORITE_ORE);

                this.oreSmelting(FLUORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FLUORITE, 0.25f, 200, "fluorite");
                this.oreBlasting(FLUORITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.FLUORITE, 0.25f, 100, "fluorite");

                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.FLUORITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_FLUORITE_BlOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_FLUORITE)
                        .unlockedBy(getHasName(ModItems.RAW_FLUORITE), has(ModItems.RAW_FLUORITE))
                        .group("fluorite_raw_block")
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_FLUORITE, 9)
                        .requires(ModBlocks.RAW_FLUORITE_BlOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_FLUORITE_BlOCK), has(ModBlocks.RAW_FLUORITE_BlOCK))
                        .group("fluorite_raw")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.STONE_POLE)
                        .pattern("S")
                        .pattern("S")
                        .define('S', Items.STONE)
                        .unlockedBy(getHasName(Items.STONE), has(Items.STONE))
                        .group("stone_pole")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.CHISEL)
                        .pattern("  F")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('S', ModItems.STONE_POLE)
                        .define('F', ModItems.FLUORITE)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(ModItems.STONE_POLE), has(ModItems.STONE_POLE))
                        .group("fluorite_chisel")
                        .save(output);

                shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                        .pattern("FFF")
                        .pattern("FRF")
                        .pattern("DND")
                        .define('F', ModBlocks.FLUORITE_BLOCK)
                        .define('R', Items.REDSTONE_BLOCK)
                        .define('D', Items.DIAMOND_BLOCK)
                        .define('N', Items.NETHERITE_BLOCK)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.REDSTONE_BLOCK), has(Items.REDSTONE_BLOCK))
                        .unlockedBy(getHasName(Items.DIAMOND_BLOCK), has(Items.DIAMOND_BLOCK))
                        .unlockedBy(getHasName(Items.NETHERITE_BLOCK), has(Items.NETHERITE_BLOCK))
                        .group("magic_block")
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.FLUORITE_BOWL)
                        .pattern("FFF")
                        .pattern(" B ")
                        .define('F', ModItems.FLUORITE)
                        .define('B', Items.BOWL)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.BOWL), has(Items.BOWL))
                        .group("fluorite_bowl")
                        .save(output);
                shaped(RecipeCategory.MISC, ModItems.COMBUSTIBLE_FLUORITE)
                        .pattern(" F ")
                        .pattern("FCF")
                        .pattern(" F ")
                        .define('C', Items.COAL)
                        .define('F', ModItems.FLUORITE)
                        .unlockedBy(getHasName(ModItems.FLUORITE), has(ModItems.FLUORITE))
                        .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                        .group("fluorite_fuel")
                        .save(output);


            }
        };
    }

    @Override
    public String getName() {
        return "PixlMinecraftMod Recipes";
    }
}

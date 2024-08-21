package com.rebuildableworldmod.datagen;

// import java.util.function.Consumer;
import java.util.List;

import com.rebuildableworldmod.block.ModBlocks;
import com.rebuildableworldmod.item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
// import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
// import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider{

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerBlasting(exporter, List.of(ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST), RecipeCategory.MISC, Items.NETHERITE_BLOCK, 1.0f, 200, "netherite_block");
    
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TRANSPORTINGCLOCK, 1)
            .pattern("GCG")
            .pattern("PAP")
            .pattern("GCG")
            .input('G', Items.GOLD_NUGGET)
            .input('A', Items.ANCIENT_DEBRIS)
            .input('C', Items.CRYING_OBSIDIAN)
            .input('P', Items.ENDER_PEARL)
            .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
            .criterion(hasItem(Items.ANCIENT_DEBRIS), conditionsFromItem(Items.ANCIENT_DEBRIS))
            .criterion(hasItem(Items.CRYING_OBSIDIAN), conditionsFromItem(Items.CRYING_OBSIDIAN))
            .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
            .offerTo(exporter, new Identifier(getRecipeName(ModItems.TRANSPORTINGCLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST, 1)
            .pattern("GAG")
            .pattern("AGA")
            .pattern("GAG")
            .input('G', Items.GOLD_NUGGET)
            .input('A', Items.ANCIENT_DEBRIS)
            .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
            .criterion(hasItem(Items.ANCIENT_DEBRIS), conditionsFromItem(Items.ANCIENT_DEBRIS))
            .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST)));

        offerShapelessRecipe(exporter, Items.GOLD_NUGGET, ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST, "gold_nuggets_from_pbtabdt", 8);
    }
    
}

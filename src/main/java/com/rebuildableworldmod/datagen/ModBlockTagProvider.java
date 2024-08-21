package com.rebuildableworldmod.datagen;

import java.util.concurrent.CompletableFuture;

import com.rebuildableworldmod.block.ModBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST)
            .add(ModBlocks.USELESS_BLOCK)
            .add(ModBlocks.USELESS_DEEPSLATE_ORE)
            .add(ModBlocks.USELESS_END_ORE)
            .add(ModBlocks.USELESS_NETHER_ORE);

            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.USELESS_BLOCK);

            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.USELESS_NETHER_ORE);

            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.USELESS_DEEPSLATE_ORE)
                .add(ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST);

            getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.USELESS_END_ORE);

    }
}

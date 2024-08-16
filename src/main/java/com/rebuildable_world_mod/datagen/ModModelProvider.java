package com.rebuildable_world_mod.datagen;

import com.rebuildable_world_mod.block.ModBlocks;
import com.rebuildable_world_mod.item.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.USELESS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.USELESS_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.USELESS_END_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.USELESS_NETHER_ORE);

        blockStateModelGenerator.registerSimpleState(ModBlocks.CLOCK_CHARGE_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RECREATIONCLOCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRANSPORTINGCLOCK, Models.GENERATED);
    }
    
}

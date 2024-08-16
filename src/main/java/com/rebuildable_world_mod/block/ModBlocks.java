package com.rebuildable_world_mod.block;

import com.rebuildable_world_mod.RebuildableWorld;
import com.rebuildable_world_mod.block.custom.ClockChargeStationBlock;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // ниже устаревшая версия функции FabricBlockSettings

    public static final Block PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST = registerBlock("portal_block_to_ab_dimensions_test", 
        new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block USELESS_BLOCK = registerBlock("useless_ore",
        new ExperienceDroppingBlock(AbstractBlock.Settings.copy(Blocks.LAPIS_ORE).strength(2f).sounds(BlockSoundGroup.GRASS), UniformIntProvider.create(1, 3)));
    
    public static final Block USELESS_DEEPSLATE_ORE = registerBlock("useless_deepslate_ore",
        new ExperienceDroppingBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_LAPIS_ORE).strength(4f).sounds(BlockSoundGroup.SLIME), UniformIntProvider.create(2, 6)));
    
    public static final Block USELESS_NETHER_ORE = registerBlock("useless_nether_ore",
        new ExperienceDroppingBlock(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE).strength(1.5f).sounds(BlockSoundGroup.NETHER_BRICKS), UniformIntProvider.create(1, 4)));
    
    public static final Block USELESS_END_ORE = registerBlock("useless_end_ore",
        new ExperienceDroppingBlock(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS).strength(2.5f), UniformIntProvider.create(4, 8)));

    public static final Block CLOCK_CHARGE_STATION = registerBlock("clock_charge_station", 
        new ClockChargeStationBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RebuildableWorld.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(RebuildableWorld.MOD_ID, name), 
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        RebuildableWorld.LOGGER.info("Registering ModBlocks for " + RebuildableWorld.MOD_ID);
    }
}

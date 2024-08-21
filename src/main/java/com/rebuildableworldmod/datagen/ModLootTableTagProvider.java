package com.rebuildableworldmod.datagen;

import com.rebuildableworldmod.block.ModBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableTagProvider extends FabricBlockLootTableProvider {

    public ModLootTableTagProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop((Block) ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST);

        addDrop(ModBlocks.USELESS_BLOCK, modOreDrop(ModBlocks.USELESS_BLOCK, Items.STICK));
        addDrop(ModBlocks.USELESS_DEEPSLATE_ORE, modOreDrop(ModBlocks.USELESS_DEEPSLATE_ORE, Items.AMETHYST_SHARD));
        addDrop(ModBlocks.USELESS_NETHER_ORE, modOreDrop(ModBlocks.USELESS_NETHER_ORE, Items.BLAZE_ROD));
        addDrop(ModBlocks.USELESS_END_ORE, oreDrops(ModBlocks.USELESS_END_ORE, Items.END_ROD));
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public LootTable.Builder modOreDrop(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                    ItemEntry.builder(item)
                        .apply(SetCountLootFunction
                            .builder(UniformLootNumberProvider
                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}

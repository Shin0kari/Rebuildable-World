package com.rebuildableworldmod.item;

import com.rebuildableworldmod.RebuildableWorld;
import com.rebuildableworldmod.block.ModBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup REBUILDABLEWORLD_GROUP = Registry.register(Registries.ITEM_GROUP, 
        new Identifier(RebuildableWorld.MOD_ID, "rebuildableworldmod"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rebuildableworldmod"))
            .icon(() -> new ItemStack(ModItems.RECREATIONCLOCK)).entries((displayContext, entries) -> {
                entries.add(ModItems.RECREATIONCLOCK);
                entries.add(ModItems.TRANSPORTINGCLOCK);

                entries.add(ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST);
                entries.add(ModBlocks.USELESS_BLOCK);
                entries.add(ModBlocks.USELESS_DEEPSLATE_ORE);
                entries.add(ModBlocks.USELESS_NETHER_ORE);
                entries.add(ModBlocks.USELESS_END_ORE);
                entries.add(ModBlocks.CLOCK_CHARGE_STATION);
                // test add vanilla item
                entries.add(Items.CLOCK);
            }).build());

    public static void registerItemGroups() {
        RebuildableWorld.LOGGER.info("Registering Item Groups for " + RebuildableWorld.MOD_ID);
    }
}

package com.rebuildable_world_mod.item;

import com.rebuildable_world_mod.RebuildableWorld;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RECREATIONCLOCK = registerItem("recreationclock", new Item(new FabricItemSettings()));
    
    private static void addItemToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(RECREATIONCLOCK);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RebuildableWorld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RebuildableWorld.LOGGER.info("Registering Mod Items for " + RebuildableWorld.MOD_ID);
    
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemToToolsItemGroup);
    }
}

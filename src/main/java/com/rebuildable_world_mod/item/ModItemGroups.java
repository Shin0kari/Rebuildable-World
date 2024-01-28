package com.rebuildable_world_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import com.rebuildable_world_mod.RebuildableWorld;
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

                // test add vanilla item
                entries.add(Items.CLOCK);
            }).build());

    public static void registerItemGroups() {
        RebuildableWorld.LOGGER.info("Registering Item Groups for " + RebuildableWorld.MOD_ID);
    }
}

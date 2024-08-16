package com.rebuildable_world_mod.block.entity;

import com.rebuildable_world_mod.RebuildableWorld;
import com.rebuildable_world_mod.block.ModBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ClockChargeStationBlockEntity> CLOCK_CHARGE_STATION_BLOCK_ENTITY = 
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(
            RebuildableWorld.MOD_ID, "clock_charge_be"), FabricBlockEntityTypeBuilder.create(
                ClockChargeStationBlockEntity::new, ModBlocks.CLOCK_CHARGE_STATION).build());
        
    public static void registerModBlockEntities() {
        RebuildableWorld.LOGGER.info("Registering Block Entities for " + RebuildableWorld.MOD_ID);
    }
}

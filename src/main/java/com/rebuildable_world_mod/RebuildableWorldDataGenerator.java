package com.rebuildable_world_mod;

import com.rebuildable_world_mod.block.datagen.ModBlockTagProvider;
import com.rebuildable_world_mod.block.datagen.ModItemTagProvider;
import com.rebuildable_world_mod.block.datagen.ModLootTableTagProvider;
import com.rebuildable_world_mod.block.datagen.ModModelProvider;
import com.rebuildable_world_mod.block.datagen.ModRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RebuildableWorldDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}

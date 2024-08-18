package com.rebuildable_world_mod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rebuildable_world_mod.block.ModBlocks;
import com.rebuildable_world_mod.block.entity.ModBlockEntities;
import com.rebuildable_world_mod.item.ModItemGroups;
import com.rebuildable_world_mod.item.ModItems;
import com.rebuildable_world_mod.recipe.ModRecipes;
import com.rebuildable_world_mod.screen.ModScreenHandlers;
import com.rebuildable_world_mod.sound.ModSounds;
import com.rebuildable_world_mod.world.gen.ModWorldGeneration;

public class RebuildableWorld implements ModInitializer {
	public static final String MOD_ID = "rebuildableworldmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ModBlockEntities.registerModBlockEntities();

		ModWorldGeneration.generateModWorldGen();
	
		ModScreenHandlers.registerScreenHandlers();

		ModRecipes.registerRecipes();
	}
}
package com.rebuildableworldmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rebuildableworldmod.block.ModBlocks;
import com.rebuildableworldmod.block.entity.ModBlockEntities;
import com.rebuildableworldmod.item.ModItemGroups;
import com.rebuildableworldmod.item.ModItems;
import com.rebuildableworldmod.recipe.ModRecipes;
import com.rebuildableworldmod.screen.ModScreenHandlers;
import com.rebuildableworldmod.sound.ModSounds;
import com.rebuildableworldmod.world.gen.ModWorldGeneration;

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
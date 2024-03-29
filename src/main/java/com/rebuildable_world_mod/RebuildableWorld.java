package com.rebuildable_world_mod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rebuildable_world_mod.block.ModBlocks;
import com.rebuildable_world_mod.item.ModItemGroups;
import com.rebuildable_world_mod.item.ModItems;

public class RebuildableWorld implements ModInitializer {
	public static final String MOD_ID = "rebuildableworldmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
package com.rebuildable_world_mod.world.gen;

import com.rebuildable_world_mod.world.ModPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.USELESS_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.USELESS_NETHER_ORE_PLACED_KEY);
            
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.USELESS_END_ORE_PLACED_KEY);
    }
}

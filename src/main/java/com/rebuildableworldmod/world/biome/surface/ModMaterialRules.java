package com.rebuildableworldmod.world.biome.surface;

import com.rebuildableworldmod.block.ModBlocks;
import com.rebuildableworldmod.world.biome.ModBiomes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule ANCIENT_DEBRIS = makeStateRule(Blocks.ANCIENT_DEBRIS);
    private static final MaterialRules.MaterialRule TERRACOTA = makeStateRule(Blocks.TERRACOTTA);
    private static final MaterialRules.MaterialRule PORTAL_BLOCK = makeStateRule(ModBlocks.PORTAL_BLOCK_TO_AB_DIMENSIONS_TEST);
    private static final MaterialRules.MaterialRule USELESS_NETHER_ORE = makeStateRule(ModBlocks.USELESS_NETHER_ORE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, TERRACOTA), ANCIENT_DEBRIS);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.FIREPROOF_BIOME),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, USELESS_NETHER_ORE)),
                    MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, PORTAL_BLOCK)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}

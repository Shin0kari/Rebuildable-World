package com.rebuildableworldmod.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;


import java.util.List;

import com.rebuildableworldmod.RebuildableWorld;
import com.rebuildableworldmod.block.ModBlocks;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> USELESS_ORE_KEY = registerKey("useless_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> USELESS_NETHER_ORE_KEY = registerKey("useless_nether_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> USELESS_END_ORE_KEY = registerKey("useless_end_ore");


    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacable = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endstoneReplacable = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldUselessOres = 
                List.of(OreFeatureConfig.createTarget(stoneReplacable, ModBlocks.USELESS_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacable, ModBlocks.USELESS_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherUselessOres = 
                List.of(OreFeatureConfig.createTarget(netherrackReplacable, ModBlocks.USELESS_NETHER_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endUselessOres = 
                List.of(OreFeatureConfig.createTarget(endstoneReplacable, ModBlocks.USELESS_END_ORE.getDefaultState()));

        // size = 12 это размер жилы
        register(context, USELESS_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldUselessOres, 12));
        register(context, USELESS_NETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherUselessOres, 12));
        register(context, USELESS_END_ORE_KEY, Feature.ORE, new OreFeatureConfig(endUselessOres, 12));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(RebuildableWorld.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, 
                                                                                RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

package com.rebuildable_world_mod.world;

import com.rebuildable_world_mod.RebuildableWorld;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> USELESS_ORE_PLACED_KEY = registerKey("useless_ore_placed");
    public static final RegistryKey<PlacedFeature> USELESS_NETHER_ORE_PLACED_KEY = registerKey("useless_nether_ore_placed");
    public static final RegistryKey<PlacedFeature> USELESS_END_ORE_PLACED_KEY = registerKey("useless_end_ore_placed");


    public static void boostrap(Registerable<PlacedFeature> context) {
        // поиск записей в реестре сконфигурированных функций
        // нужен для получения настроенных функций
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // uniform указывает что во 2 точке будет наибольшее количество руды
        // если бы вместо uniform была бы trapezoid то больше было бы в середине
        register(context, USELESS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.USELESS_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12, // количество в жиле кусков
                                                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
                                                    
        register(context, USELESS_NETHER_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.USELESS_NETHER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12, // количество в жиле кусков
                                                    HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(180))));
                                                    
        register(context, USELESS_END_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.USELESS_END_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12, // количество в жиле кусков
                                                    HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(180))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(RebuildableWorld.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, 
                                RegistryEntry<ConfiguredFeature<?, ?>> configuration, 
                                List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

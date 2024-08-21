// // Source code is decompiled from a .class file using FernFlower decompiler.
// package com.rebuildableworldmod.world.biome;

// import com.google.common.collect.ImmutableList;
// import com.google.common.collect.Lists;
// import com.google.common.collect.Maps;
// import com.mojang.datafixers.util.Pair;
// import java.util.List;
// import java.util.Map;
// import java.util.function.Consumer;
// import net.minecraft.registry.RegistryKey;
// import net.minecraft.world.biome.Biome;
// import net.minecraft.world.biome.source.util.MultiNoiseUtil;
// import net.minecraft.world.biome.source.util.VanillaBiomeParameters;

// public class ModifiedNetherBuilder {
//    private Map<RegistryKey<Biome>, RegistryKey<Biome>> originalBiomeMappings = Maps.newHashMap();
//    private Map<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>> parameterBiomeMappings = Maps.newHashMap();
//    private Map<MultiNoiseUtil.NoiseHypercube, MultiNoiseUtil.NoiseHypercube> parameterMappings = Maps.newHashMap();
//    private List<MultiNoiseUtil.NoiseHypercube> parametersToRemove = Lists.newArrayList();
//    private final VanillaBiomeParameters biomeBuilder = new VanillaBiomeParameters();

//    public ModifiedNetherBuilder() {
//    }

//    public void replaceBiome(RegistryKey<Biome> original, RegistryKey<Biome> replacement) {
//       this.originalBiomeMappings.put(original, replacement);
//    }

//    public void replaceBiome(MultiNoiseUtil.NoiseHypercube point, RegistryKey<Biome> biome) {
//       this.parameterBiomeMappings.put(point, biome);
//    }

//    public void replaceParameter(MultiNoiseUtil.NoiseHypercube original, MultiNoiseUtil.NoiseHypercube replacement) {
//       this.parameterMappings.put(original, replacement);
//    }

//    public void removeParameter(MultiNoiseUtil.NoiseHypercube parameter) {
//       this.parametersToRemove.add(parameter);
//    }

//    public List<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> build() {
//       ImmutableList.Builder<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> builder = new ImmutableList.Builder();
//       Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper = (pair) -> {
//          MultiNoiseUtil.NoiseHypercube parameters = (MultiNoiseUtil.NoiseHypercube)pair.getFirst();
//          RegistryKey<Biome> biome = (RegistryKey)pair.getSecond();
//          if (!this.parametersToRemove.contains(parameters)) {
//             if (this.originalBiomeMappings.containsKey(biome)) {
//                biome = (RegistryKey)this.originalBiomeMappings.get(biome);
//             } else if (this.parameterBiomeMappings.containsKey(parameters)) {
//                biome = (RegistryKey)this.parameterBiomeMappings.get(parameters);
//             }

//             if (this.parameterMappings.containsKey(parameters)) {
//                parameters = (MultiNoiseUtil.NoiseHypercube)this.parameterMappings.get(parameters);
//             }

//             builder.add(Pair.of(parameters, biome));
//          }

//       };
//       this.biomeBuilder.writeOverworldBiomeParameters(mapper);
//       return builder.build();
//    }
// }

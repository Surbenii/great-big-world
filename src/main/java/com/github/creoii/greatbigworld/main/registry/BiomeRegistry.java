package com.github.creoii.greatbigworld.main.registry;

import com.github.creoii.greatbigworld.main.GreatBigWorld;
import com.github.creoii.greatbigworld.main.util.Register;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class BiomeRegistry implements Register {
    public static RegistryKey<Biome> ASPEN_FOREST;
    public static RegistryKey<Biome> SNOWY_ASPEN_FOREST;
    public static RegistryKey<Biome> ISLAND_JUNGLE;
    public static RegistryKey<Biome> ISLAND_SPARSE_JUNGLE;
    public static RegistryKey<Biome> ISLAND_BEACH;

    @Override
    public void register() {
        ASPEN_FOREST = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "aspen_forest"));
        SNOWY_ASPEN_FOREST = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "snowy_aspen_forest"));
        ISLAND_JUNGLE = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "island_jungle"));
        ISLAND_SPARSE_JUNGLE = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "island_sparse_jungle"));
        ISLAND_BEACH = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "island_beach"));
    }
}

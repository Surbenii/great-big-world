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
    public static RegistryKey<Biome> HOT_SPRINGS;

    @Override
    public void register() {
        ASPEN_FOREST = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "aspen_forest"));
        SNOWY_ASPEN_FOREST = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "snowy_aspen_forest"));
        HOT_SPRINGS = RegistryKey.of(RegistryKeys.BIOME, new Identifier(GreatBigWorld.NAMESPACE, "hot_springs"));
    }
}

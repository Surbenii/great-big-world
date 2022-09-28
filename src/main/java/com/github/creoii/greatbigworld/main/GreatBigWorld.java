package com.github.creoii.greatbigworld.main;

import com.github.creoii.greatbigworld.main.registry.*;
import com.github.creoii.greatbigworld.main.util.Register;
import net.fabricmc.api.ModInitializer;

public class GreatBigWorld implements ModInitializer {
    public static final String NAMESPACE = "great_big_world";
    public static final Register[] REGISTERS = new Register[]{new BlockRegistry(), new ItemRegistry(), new PlacerRegistry(), new ConfiguredFeatureRegistry(), new PlacedFeatureRegistry()};

    @Override
    public void onInitialize() {
        for (Register register : REGISTERS) {
            register.register();
        }
    }
}

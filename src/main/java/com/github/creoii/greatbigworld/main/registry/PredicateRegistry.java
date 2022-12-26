package com.github.creoii.greatbigworld.main.registry;

import com.github.creoii.greatbigworld.main.GreatBigWorld;
import com.github.creoii.greatbigworld.main.util.Register;
import com.github.creoii.greatbigworld.world.predicate.SkyVisiblePredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicateType;

public class PredicateRegistry implements Register {
    public static final BlockPredicateType<SkyVisiblePredicate> SKY_VISIBLE = () -> SkyVisiblePredicate.CODEC;

    @Override
    public void register() {
        Registry.register(Registries.BLOCK_PREDICATE_TYPE, new Identifier(GreatBigWorld.NAMESPACE, "sky_visible"), SKY_VISIBLE);
    }
}

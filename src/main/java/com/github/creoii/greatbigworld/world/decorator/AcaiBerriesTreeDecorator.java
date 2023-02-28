package com.github.creoii.greatbigworld.world.decorator;

import com.github.creoii.greatbigworld.block.AcaiBerryClumpBlock;
import com.github.creoii.greatbigworld.main.registry.BlockRegistry;
import com.github.creoii.greatbigworld.main.registry.DecoratorRegistry;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Optional;

public class AcaiBerriesTreeDecorator extends TreeDecorator {
    private static final AcaiBerriesTreeDecorator INSTANCE = new AcaiBerriesTreeDecorator();
    public static final Codec<AcaiBerriesTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);
    private static final DataPool<BlockState> BERRY_STATES = DataPool.<BlockState>builder()
            .add(BlockRegistry.ACAI_BERRY_CLUMP.getDefaultState().with(AcaiBerryClumpBlock.BERRIES, 1), 5)
            .add(BlockRegistry.ACAI_BERRY_CLUMP.getDefaultState().with(AcaiBerryClumpBlock.BERRIES, 2), 4)
            .add(BlockRegistry.ACAI_BERRY_CLUMP.getDefaultState().with(AcaiBerryClumpBlock.BERRIES, 3), 3)
            .add(BlockRegistry.ACAI_BERRY_CLUMP.getDefaultState().with(AcaiBerryClumpBlock.BERRIES, 4), 2)
            .add(BlockRegistry.ACAI_BERRY_CLUMP.getDefaultState().with(AcaiBerryClumpBlock.BERRIES, 5), 1)
            .build();

    @Override
    protected TreeDecoratorType<?> getType() {
        return DecoratorRegistry.ACAI_BERRIES_DECORATOR;
    }

    @Override
    public void generate(Generator generator) {
        Random random = generator.getRandom();
        float places = 0;
        for (BlockPos pos : generator.getLogPositions()) {
            if (places < 2 && random.nextFloat() >= .9f) {
                ++places;
                Optional<BlockState> state = BERRY_STATES.getDataOrEmpty(random);
                if (state.isPresent()) {
                    Direction direction = Direction.Type.HORIZONTAL.random(random);
                    BlockPos place = pos.offset(direction);
                    if (generator.isAir(place) && generator.isAir(place.down())) {
                        generator.replace(place, BlockRegistry.ACAI.log().getDefaultState().with(PillarBlock.AXIS, direction.getAxis()));
                        generator.replace(place.down(), state.get());
                    }
                }
            }
        }
    }
}
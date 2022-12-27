package com.github.creoii.greatbigworld.main.registry;

import com.github.creoii.greatbigworld.block.*;
import com.github.creoii.greatbigworld.main.util.DefaultBlockSets;
import com.github.creoii.greatbigworld.main.util.GBWSignTypes;
import com.github.creoii.greatbigworld.main.util.Register;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import static com.github.creoii.greatbigworld.main.GreatBigWorld.NAMESPACE;

public class BlockRegistry implements Register {
    private static final Map<Block, Block> STRIPPED_BLOCKS = new HashMap<>();
    private static final FireBlock FIRE = (FireBlock) Blocks.FIRE;

    //region Mahogany Wood
    public static DefaultBlockSets.WoodSet MAHOGANY = DefaultBlockSets.createWoodSet("mahogany", MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_ORANGE, true);
    public static final Block MAHOGANY_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
    public static final Block MAHOGANY_SAPLING = new GBWSaplingBlock(FabricBlockSettings.copy(Blocks.JUNGLE_SAPLING), ConfiguredFeatureRegistry.MAHOGANY);
    public static final Block POTTED_MAHOGANY_SAPLING = new FlowerPotBlock(MAHOGANY_SAPLING, FabricBlockSettings.copy(Blocks.FLOWER_POT));
    public static final Block MAHOGANY_SIGN = new SignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1f).sounds(BlockSoundGroup.WOOD), GBWSignTypes.MAHOGANY);
    public static final Block MAHOGANY_WALL_SIGN = new WallSignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1f).sounds(BlockSoundGroup.WOOD).dropsLike(MAHOGANY_SIGN), GBWSignTypes.MAHOGANY);
    //endregion
    //region Aspen Wood
    public static DefaultBlockSets.WoodSet ASPEN = DefaultBlockSets.createWoodSet("aspen", MapColor.TERRACOTTA_BROWN, MapColor.TERRACOTTA_ORANGE, true);
    public static final Block YELLOW_ASPEN_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
    public static final Block YELLOW_ASPEN_LEAF_PILE = new LeafPileBlock(FabricBlockSettings.copy(YELLOW_ASPEN_LEAVES));
    public static final Block GREEN_ASPEN_LEAVES = new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
    public static final Block GREEN_ASPEN_LEAF_PILE = new LeafPileBlock(FabricBlockSettings.copy(GREEN_ASPEN_LEAVES));
    public static final Block YELLOW_ASPEN_SAPLING = new GBWSaplingBlock(FabricBlockSettings.copy(Blocks.BIRCH_SAPLING), ConfiguredFeatureRegistry.YELLOW_ASPEN);
    public static final Block POTTED_YELLOW_ASPEN_SAPLING = new FlowerPotBlock(YELLOW_ASPEN_SAPLING, FabricBlockSettings.copy(Blocks.FLOWER_POT));
    public static final Block GREEN_ASPEN_SAPLING = new GBWSaplingBlock(FabricBlockSettings.copy(Blocks.BIRCH_SAPLING), ConfiguredFeatureRegistry.GREEN_ASPEN);
    public static final Block POTTED_GREEN_ASPEN_SAPLING = new FlowerPotBlock(GREEN_ASPEN_SAPLING, FabricBlockSettings.copy(Blocks.FLOWER_POT));
    public static final Block ASPEN_SIGN = new SignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1f).sounds(BlockSoundGroup.WOOD), GBWSignTypes.ASPEN);
    public static final Block ASPEN_WALL_SIGN = new WallSignBlock(AbstractBlock.Settings.of(Material.WOOD).noCollision().strength(1f).sounds(BlockSoundGroup.WOOD).dropsLike(ASPEN_SIGN), GBWSignTypes.ASPEN);
    //endregion
    //region Bamboo Torches
    public static final Block BAMBOO_TORCH = new BambooTorchBlock(ParticleTypes.FLAME);
    public static final Block BAMBOO_WALL_TORCH = new BambooWallTorchBlock(ParticleTypes.FLAME);
    public static final Block SOUL_BAMBOO_TORCH = new BambooTorchBlock(ParticleTypes.SOUL_FIRE_FLAME);
    public static final Block SOUL_BAMBOO_WALL_TORCH = new BambooWallTorchBlock(ParticleTypes.SOUL_FIRE_FLAME);
    public static final Block POTTED_BAMBOO_TORCH = new FlowerPotBlock(BAMBOO_TORCH, FabricBlockSettings.copy(Blocks.FLOWER_POT));
    public static final Block POTTED_SOUL_BAMBOO_TORCH = new FlowerPotBlock(SOUL_BAMBOO_TORCH, FabricBlockSettings.copy(Blocks.FLOWER_POT));
    //endregion
    //region Glimmering Mushrooms
    public static final Block DAYLIGHT_MUSHROOM = new GlimmeringMushroomBlock(ParticleRegistry.DAY_GLIMMER, new StatusEffectInstance(StatusEffects.GLOWING, 100), 4, 16765440);
    public static final Block MIDNIGHT_MUSHROOM = new GlimmeringMushroomBlock(ParticleRegistry.NIGHT_GLIMMER, new StatusEffectInstance(StatusEffects.BLINDNESS, 100), 8, 9558015);
    public static final Block DARKBLIGHT_MUSHROOM = new GlimmeringMushroomBlock(ParticleRegistry.DARK_GLIMMER, new StatusEffectInstance(StatusEffects.DARKNESS, 150), 12, 0);
    //endregion
    //region Miscellaneous
    public static final Block ANTLER = new AntlerBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK).nonOpaque().noCollision());
    //endregion

    public void register() {
        MAHOGANY.register();
        registerBlock(new Identifier(NAMESPACE, "mahogany_leaves"), MAHOGANY_LEAVES, new ExtendedBlockSettings(.3f, 30, 60, null));
        registerBlock(new Identifier(NAMESPACE, "mahogany_sapling"), MAHOGANY_SAPLING, new ExtendedBlockSettings(.3f, 0, 0, null), ItemGroups.NATURAL);
        registerBlock(new Identifier(NAMESPACE, "potted_mahogany_sapling"), POTTED_MAHOGANY_SAPLING, null);
        registerBlock(new Identifier(NAMESPACE, "mahogany_sign"), MAHOGANY_SIGN, null);
        registerBlock(new Identifier(NAMESPACE, "mahogany_wall_sign"), MAHOGANY_WALL_SIGN, null);

        ASPEN.register();
        registerBlock(new Identifier(NAMESPACE, "yellow_aspen_leaves"), YELLOW_ASPEN_LEAVES, new ExtendedBlockSettings(.3f, 30, 60, null), ItemGroups.NATURAL);
        registerBlock(new Identifier(NAMESPACE, "yellow_aspen_leaf_pile"), YELLOW_ASPEN_LEAF_PILE, new ExtendedBlockSettings(.1f, 30, 60, null), ItemGroups.NATURAL);
        registerBlock(new Identifier(NAMESPACE, "yellow_aspen_sapling"), YELLOW_ASPEN_SAPLING, new ExtendedBlockSettings(.3f, 0, 0, null), ItemGroups.NATURAL);
        registerBlock(new Identifier(NAMESPACE, "potted_yellow_aspen_sapling"), POTTED_YELLOW_ASPEN_SAPLING, null);
        registerBlock(new Identifier(NAMESPACE, "green_aspen_leaves"), GREEN_ASPEN_LEAVES, new ExtendedBlockSettings(.3f, 30, 60, null));
        registerBlock(new Identifier(NAMESPACE, "green_aspen_leaf_pile"), GREEN_ASPEN_LEAF_PILE, new ExtendedBlockSettings(.1f, 30, 60, null));
        registerBlock(new Identifier(NAMESPACE, "green_aspen_sapling"), GREEN_ASPEN_SAPLING, new ExtendedBlockSettings(.3f, 0, 0, null), ItemGroups.NATURAL);
        registerBlock(new Identifier(NAMESPACE, "potted_green_aspen_sapling"), POTTED_GREEN_ASPEN_SAPLING, null);
        registerBlock(new Identifier(NAMESPACE, "aspen_sign"), ASPEN_SIGN, null);
        registerBlock(new Identifier(NAMESPACE, "aspen_wall_sign"), ASPEN_WALL_SIGN, null);

        registerBlock(new Identifier(NAMESPACE, "bamboo_torch"), BAMBOO_TORCH, new ExtendedBlockSettings(0f, 0, 0, null));
        registerBlock(new Identifier(NAMESPACE, "bamboo_wall_torch"), BAMBOO_WALL_TORCH, new ExtendedBlockSettings(0f, 0, 0, null));
        registerBlock(new Identifier(NAMESPACE, "soul_bamboo_torch"), SOUL_BAMBOO_TORCH, new ExtendedBlockSettings(0f, 0, 0, null));
        registerBlock(new Identifier(NAMESPACE, "soul_bamboo_wall_torch"), SOUL_BAMBOO_WALL_TORCH, new ExtendedBlockSettings(0f, 0, 0, null));
        registerBlock(new Identifier(NAMESPACE, "potted_bamboo_torch"), POTTED_BAMBOO_TORCH, new ExtendedBlockSettings(0f, 0, 0, null));
        registerBlock(new Identifier(NAMESPACE, "potted_soul_bamboo_torch"), POTTED_SOUL_BAMBOO_TORCH, new ExtendedBlockSettings(0f, 0, 0, null));

        registerBlock(new Identifier(NAMESPACE, "daylight_mushroom"), DAYLIGHT_MUSHROOM, new ExtendedBlockSettings(.15f, 0, 0, null), ItemGroups.NATURAL, ItemGroups.INGREDIENTS);
        registerBlock(new Identifier(NAMESPACE, "midnight_mushroom"), MIDNIGHT_MUSHROOM, new ExtendedBlockSettings(.15f, 0, 0, null), ItemGroups.NATURAL, ItemGroups.INGREDIENTS);
        registerBlock(new Identifier(NAMESPACE, "darkblight_mushroom"), DARKBLIGHT_MUSHROOM, new ExtendedBlockSettings(.1f, 0, 0, null), ItemGroups.NATURAL, ItemGroups.INGREDIENTS);

        registerBlock(new Identifier(NAMESPACE, "antler"), ANTLER, new ExtendedBlockSettings(0f, 0, 0, null));

        AxeItem.STRIPPED_BLOCKS = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPPED_BLOCKS).putAll(STRIPPED_BLOCKS).build();
        BlockEntityType.SIGN.blocks = new ImmutableSet.Builder<Block>().addAll(BlockEntityType.SIGN.blocks).add(MAHOGANY_SIGN).add(MAHOGANY_WALL_SIGN).add(ASPEN_SIGN).add(ASPEN_WALL_SIGN).build();
    }

    @Override
    public void registerClient() {
        RenderLayers.BLOCKS.put(BlockRegistry.MAHOGANY.door(), RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.MAHOGANY.trapdoor(), RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.ASPEN.door(), RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.ASPEN.trapdoor(), RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.MAHOGANY_SAPLING, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.POTTED_MAHOGANY_SAPLING, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.MAHOGANY_LEAVES, RenderLayer.getCutoutMipped());
        RenderLayers.BLOCKS.put(BlockRegistry.YELLOW_ASPEN_SAPLING, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.POTTED_YELLOW_ASPEN_SAPLING, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.YELLOW_ASPEN_LEAVES, RenderLayer.getCutoutMipped());
        RenderLayers.BLOCKS.put(BlockRegistry.YELLOW_ASPEN_LEAF_PILE, RenderLayer.getCutoutMipped());
        RenderLayers.BLOCKS.put(BlockRegistry.GREEN_ASPEN_SAPLING, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.POTTED_GREEN_ASPEN_SAPLING, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.GREEN_ASPEN_LEAVES, RenderLayer.getCutoutMipped());
        RenderLayers.BLOCKS.put(BlockRegistry.GREEN_ASPEN_LEAF_PILE, RenderLayer.getCutoutMipped());
        RenderLayers.BLOCKS.put(BlockRegistry.BAMBOO_TORCH, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.BAMBOO_WALL_TORCH, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.SOUL_BAMBOO_TORCH, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.SOUL_BAMBOO_WALL_TORCH, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.POTTED_BAMBOO_TORCH, RenderLayer.getCutout());
        RenderLayers.BLOCKS.put(BlockRegistry.POTTED_SOUL_BAMBOO_TORCH, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefaultColor(), MAHOGANY_LEAVES, GREEN_ASPEN_LEAVES, GREEN_ASPEN_LEAF_PILE);
    }

    public static void registerBlock(Identifier id, Block block, @Nullable ExtendedBlockSettings extension) {
        Registry.register(Registries.BLOCK, id, block);
        if (extension != null) {
            if (extension.compostChance() > 0f)
                ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(block, extension.compostChance());
            if (extension.burnChance() > 0 && extension.spreadChance() > 0)
                FIRE.registerFlammableBlock(block, extension.burnChance(), extension.spreadChance());
            if (extension.strippedBlock() != null)
                BlockRegistry.STRIPPED_BLOCKS.put(block, extension.strippedBlock());
        }
    }

    public static void registerBlock(Identifier id, Block block, @Nullable ExtendedBlockSettings extension, ItemGroup... groups) {
        registerBlock(id, block, extension);
        if (groups != null) {
            ItemRegistry.registerItem(id, new BlockItem(block, new Item.Settings()), groups);
        }
    }

    public static record ExtendedBlockSettings(float compostChance, int burnChance, int spreadChance, @Nullable Block strippedBlock) { }
}

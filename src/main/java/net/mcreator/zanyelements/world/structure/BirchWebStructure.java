
package net.mcreator.zanyelements.world.structure;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.Random;

@ZanyelementsModElements.ModElement.Tag
public class BirchWebStructure extends ZanyelementsModElements.ModElement {
	public BirchWebStructure(ZanyelementsModElements instance) {
		super(instance, 108);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("birch_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("birch_forest_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("dark_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("tall_birch_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("tall_birch_hills").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("dark_forest_hills").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
			@Override
			public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
				int ci = (pos.getX() >> 4) << 4;
				int ck = (pos.getZ() >> 4) << 4;
				RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
				boolean dimensionCriteria = false;
				if (dimensionType == World.OVERWORLD)
					dimensionCriteria = true;
				if (!dimensionCriteria)
					return false;
				if ((random.nextInt(1000000) + 1) <= 1000) {
					int count = random.nextInt(1) + 1;
					for (int a = 0; a < count; a++) {
						int i = ci + random.nextInt(16);
						int k = ck + random.nextInt(16);
						int j = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);
						j -= 1;
						BlockState blockAt = world.getBlockState(new BlockPos(i, j, k));
						boolean blockCriteria = false;
						if (blockAt.getBlock() == Blocks.GRASS_BLOCK.getDefaultState().getBlock())
							blockCriteria = true;
						if (blockAt.getBlock() == Blocks.MYCELIUM.getDefaultState().getBlock())
							blockCriteria = true;
						if (blockAt.getBlock() == Blocks.DIRT.getDefaultState().getBlock())
							blockCriteria = true;
						if (blockAt.getBlock() == Blocks.COARSE_DIRT.getDefaultState().getBlock())
							blockCriteria = true;
						if (blockAt.getBlock() == Blocks.PODZOL.getDefaultState().getBlock())
							blockCriteria = true;
						if (!blockCriteria)
							continue;
						Rotation rotation = Rotation.values()[random.nextInt(3)];
						Mirror mirror = Mirror.values()[random.nextInt(2)];
						BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);
						int x = spawnTo.getX();
						int y = spawnTo.getY();
						int z = spawnTo.getZ();
						Template template = world.getWorld().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("zanyelements", "birch_web"));
						if (template == null)
							return false;
						template.func_237144_a_(world, spawnTo, new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
								.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false), random);
					}
				}
				return true;
			}
		};
		event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> feature
				.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
}

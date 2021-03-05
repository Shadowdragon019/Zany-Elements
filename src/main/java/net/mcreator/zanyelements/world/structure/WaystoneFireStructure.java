
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

import net.mcreator.zanyelements.procedures.WaystoneFireOnStructureInstanceGeneratedProcedure;
import net.mcreator.zanyelements.ZanyelementsModElements;

import java.util.Random;

import com.google.common.collect.ImmutableMap;

@ZanyelementsModElements.ModElement.Tag
public class WaystoneFireStructure extends ZanyelementsModElements.ModElement {
	public WaystoneFireStructure(ZanyelementsModElements instance) {
		super(instance, 112);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
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
						Rotation rotation = Rotation.NONE;
						Mirror mirror = Mirror.NONE;
						BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);
						int x = spawnTo.getX();
						int y = spawnTo.getY();
						int z = spawnTo.getZ();
						if (!WaystoneFireOnStructureInstanceGeneratedProcedure
								.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world)))
							continue;
						Template template = world.getWorld().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("zanyelements", "fire_waystone"));
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

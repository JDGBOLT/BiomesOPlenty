package biomesoplenty.common.biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;

public class BiomeGenPasture extends BOPBiome
{
	private static final Height biomeHeight = new Height(0.1F, 0.1F);

	public BiomeGenPasture(int id)
	{
		super(id);
		
        //TODO: setHeight()
        this.setHeight(biomeHeight);
        //TODO:	setColor()
        this.setColor(16176475);
        this.setTemperatureRainfall(0.8F, 0.4F);
		
		this.spawnableCreatureList.clear();
		
		this.theBiomeDecorator.treesPerChunk = 0;
		this.theBiomeDecorator.grassPerChunk = 999;
		this.theBiomeDecorator.flowersPerChunk = -999;
	}
	
	@Override
	//TODO:						getRandomWorldGenForTrees()
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return worldGeneratorBigTree;
	}
	
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
		return new WorldGenBOPTallGrass(BOPBlockHelper.get("plants"), 6);
	}

	@Override
	public void decorate(World world, Random random, int chunkX, int chunkZ)
	{
		super.decorate(world, random, chunkX, chunkZ);
		int var5 = 12 + random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(28) + 4;
			int z = chunkZ + random.nextInt(16);

			//TODO:				getBlock()
			Block block = world.getBlock(x, y, z);

			if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
			{
				//TODO:	setBlock()
				world.setBlock(x, y, z, BOPBlockHelper.get("gemOre"), 4, 2);
			}
		}
	}

	@Override
	//TODO:		getBiomeGrassColor()
	public int getBiomeGrassColor(int x, int y, int z)
	{
		return 13166666;
	}

	@Override
	//TODO:		getBiomeFoliageColor()
	public int getBiomeFoliageColor(int x, int y, int z)
	{
		return 13166666;
	}
}

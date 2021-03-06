package biomesoplenty.common.biomes.promisedland;

import java.awt.Color;
import java.util.Random;





//import worldcore.interfaces.IWCFog;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.biomes.BOPBiome;
import biomesoplenty.common.world.decoration.BOPBiomeDecorator;
import biomesoplenty.common.world.features.WorldGenWaterSpring;
import biomesoplenty.common.world.features.trees.WorldGenPromisedTree;
import biomesoplenty.common.world.features.trees.WorldGenPromisedTree2;
import biomesoplenty.common.world.features.trees.WorldGenRainforestTree1;
import biomesoplenty.common.configuration.BOPConfigurationMisc;

public class BiomeGenPromisedLandForest extends BOPBiome //implements IWCFog
{
	private WorldGenerator theWorldGenerator;
	private BOPBiomeDecorator customBiomeDecorator;

	public BiomeGenPromisedLandForest(int par1)
	{
		super(par1);
		theBiomeDecorator = new BOPBiomeDecorator();
		customBiomeDecorator = (BOPBiomeDecorator)theBiomeDecorator;
		topBlock = BOPBlockHelper.get("grass");
		fillerBlock = BOPBlockHelper.get("holyDirt");
		customBiomeDecorator.treesPerChunk = 10;
		customBiomeDecorator.grassPerChunk = 0;
		//this.bopWorldFeatures.holyTallGrassPerChunk = 100;
		//this.bopWorldFeatures.promisedWillowPerChunk = 40;
		//this.bopWorldFeatures.pinkFlowersPerChunk = 12;
		//this.bopWorldFeatures.rainbowflowersPerChunk = 10;
		this.bopWorldFeatures.blueMilksPerChunk = 5;
		customBiomeDecorator.generateLakes = false;
		this.bopWorldFeatures.waterPoolsPerChunk = 0;
		//this.bopWorldFeatures.hotSpringsPerChunk = 5;
		this.bopWorldFeatures.waterLakesPerChunk = 10;
		//this.bopWorldFeatures.crystalsPerChunk = 25;
		//this.bopWorldFeatures.crystals2PerChunk = 50;
		//this.bopWorldFeatures.cloudsPerChunk = 1;
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableCaveCreatureList.clear();
		this.bopWorldFeatures.generatePumpkins = false;
		//this.bopWorldFeatures.generateMossySkystone = true;
		//this.bopWorldFeatures.generateUndergroundLakes = false;
		theWorldGenerator = new WorldGenWaterSpring(Blocks.water, 8);
		/*this.spawnableMonsterList.add(new SpawnListEntry(EntityCow.class, 6, 1, 4));

		if (Loader.isModLoaded("TwilightForest"))
		{
			try {
				this.spawnableMonsterList.add(new SpawnListEntry(Class.forName("twilightforest.entity.passive.EntityTFBighorn"), 2, 1, 3));
				this.spawnableMonsterList.add(new SpawnListEntry(Class.forName("twilightforest.entity.passive.EntityTFDeer"), 4, 1, 3));
				this.spawnableMonsterList.add(new SpawnListEntry(Class.forName("twilightforest.entity.passive.EntityTFBird"), 2, 1, 3));
			} catch (ClassNotFoundException e) {
				System.out.println("[BiomesOPlenty] There was an error while integrating Twilight Forest with Biomes O' Plenty!");
				e.printStackTrace();
			}
		}*/
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
    //TODO:                     getRandomWorldGenForTrees()
    public WorldGenAbstractTree func_150567_a(Random random)
    {
		return random.nextInt(8) == 0 ? new WorldGenPromisedTree2(false) : new WorldGenPromisedTree(false);
    }
	
	@Override
	//TODO:		getBiomeGrassColor()
    public int getBiomeGrassColor(int x, int y, int z)
    {
		return 7925125;
	}

	/**
	 * Provides the basic foliage color based on the biome temperature and rainfall
	 */
	//@Override
	public int getBiomeFoliageColor()
	{
		return 7925125;
	}
	
	//@Override
	public int getFogColour()
	{
		return 16754234;
	}
	
    //@Override
    public float getFogCloseness()
    {
        // TODO Auto-generated method stub
        return 1.0F;
    }

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		int var5 = 100;
		int var6;
		int var7;
		int var8;

		for (var5 = 0; var5 < 10; ++var5)
		{
			var6 = par3 + par2Random.nextInt(16);
			var7 = par2Random.nextInt(60);
			var8 = par4 + par2Random.nextInt(16);
			theWorldGenerator.generate(par1World, par2Random, var6, var7, var8);
		}
	}

	/**
	 * takes temperature, returns color
	 */
	 @Override
	 public int getSkyColorByTemp(float par1)
	 {
		 if (BOPConfigurationMisc.skyColors)
			 return BOPConfigurationMisc.promisedLandSkyColor;
		 else
		 {
			 par1 /= 3.0F;

			 if (par1 < -1.0F)
			 {
				 par1 = -1.0F;
			 }

			 if (par1 > 1.0F)
			 {
				 par1 = 1.0F;
			 }

			 return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
		 }
	 }
}

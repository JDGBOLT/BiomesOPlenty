package biomesoplenty.world.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.IntCache;

public class BiomeLayerRiver extends BiomeLayer
{
	public BiomeLayerRiver(long par1, BiomeLayer par3GenLayer)
	{
		super(par1);
		super.parent = par3GenLayer;
	}

	@Override
	public int[] getInts(int par1, int par2, int par3, int par4)
	{
		int i1 = par1 - 1;
		int j1 = par2 - 1;
		int k1 = par3 + 2;
		int l1 = par4 + 2;
		int[] aint = parent.getInts(i1, j1, k1, l1);
		int[] aint1 = IntCache.getIntCache(par3 * par4);

		for (int i2 = 0; i2 < par4; ++i2)
		{
			for (int j2 = 0; j2 < par3; ++j2)
			{
				int k2 = aint[j2 + 0 + (i2 + 1) * k1];
				int l2 = aint[j2 + 2 + (i2 + 1) * k1];
				int i3 = aint[j2 + 1 + (i2 + 0) * k1];
				int j3 = aint[j2 + 1 + (i2 + 2) * k1];
				int k3 = aint[j2 + 1 + (i2 + 1) * k1];

				if (k3 != 0 && k2 != 0 && l2 != 0 && i3 != 0 && j3 != 0 && k3 == k2 && k3 == i3 && k3 == l2 && k3 == j3)
				{
					aint1[j2 + i2 * par3] = -1;
				}
				else
				{
					aint1[j2 + i2 * par3] = BiomeGenBase.river.biomeID;
				}
			}
		}

		return aint1;
	}
}
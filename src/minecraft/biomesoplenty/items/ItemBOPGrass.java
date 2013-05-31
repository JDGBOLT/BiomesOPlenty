package biomesoplenty.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBOPGrass extends ItemBlock
{
	private static final String[] types = new String[] {"holyGrass", "smolderingGrass"};

	public ItemBOPGrass(int par1)
	{
		super(par1);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int meta = itemstack.getItemDamage();
		if (meta < 0 || meta >= types.length) {
			meta = 0;
		}

		return types[meta];
	}
}

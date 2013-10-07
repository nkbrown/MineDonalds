package MineDonalds.Dimension.Biomes;

import MineDonalds.Main;
import net.minecraft.block.material.Material;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenMcBiome1 extends BiomeGenBase
{
	public BiomeGenMcBiome1(int par1)
	{
		super(par1);
		this.minHeight = 0.1F;
		this.maxHeight = 99.9F;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ((byte)Main.McLeaf.blockID);
		this.fillerBlock = ((byte)Main.McLog.blockID);
		this.setBiomeName("Yellow Tree");
}
}
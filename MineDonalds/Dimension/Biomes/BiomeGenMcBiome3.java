package MineDonalds.Dimension.Biomes;

import MineDonalds.Main;
import MineDonalds.Mobs.EntityEmployee;
import MineDonalds.Mobs.EntityFatZombie;
import MineDonalds.Mobs.EntityMcZombie;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenMcBiome3 extends BiomeGenBase
{
	public BiomeGenMcBiome3(int par1)
	{
		super(par1);
		this.minHeight = 0.1F;
		this.maxHeight = 99.9F;
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.topBlock = ((byte)Block.waterStill.blockID);
		this.fillerBlock = ((byte)Main.McDirt.blockID);
		this.setBiomeName("Swampy...");
}
}
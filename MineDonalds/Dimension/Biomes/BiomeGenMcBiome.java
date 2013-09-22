package MineDonalds.Dimension.Biomes;

import MineDonalds.Main;
import MineDonalds.Mobs.EntityEmployee;
import MineDonalds.Mobs.EntityMcZombie;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenMcBiome extends BiomeGenBase
{
	public BiomeGenMcBiome(int par1)
	{
		super(par1);
		this.minHeight = 0.1F;
		this.maxHeight = 99.9F;
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityEmployee.class, 3, 0, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMcZombie.class, 4, 2, 3));
        this.topBlock = ((byte)Main.McGrass.blockID);
		this.fillerBlock = ((byte)Main.McDirt.blockID);
		this.setBiomeName("McDimension");
}
}
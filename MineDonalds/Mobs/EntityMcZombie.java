package MineDonalds.Mobs;

import MineDonalds.Main;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMcZombie extends EntityZombie
{

	public EntityMcZombie(World par1World) {
		super(par1World);
	}
	protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Main.McZombieHelmet.itemID, 1);
                break;
            case 1:
                this.dropItem(Main.McZombieChestplate.itemID, 1);
                break;
            case 2:
                this.dropItem(Main.McZombieLeggings.itemID, 1);
            case 3:
            	this.dropItem(Main.McZombieBoots.itemID, 1);
        }
    }
}
package MineRonalds.Mobs;

import MineRonalds.Main;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMcZombie extends EntityZombie
{

	public EntityMcZombie(World par1World) {
		super(par1World);
	}
	@Override
	protected int getDropItemId()
    {
        return Main.BurgerTop.itemID;
    }
	@Override
	protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(4))
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
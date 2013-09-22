package MineDonalds.Mobs;

import MineDonalds.Main;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.world.World;


public class EntityEmployee extends EntityVillager
{

	public EntityEmployee(World par1World) {
		super(par1World);
		
	}
	public EntityVillager func_90012_b(EntityAgeable par1EntityAgeable)
    {
        EntityVillager entityemployee = new EntityEmployee(this.worldObj);
        return entityemployee;
    }
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.func_90012_b(par1EntityAgeable);
    }
	@Override
	protected boolean canDespawn()
    {
        return true;
    }
	@Override
	protected int getDropItemId()
    {
        return Main.BurgerButtom.itemID;
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
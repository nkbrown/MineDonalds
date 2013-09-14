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
}
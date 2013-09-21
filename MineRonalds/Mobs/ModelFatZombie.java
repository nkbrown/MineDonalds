package MineRonalds.Mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFatZombie extends ModelBase
{
  //fields
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer Body;
    ModelRenderer Stomach;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer Head;
  
  public ModelFatZombie()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      RightLeg = new ModelRenderer(this, 0, 0);
      RightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
      RightLeg.setRotationPoint(-2F, 12F, 0F);
      RightLeg.setTextureSize(64, 64);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0F, 0F, 0F);
      LeftLeg = new ModelRenderer(this, 0, 0);
      LeftLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
      LeftLeg.setRotationPoint(2F, 12F, 0F);
      LeftLeg.setTextureSize(64, 64);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 24, 22);
      Body.addBox(0F, 0F, 0F, 8, 12, 6);
      Body.setRotationPoint(-4F, 0F, -3F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Stomach = new ModelRenderer(this, 0, 43);
      Stomach.addBox(0F, 0F, 0F, 8, 7, 2);
      Stomach.setRotationPoint(-4F, 5F, -5F);
      Stomach.setTextureSize(64, 64);
      Stomach.mirror = true;
      setRotation(Stomach, 0F, 0F, 0F);
      LeftArm = new ModelRenderer(this, 0, 22);
      LeftArm.addBox(-2F, 0F, -2F, 4, 12, 4);
      LeftArm.setRotationPoint(6F, 0F, 0F);
      LeftArm.setTextureSize(64, 64);
      LeftArm.mirror = true;
      setRotation(LeftArm, 0F, 0F, 0F);
      RightArm = new ModelRenderer(this, 0, 22);
      RightArm.addBox(-2F, 0F, -2F, 4, 12, 4);
      RightArm.setRotationPoint(-6F, 0F, 0F);
      RightArm.setTextureSize(64, 64);
      RightArm.mirror = true;
      setRotation(RightArm, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 31, 0);
      Head.addBox(-4F, -8F, -4F, 8, 8, 8);
      Head.setRotationPoint(0F, 0F, 0F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
  }
  
  public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
	this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    this.Head.render(par7);
    this.Body.render(par7);
    this.RightArm.render(par7);
    this.LeftArm.render(par7);
    this.RightLeg.render(par7);
    this.LeftLeg.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
      this.Head.rotateAngleY = par4 / (180F / (float)Math.PI);
      this.Head.rotateAngleX = par5 / (180F / (float)Math.PI);
      this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.RightArm.rotateAngleZ = 0.0F;
      this.LeftArm.rotateAngleZ = 0.0F;
      this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.RightLeg.rotateAngleY = 0.0F;
      this.LeftLeg.rotateAngleY = 0.0F;
  }
}

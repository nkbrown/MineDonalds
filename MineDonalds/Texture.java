package MineDonalds;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class Texture {
	
	public static Icon getIconFromTextureName(IconRegister iconRegister, String name) {
        return iconRegister.registerIcon("minedonalds" + ":" + name);
    }

}
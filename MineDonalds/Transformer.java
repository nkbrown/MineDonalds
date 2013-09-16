package MineDonalds;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;

public class Transformer implements IClassTransformer {
	@Override
	public byte[] transform(String name, String decodedName, byte[] code) {
		if (decodedName.equals("net.minecraft.block.Block")) {
			String materialClassName=FMLDeobfuscatingRemapper.INSTANCE.unmap("net/minecraft/block/material/Material");
			String desc="(IL"+ (name.equals(decodedName)?"net/minecraft/block/material/Material":materialClassName)+";)V";
			
			return inject(code,decodedName,"<init>",desc, Opcodes.INVOKESPECIAL, "info/jbcs/minecraft/idfix/Idfix","transformBlockId","(I)I");
		} else if (decodedName.equals("net.minecraft.enchantment.Enchantment")) {
			String materialClassName=FMLDeobfuscatingRemapper.INSTANCE.unmap("net/minecraft/enchantment/EnumEnchantmentType");
			String desc="(IIL"+ (name.equals(decodedName)?"net/minecraft/enchantment/EnumEnchantmentType":materialClassName)+";)V";
			
			return inject(code,decodedName,"<init>",desc, Opcodes.INVOKESPECIAL, "info/jbcs/minecraft/idfix/Idfix","transformEnchantmentId","(I)I");
		} else if (decodedName.equals("net.minecraft.item.Item")) {
			return inject(code,decodedName,"<init>","(I)V", Opcodes.INVOKESPECIAL, "info/jbcs/minecraft/idfix/Idfix","transformItemId","(I)I");
		}

		return code;
	}

	public byte[] inject(byte[] code,String className,String methodName,String methodDesc, int opcodeToInjectAfter, String classToCall,String methodToCall,String descToCall){
		ClassNode cn = new ClassNode(Opcodes.ASM4);
		ClassReader cr = new ClassReader(code);
		cr.accept(cn, Opcodes.ASM4);
		
		for (MethodNode method: cn.methods) {
			if(!method.name.equals(methodName) || !method.desc.equals(methodDesc)) continue;
			
			AbstractInsnNode instruction = method.instructions.getFirst();
			while(instruction!=null && instruction.getOpcode()!=opcodeToInjectAfter)
				instruction=instruction.getNext();
			
			if(instruction==null)
				break;
			
			InsnList list = new InsnList();
			list.add(new VarInsnNode(Opcodes.ILOAD, 1));
			list.add(new MethodInsnNode(Opcodes.INVOKESTATIC, classToCall, methodToCall, descToCall));
			list.add(new VarInsnNode(Opcodes.ISTORE, 1));
			
			method.instructions.insert(instruction,list);
			
			ClassWriter cw = new ClassWriter(Opcodes.ASM4);
			cn.accept(cw);
			return cw.toByteArray();
		}
		
		System.out.println("Failed to inject code into "+className+". IDFix won't work.");
		return code;
	}
}
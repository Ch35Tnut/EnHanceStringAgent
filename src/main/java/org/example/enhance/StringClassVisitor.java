package org.example.enhance;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author sunzhiwen1996@hotmail.com
 * @date 2024/1/18 15:57
 */
public class StringClassVisitor extends ClassVisitor {
    public StringClassVisitor(int asm8, ClassWriter cw) {
        super(asm8,cw);
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        //System.out.printf("Transform method:" + name);
        MethodVisitor mv =  super.visitMethod(access, name, descriptor, signature, exceptions);
        if(mv != null && "concat".equals(name)){
            mv = new StringConcatMethodVisitor(Opcodes.ASM8,mv);
        }
        return mv;
    }
}

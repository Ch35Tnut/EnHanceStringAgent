package org.example;

import org.example.enhance.StringClassVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

/**
 * @author sunzhiwen1996@hotmail.com
 * @date 2024/1/18 15:55
 */
public class StringClassFileTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className.equals("java/lang/String")){
            System.out.println("Enhance: " + className);
            ClassReader cr = new ClassReader(classfileBuffer);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            ClassVisitor cv = new StringClassVisitor(Opcodes.ASM8,cw);
            cr.accept(cv,ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
            return cw.toByteArray();
        }else{
            return null;
        }
    }
}

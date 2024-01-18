package org.example.enhance;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author sunzhiwen1996@hotmail.com
 * @date 2024/1/18 16:00
 */
public class StringConcatMethodVisitor extends MethodVisitor {
    public StringConcatMethodVisitor(int asm8, MethodVisitor mv) {
        super(asm8,mv);
    }
    @Override
    public void visitCode(){
        super.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        super.visitLdcInsn("Enhance String::concat");
        super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    }
}

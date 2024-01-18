package org.example;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @author sunzhiwen1996@hotmail.com
 * @date 2024/1/18 15:53
 */
public class StringAgent {
    public static void premain(String args, Instrumentation instrumentation) {
        ClassFileTransformer transformer = new StringClassFileTransformer();
        instrumentation.addTransformer(transformer, true);
        try {
            Class[] classes = instrumentation.getAllLoadedClasses();
            for (Class clazz : classes) {
                if (instrumentation.isModifiableClass(clazz)) {
                    instrumentation.retransformClasses(clazz);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

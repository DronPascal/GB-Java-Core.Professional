import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {
    public static void start(Class testedClass) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Method[] methods = testedClass.getDeclaredMethods();
        HashMap<Integer, ArrayList<Method>> methodsHashmap = new HashMap<>();
        List<Method> methodsList = new ArrayList<>();
        Method beforeMethod = null, afterMethod = null;
        int beforeAntCount = 0, afterAntCount = 0;
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeAntCount++;
                beforeMethod = method;
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                afterAntCount++;
                afterMethod = method;
            }
            if (method.getAnnotation(Test.class) != null) {
                int priority = method.getAnnotation(Test.class).priority();
                if (!methodsHashmap.containsKey(priority)) {
                    methodsHashmap.put(priority, new ArrayList<Method>());
                }
                methodsHashmap.get(priority).add(method);
            }
        }
        if (beforeAntCount > 1 || afterAntCount > 1) {
            throw new RuntimeException();
        }
        // testing startup
        Constructor constructor = testedClass.getDeclaredConstructor();
        // @test methods
        for (Map.Entry<Integer, ArrayList<Method>> entry : methodsHashmap.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Method> list = entry.getValue();
            System.out.println("Priority:" + key);
            for (Method method : list) {
                System.out.println("Testing method: " + method);
                Object testInstance = constructor.newInstance();
                if (beforeMethod != null)
                    beforeMethod.invoke(testInstance);
                method.invoke(testInstance);
                if (afterMethod != null)
                    afterMethod.invoke(testInstance);

            }
        }
    }


    public static void start(String className) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class testedClass = Class.forName(className);
        start(testedClass);
    }
}

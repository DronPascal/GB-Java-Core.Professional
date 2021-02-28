import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, InterruptedException {
        Tester tester = new Tester();

        System.out.println("=====   Test №1. ClassForTest1   =====");
        tester.start(ClassForTest1.class);

        System.out.println("=====   Test №2. ClassForTest2 (2x BeforeSuite)   =====");
        try {
            tester.start("ClassForTest2");
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        Thread.sleep(1000);
        System.out.println("=====   Test №3. ClassForTest3 (2x AfterSuite)   =====");
        try {
            tester.start("ClassForTest3");
        }catch (RuntimeException e){
            e.printStackTrace();
        }

    }
}

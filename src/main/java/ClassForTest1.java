import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class ClassForTest1 {
    @BeforeSuite
    public static void methodAfter() {
        System.out.println("processing before method...");
    }

    @Test(priority = 1)
    public static void method1() {
        System.out.println("test of method2...");
    }

    @Test(priority = 2)
    public static void method21() {
        System.out.println("test of method2...");
    }

    @Test(priority = 2)
    public static void method22() {
        System.out.println("test of method2...");
    }

    @Test(priority = 10)
    public static void method3() {
        System.out.println("test of method2...");
    }

    @AfterSuite
    public static void methodBefore() {
        System.out.println("processing after method...");
    }
}

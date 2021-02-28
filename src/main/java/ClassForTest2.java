import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;

public class ClassForTest2 {
    @BeforeSuite
    public void methodAfter(){
        System.out.println("processing before method...");
    }

    @BeforeSuite
    public void methodAfter2(){
        System.out.println("processing before method...");
    }

    @Test(priority = 2)
    public void method2(){
        System.out.println("test of method2...");
    }

    @AfterSuite
    public void methodBefore(){
        System.out.println("processing after method...");
    }
}

public class ClassForTest1 {
    @BeforeSuite
    public void methodAfter(){
        System.out.println("processing before method...");
    }

    @Test (priority = 1)
    public void method1(){
        System.out.println("test of method2...");
    }

    @Test (priority = 2)
    public void method21(){
        System.out.println("test of method2...");
    }

    @Test (priority = 2)
    public void method22(){
        System.out.println("test of method2...");
    }

    @Test (priority = 10)
    public void method3(){
        System.out.println("test of method2...");
    }

    @AfterSuite
    public void methodBefore(){
        System.out.println("processing after method...");
    }
}

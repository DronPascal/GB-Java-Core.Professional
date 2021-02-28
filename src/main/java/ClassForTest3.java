public class ClassForTest3 {
    @BeforeSuite
    public void methodAfter(){
        System.out.println("processing before method...");
    }

    @Test (priority = 2)
    public void method2(){
        System.out.println("test of method2...");
    }

    @AfterSuite
    public void methodBefore(){
        System.out.println("processing after method...");
    }

    @AfterSuite
    public void methodBefore2(){
        System.out.println("processing after method...");
    }
}

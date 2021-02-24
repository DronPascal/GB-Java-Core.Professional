package hw6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
    private static Main main;

    @BeforeEach
    void init() {
        Main main = new Main();
    }
    //Не понимаю как згнать эти массивы для проверки в файл, пробовал, но ничего толкового не получилось.
    //Примеров в инете не нашел, инфы в методичке про это 0.
    @Test
    void method1Test() {
        int[] result = main.method1(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        Assertions.assertEquals(true, result.equals(new int[]{1, 7}));
    }

    @Test
    void method2Test() {
        boolean result = main.method2(new int[]{1, 1, 1, 1});
        Assertions.assertEquals(false, result);
    }
}
package hw6;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static int[] method1(int[] arr) throws RuntimeException {
        List array = Arrays.asList(arr);
        if (array.isEmpty() || !array.contains(4)) {
            throw new RuntimeException();
        }
        int start = array.lastIndexOf(4);
        return Arrays.copyOfRange(arr, start, arr.length);
    }

    public static boolean method2(int[] arr) {
        if (arr.length == 0) return false;
        for (int i : arr) {
            if (i != 0 || i != 4) return false;
        }
        return true;
    }
}

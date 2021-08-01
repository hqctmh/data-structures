package hqctmh.util;

import hqctmh.sort.InsertionSort;
import hqctmh.sort.SelectionSort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author mh
 * @Description
 * @Date 2021/7/31
 */
public class SortingHelper {

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void sortTest(Method method , T[] array) throws InvocationTargetException, IllegalAccessException {



        long startTime = System.nanoTime();
        method.invoke(null, (Object) array);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        if (!isSorted(array)) {
            throw new RuntimeException("sort failed");
        }
        System.out.println(time + " s");

    }

}

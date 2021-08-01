package hqctmh.sort;

import hqctmh.util.ArrayGenerator;
import hqctmh.util.SortingHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author mh
 * @Description 插入排序
 * 时间复杂度为O(N方)
 * 对于有序数组，时间复杂度为O(n)
 * <p>
 * 6 4 2 3 1 5
 * 4 6 2 3 1 5
 * 2 4 6 3 1 5
 * 2 3 4 6 1 5
 * 1 2 3 4 6 5
 * 1 2 3 4 5 6
 * @Date 2021/7/31
 */
public class InsertionSort {

    /**
     * srr[0,i）排好序，arr[i...n)未排序
     * 把arr[i]放到合适的位置
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 使用赋值操作优化
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort2(T[] array) {
        for (int i = 0; i < array.length; i++) {
            T temp = array[i];
            for (int j = i; j - 1 >= 0; j--) {
                if (array[j - 1].compareTo(temp) > 0) {
                    array[j] = array[j - 1];
                } else {
                    array[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * srr[0,i）未好序，arr[i...n)已排序
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort3(T[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            T temp = array[i];
            for (int j = i; j + 1 < array.length; j++) {
                if (temp.compareTo(array[j+1]) > 0) {
                    array[j] = array[j + 1];
                } else {
                    array[j] = temp;
                    break;
                }
            }

        }
    }


    private static <T> void swap(T[] array, int i, int j) {
        T temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] dataSize = {10000, 100000};
        Method method = InsertionSort.class.getMethod("sort3", Comparable[].class);
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(method, arr);
        }
    }

}

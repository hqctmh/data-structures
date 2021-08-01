package hqctmh.sort;

import hqctmh.util.ArrayGenerator;
import hqctmh.util.SortingHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @Author mh
 * @Description 选择排序
 * 每次都找最小的元素，i前边的元素有序，并且比后面的所有元素都小
 * 时间复杂度为O(N方)
 * <p>
 * 6 4 2 3 1 5
 * 1 4 2 3 6 5
 * 1 2 4 3 6 5
 * 1 2 3 4 6 5
 * 1 2 3 4 5 6
 * @Date 2021/7/31
 */
public class SelectionSort {

    /**
     * 循环不变量
     * arr[i...n]未排序 arr[0...i]已排序
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /**
     * 循环不变量：
     * arr[i...n]已排序 arr[0...i]未排序
     *
     * @param array
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort2(T[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(array, i, maxIndex);
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
        Method method = SelectionSort.class.getMethod("sort2", Comparable[].class);
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(method, arr);
        }
    }
}

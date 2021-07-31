package hqctmh.sort;

import hqctmh.util.ArrayGenerator;
import hqctmh.util.SortingHelper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author mh
 * @Description 选择排序
 * @Date 2021/7/31
 */
public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = -1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex > 0) {
                swap(array, i, minIndex);
            }
        }
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        //N方
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }
}

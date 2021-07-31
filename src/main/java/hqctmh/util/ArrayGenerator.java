package hqctmh.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author mh
 * @Description
 * @Date 2021/7/31
 */
public class ArrayGenerator {

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }


    /**
     * 生成一个随机数组
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(bound);
        }
        return arr;
    }

}

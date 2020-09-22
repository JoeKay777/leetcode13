package leetcode13.algorithm.wk08;

import java.util.Arrays;

/**
 * 基数排序
 */
public class Sort_Radix {

    // 基数排序
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {   // 从低位到高位依次排序

            // 分桶个数
            int[] buckets = new int[10];

            for (int val : arr) {
                buckets[val / exp % 10]++;
            }
            // 累计次数，用于排序时对应下标
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            // 排序
            int[] temp = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[arr[i] / exp % 10] - 1] = arr[i];
                buckets[arr[i] / exp % 10]--;
            }
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }
    }

    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

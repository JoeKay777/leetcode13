package leetcode13.algorithm.wk08;

import leetcode13.algorithm.wk03.MaxDepth;

import java.util.Arrays;

/**
 * 计数排序
 */
public class Sort_Counting {

    // 计数排序
    public static void countingSort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }
        int[] countArr = new int[max - min + 1];

        for (int num : arr) {
            countArr[num - min] += 1;
        }

        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

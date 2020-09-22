package leetcode13.algorithm.wk09;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Sort_Quick {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        // 取最左侧为脊椎点
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}

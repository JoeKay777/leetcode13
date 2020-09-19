package leetcode13.algorithm.wk08;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Sort_Merge {

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, l, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 3, 2, 6, 9, -1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.printf(Arrays.toString(arr));
    }

}

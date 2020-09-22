package leetcode13.algorithm.wk08;

/**
 * 快速排序
 */
public class Sort_Quick {

    // 方法一
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = arr[left];  // 基准点
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {      // 优先从右边走，保证相遇点是小于基准点的(基准点从左侧选的)
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    // 方法二
    public static void quickSort_2(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = arr[left], i = left, j = right;
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
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort_2(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

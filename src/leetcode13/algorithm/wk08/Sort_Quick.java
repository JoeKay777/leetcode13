package leetcode13.algorithm.wk08;

/**
 * 快速排序
 */
public class Sort_Quick {

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int pivot = arr[left];  // 基准点
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] >= pivot && i < j) {      // 优先从左边走，保证相遇点是小于基准点的
                j--;
            }
            while (arr[i] <= pivot && i <j) {
                i++;
            }
            if(i <j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        quickSort(arr, left, i -1);
        quickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

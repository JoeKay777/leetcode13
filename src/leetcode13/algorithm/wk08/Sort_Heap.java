package leetcode13.algorithm.wk08;

import java.util.Arrays;

/**
 * 堆排序
 */
public class Sort_Heap {

    // 堆排序
    public static void heapSort(int[] arr) {
        // 将原始数据构建成大顶堆（升序-大顶堆，降序-小顶堆）
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换堆顶与数组最左侧值
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }

    }

    /**
     * 下沉调整大顶堆
     * @param arr
     * @param i
     * @param length
     */
    private static void siftDown(int[] arr, int i, int length) {
        int half = length >> 1;
        int val = arr[i];
        while (i < half) {
            int child = (i << 1) + 1;
            int rightChild = child + 1;
            if (rightChild < length && arr[rightChild] > arr[child]) {    // 取子节点的较大值
                child = rightChild;
            }
            if (val >= arr[child]) {   // 满足最大堆特性，停止调整
                break;
            }
            arr[i] = arr[child];
            i = child;
        }
        arr[i] = val;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package subject.algorithm;

import java.util.jar.JarEntry;

/**
 * 38 | 分治算法：谈一谈大规模计算框架MapReduce中的分治思想
 */
public class Chapter_38 {

    private int num = 0;    // 逆序对总数

    /**
     * 统计一个数组的逆序对数
     *
     * @param a
     * @return
     */
    public int count(int[] a) {
        mergeSortCount(a, 0, a.length - 1);
        return num;
    }

    private void mergeSortCount(int[] a, int l, int r) {
        // 终止条件
        if (l >= r) {
            return;
        }
        // 分治
        int mid = l + (r - l) / 2;
        mergeSortCount(a, l, mid);
        mergeSortCount(a, mid + 1, r);

        // 合并结果
        mergeResult(a, l, mid, r);

    }

    private void mergeResult(int[] a, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0,l1 = l, l2 = mid + 1;
        while (l1 <= mid && l2 <= r) {
            if (a[l1] > a[l2]) {      // 逆序
                num += (mid - l1 + 1);
                temp[i++] = a[l2++];
            } else {
                temp[i++] = a[l1++];
            }
        }
        while(l1 <= mid) {
            temp[i++] = a[l1++];
        }
        while(l2 <= r) {
            temp[i++] = a[l2++];
        }
        for(i = 0; i < temp.length; i++) {
            a[l+i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int count = new Chapter_38().count(new int[]{2, 4, 3, 1, 5, 6});
        System.out.println(count);
    }

}

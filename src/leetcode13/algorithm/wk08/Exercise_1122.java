package leetcode13.algorithm.wk08;

import java.util.*;

/**
 * 1122.数组的相对排序
 */
public class Exercise_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(arr1.length);
        for (int i = 0; i < arr1.length; i++) {
            Integer count = map.getOrDefault(arr1[i], 0);
            count++;
            map.put(arr1[i], count);
        }
        int k = 0;
        for (int num :
                arr2) {
            Integer count = map.get(num);
            while (count-- > 0) {
                arr1[k++] = num;
            }
            map.remove(num);
        }
        Integer[] others = map.keySet().toArray(new Integer[0]);
        Arrays.sort(others);
        for (int num : others) {
            Integer count = map.get(num);
            while (count-- > 0) {
                arr1[k++] = num;
            }
        }
        return arr1;
    }
}

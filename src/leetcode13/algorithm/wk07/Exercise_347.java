package leetcode13.algorithm.wk07;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 */
public class Exercise_347 {

    /**
     * 堆排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {
            Integer count = numMap.getOrDefault(num, 0);
            count++;
            numMap.put(num, count);
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numMap.get(o1).compareTo(numMap.get(o2));
            }
        });
        for (Integer key : numMap.keySet()) {
            if (queue.size() == k && numMap.get(queue.peek()) < numMap.get(key)) {
                queue.poll();
                queue.add(key);
            } else if (queue.size() < k) {
                queue.add(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    /**
     * 捅排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequenta_2(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            Integer count = numMap.getOrDefault(num, 0);
            count++;
            numMap.put(num, count);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            Integer frequency = numMap.get(entry.getKey());
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = buckets.length - 1; i >= 0 && j < k; i--) {
            if (buckets[i] != null) {
                for (Integer num : buckets[i]) {
                    res[j++] = num;
                }
            }
        }
        return res;
    }

}

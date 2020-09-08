package leetcode13.algorithm.wk06;

import java.util.*;

public class HW_403 {

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);  // key-石头距离，value-到达该石头的跳跃距离
        for (int st : stones) {
            map.put(st, new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int jumpSize : map.get(stones[i])) {
                for (int gap = jumpSize - 1; gap <= jumpSize + 1; gap++) {
                    if (gap > 0 && map.containsKey(stones[i] + gap)) {
                        if (stones[i] + gap == stones[stones.length - 1]) {
                            return true;
                        }
                        map.get(stones[i] + gap).add(gap);
                    }
                }
            }
        }
        return false;
    }

}

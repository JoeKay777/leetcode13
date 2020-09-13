package leetcode13.algorithm.wk07;

import java.util.*;

public class HW_readme {

    // 双BFS模板
    public int doubleBFS(String start, String end) {
        // 双BFS模板
        Set<String> lSet = new HashSet<>(); // 记录左侧已访问节点
        Set<String> rSet = new HashSet<>(); // 记录右侧已访问节点
        Queue<String> left = new LinkedList<>();    // 左侧队列遍历
        Queue<String> right = new LinkedList<>();   // 右侧队列遍历
        left.offer(start);
        right.offer(end);
        lSet.add(start);
        rSet.add(end);
        int level = 0;  // 深度
        while (!left.isEmpty() && !right.isEmpty()) {
            level++;
            //优先遍历节点少的一边
            if (right.size() < left.size()) {
                Queue<String> tpQueue = left;
                left = right;
                right = tpQueue;
                Set<String> tpSet = lSet;
                lSet = rSet;
                rSet = tpSet;
            }
            int size = left.size();
            while (size-- > 0) {
                String cur = left.poll();   // 获取当前节点

                // 获取该节点下一层节点
                List<String> childes = findAllChildren(cur);
                for (String child : childes) {
                    // 右侧已访问节点包含该子节点表示相遇
                    if (rSet.contains(child)) {
                        return level;
                    }
                    left.offer(child);
                    lSet.add(child);
                }
            }
        }
        return level;
    }

    // 获取当前节点的所有子节点
    private List<String> findAllChildren(String cur) {
        // TODO
        return null;
    }

}

package leetcode13.algorithm.wk04;

import java.util.*;

/**
 * 433. 最小基因变化
 */
public class MinMutation {

    /**
     * 广度优先遍历
     * start的子节点即为基因库中相差一个基因的序列
     * 广度遍历，直到找到匹配end的节点,深度即为最小变化
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bkSet = new HashSet<>();
        for (String bk : bank) {
            bkSet.add(bk);
        }
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String old = queue.poll();
                if (old.equals(end)) return count;
                for (int i = 0; i < old.length(); i++) {
                    for (char gene : genes) {
                        if (old.charAt(i) == gene) { //与自身相同则不需要替换
                            continue;
                        }
                        char[] chars = old.toCharArray();
                        chars[i] = gene;
                        String newStr = new String(chars);
                        if (bkSet.contains(newStr)) {    // 新基因属于基因库才合法
                            queue.offer(newStr);
                            bkSet.remove(newStr);   // 移除访问过的，避免循环
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }


}

package leetcode13.algorithm.wk07;

import java.util.*;

/**
 * 433. 最小基因变化
 */
public class HW_433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        Queue<String> left = new LinkedList<>();
        Queue<String> right = new LinkedList<>();
        Set<String> lSet = new HashSet<>();
        Set<String> rSet = new HashSet<>();
        left.offer(start);
        lSet.add(start);
        right.offer(end);
        rSet.add(end);
        int count = 0;
        char[] bk = {'A','C','G','T'};
        while (!left.isEmpty() && !right.isEmpty()) {
            count++;
            if (right.size() < left.size()) {
                Queue<String> tpQuenue = left;
                left = right;
                right = tpQuenue;
                Set<String> tpSet = lSet;
                lSet = rSet;
                rSet = tpSet;
            }
            int size = left.size();
            while(size-- > 0) {
                String cur = left.poll();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (int j = 0; j < 4; j++) {
                        if(bk[j] == old) continue;
                        chars[i] = bk[j];
                        String newBank = new String(chars);
                        if(lSet.contains(newBank)) continue;
                        if(rSet.contains(newBank)) return count;
                        if(bankSet.contains(newBank)) {
                            lSet.add(newBank);
                            left.offer(newBank);
                        }
                    }
                    chars[i] = old;
                }
            }
        }
        return -1;
    }
}

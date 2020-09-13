package leetcode13.algorithm.wk07;

import java.util.*;

/**
 * 单词接龙
 */
public class HW_127 {
    /**
     * 双BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> allWords = new HashSet<>(wordList);
        if (!allWords.contains(endWord)) {
            return 0;
        }
        Set<String> lSet = new HashSet<>();
        Set<String> rSet = new HashSet<>();
        Queue<String> start = new LinkedList<>();
        Queue<String> end = new LinkedList<>();
        start.add(beginWord);
        end.add(endWord);
        lSet.add(beginWord);
        rSet.add(endWord);
        int count = 1;
        while (!start.isEmpty() && !end.isEmpty()) {
            count++;
            //优先遍历节点少的一边
            if (end.size() < start.size()) {
                Queue<String> tp = start;
                start = end;
                end = tp;
                Set<String> tpSet = lSet;
                lSet = rSet;
                rSet = tpSet;
            }
            int size = start.size();
            while (size-- > 0) {
                String cur = start.poll();
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) continue;
                        chars[i] = ch;
                        String newWord = new String(chars);
                        if (lSet.contains(newWord)) continue;
                        if (rSet.contains(newWord)) return count;
                        if (allWords.contains(newWord)) {
                            lSet.add(newWord);
                            start.offer(newWord);
                        }
                    }
                    chars[i] = old;
                }
            }
        }
        return 0;
    }
}

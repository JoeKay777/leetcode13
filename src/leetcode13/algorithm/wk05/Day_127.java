package leetcode13.algorithm.wk05;

import java.util.*;

/**
 * 127.单词接龙
 */
public class Day_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);  // 转成Set,增删查元素速度快
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return count;
                }
                char[] chars = cur.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old) {
                            continue;
                        }
                        chars[i] = ch;
                        String newWord = new String(chars);
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);    // 多条路径，具有同一节点时，该节点必在同一高度（否则该路径不是最短路径），故此处可以直接去重。
                        }
                    }
                    chars[i] = old;
                }
            }
        }
        return 0;
    }
}

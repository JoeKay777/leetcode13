package leetcode13.algorithm.wk04;

import java.util.*;

/**
 * 127. 单词接龙
 */
public class Problem_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.offer(beginWord);
        int count = 1;  // 包含begigWord
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return count;
                }
                // 子节点为单词库中与当前节点相差一个字符的元素
                char[] chars = cur.toCharArray();
                for(int i = 0; i < cur.length(); i++) {
                    char oldChar = chars[i];
                    for( char c = 'a'; c <= 'z'; c++) {
                        if(chars[i] == c) {
                            continue;
                        }
                        chars[i] = c;
                        String newStr = new String(chars);
                        if(wordSet.contains(newStr)) {
                            queue.offer(newStr);
                            wordSet.remove(newStr);
                        }
                    }
                    chars[i] = oldChar; // 还原
                }
            }
            count++;
        }
        return 0;
    }

}

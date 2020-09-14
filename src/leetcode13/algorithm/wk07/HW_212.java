package leetcode13.algorithm.wk07;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 */
public class HW_212 {

    /**
     * board前缀匹配words构成的前缀树
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        WordTrie root = new WordTrie();
        for (String word : words) {
            root.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                seachWord(root, board, i, j, result);
            }
        }
        return result;
    }

    private void seachWord(WordTrie root, char[][] board, int i, int j, List<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') return;
        int index = board[i][j] - 'a';
        WordTrie cur = root.next[index];
        // 终止条件
        if (cur == null) {
            return;
        }
        // 满足结果
        if (cur.word != null) {
            result.add(cur.word);
            cur.word = null;
        }
        char c = board[i][j];
        board[i][j] = '*';  // 记录遍历过的
        // 回溯
        seachWord(cur, board, i - 1, j, result);
        seachWord(cur, board, i + 1, j, result);
        seachWord(cur, board, i, j - 1, result);
        seachWord(cur, board, i, j + 1, result);

        // 撤销
        board[i][j] = c;
    }

    class WordTrie {
        private String word;    // 叶子节点存储word，非叶子节点为null
        private WordTrie[] next;

        WordTrie() {
            word = null;
            next = new WordTrie[26];
        }

        void insert(String word) {
            if (word == null) return;
            WordTrie cur = this;
            for (int i = 0; i < word.toCharArray().length; i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new WordTrie();
                }
                cur = cur.next[index];
            }
            cur.word = word;
        }
    }
}

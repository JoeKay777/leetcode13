package leetcode13.algorithm.wk07;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 */
public class Exercise_212 {
    public List<String> findWords(char[][] board, String[] words) {
        // 将words构建成Trie树
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, root);
            }
        }
        return res;
    }

    private List<String> res = new ArrayList<>();

    private void backtrack(char[][] board, int i, int j, Trie cur) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*') {
            return;
        }

        Trie next = cur.next[board[i][j] - 'a'];
        if (next == null) {
            return;
        }

        if (next.word != null) {
            res.add(next.word);
            next.word = null;   // 匹配过的word移除，避免重复
        }

        char c = board[i][j];
        board[i][j] = '*';  // 访问过的标记'*'
        // 四个方向 回溯
        backtrack(board, i - 1, j, next);
        backtrack(board, i + 1, j, next);
        backtrack(board, i, j - 1, next);
        backtrack(board, i, j + 1, next);
        board[i][j] = c;    // 撤销
    }


    class Trie {
        String word;    // 叶子节点保存word值
        Trie[] next;

        Trie() {
            word = null;
            next = new Trie[26];
        }

        void insert(String word) {
            if (word == null) {
                return;
            }
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Trie();
                }
                cur = cur.next[index];
            }
            cur.word = word;
        }
    }

    public static void main(String[] args) {
        new Exercise_212().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"});
    }

}

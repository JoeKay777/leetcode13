package leetcode13.algorithm.wk07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 */
public class Exercise_212 {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (searchWord(board, word)) {
                result.add(word);
            }
        }
        return result;
    }


    private boolean searchWord(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    Set<String> visited = new HashSet<>();
                    visited.add(i + "$" + j);
                    if(backtrack(board, word.toCharArray(), 1, visited, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] word, int index, Set<String> visited, int i, int j) {
        // 终止条件
        if (index == word.length) {
            return true;
        }

        // 选择、剪枝
        boolean up = false, down = false, left = false, right = false;
        if (i - 1 >= 0 && board[i - 1][j] == word[index] && !visited.contains(asssemCoordinate(i - 1, j))) {
            visited.add(asssemCoordinate(i - 1, j));
            // 回溯
            up = backtrack(board, word, index + 1, visited, i - 1, j);
            // 撤销
            visited.remove(asssemCoordinate(i - 1, j));
        }
        if (i + 1 < board.length && board[i + 1][j] == word[index] && !visited.contains(asssemCoordinate(i + 1, j))) {
            visited.add(asssemCoordinate(i + 1, j));
            down = backtrack(board, word, index + 1, visited, i + 1, j);
            visited.remove(asssemCoordinate(i + 1, j));
        }
        if (j - 1 >= 0 && board[i][j - 1] == word[index] && !visited.contains(asssemCoordinate(i, j - 1))) {
            visited.add(asssemCoordinate(i, j - 1));
            left = backtrack(board, word, index + 1, visited, i, j - 1);
            visited.remove(asssemCoordinate(i, j - 1));
        }
        if (j + 1 < board[0].length && board[i][j + 1] == word[index] && !visited.contains(asssemCoordinate(i, j + 1))) {
            visited.add(asssemCoordinate(i, j + 1));
            right = backtrack(board, word, index + 1, visited, i, j + 1);
            visited.remove(asssemCoordinate(i, j + 1));
        }
        return up || down || left || right;

    }

    private String asssemCoordinate(int i, int j) {
        return i + "$" + j;
    }

    public static void main(String[] args) {
        new Exercise_212().findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
        new String[]{"oath","pea","eat","rain"});
    }
}

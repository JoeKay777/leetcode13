package leetcode13.algorithm.wk07;

/**
 * 208. 实现 Trie (前缀树)
 */
public class HW_208 {

    class Trie {

        private boolean isEnd;
        private Trie[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null) return;
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Trie();
                }
                cur = cur.next[index];
            }
            cur.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchHelp(word);
            return node != null && node.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie node = searchHelp(prefix);
            return node != null;
        }

        private Trie searchHelp(String prefix) {
            if (prefix == null) return null;
            Trie cur = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    return null;
                }
                cur = cur.next[index];
            }
            return cur;
        }
    }
}

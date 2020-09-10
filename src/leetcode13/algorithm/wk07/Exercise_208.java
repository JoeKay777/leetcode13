package leetcode13.algorithm.wk07;

public class Exercise_208 {
    class Trie {

        private boolean isEnd;
        private Trie[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.isEnd = false;
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
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
            cur.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    return false;
                }
                cur = cur.next[index];
            }
            return cur.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null) {
                return false;
            }
            Trie cur = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (cur.next[index] == null) {
                    return false;
                }
                cur = cur.next[index];
            }
            return true;
        }
    }
}

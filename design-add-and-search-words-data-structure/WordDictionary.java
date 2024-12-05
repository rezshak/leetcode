// https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // T: O(n), S: O(n)
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    // T (best no wildcards): O(n)
    // T (worst with wildcards): O(26^n)
    // S: O(n)
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    // Recursive helper method for search with wildcard support
    // T (best no wildcards): O(n)
    // T (worst with wildcards): O(26^n)
    // S: O(n)
    private boolean searchHelper(String word, int idx, TrieNode node) {
        // Base case: reached the end of the word
        if (idx == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(idx);

        // Handle wildcard '.' character
        if (ch == '.') {
            // Try all possible children
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, idx + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        // Regular character search
        int charIdx = ch - 'a';

        // If character node doesn't exist, return false
        if (node.children[charIdx] == null) {
            return false;
        }

        // Recursive search for the next character
        return searchHelper(word, idx + 1, node.children[charIdx]);
    }

    public static void main(String[] args) {
        var wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad")); // false
        System.out.println(wd.search("bad")); // true
        System.out.println(wd.search(".ad")); // true
        System.out.println(wd.search("b..")); // true
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

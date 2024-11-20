// https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {

    private TrieNode root;

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    public Trie() {
        root = new TrieNode();
    }

    // T: O(n), S: O(n)
    public void insert(String word) {
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

    // T: O(n), S: O(1)
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    // T: O(n), S: O(1)
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return null;
            }
            curr = curr.children[idx];
        }
        return curr;
    }

    public static void main(String[] args) {
        var trie = new Trie();

        String[] commands = { "Trie", "insert", "search", "search", "startsWith", "insert", "search" };
        String[] arguments = { "", "apple", "apple", "app", "app", "app", "app" };

        for (int i = 1; i < commands.length; i++) {
            switch (commands[i]) {
                case "insert":
                    trie.insert(arguments[i]);
                    System.out.println("Inserted: " + arguments[i]);
                    break;
                case "search":
                    boolean searchResult = trie.search(arguments[i]);
                    System.out.println("Search for \"" + arguments[i] + "\": " + searchResult);
                    break;
                case "startsWith":
                    boolean prefixResult = trie.startsWith(arguments[i]);
                    System.out.println("Starts with \"" + arguments[i] + "\": " + prefixResult);
                    break;
            }
        }
    }

}

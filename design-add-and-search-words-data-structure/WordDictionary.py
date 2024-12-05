# https://leetcode.com/problems/design-add-and-search-words-data-structure/

class TrieNode:

    def __init__(self):
        self.children = [None] * 26
        self.is_end_of_word = False


class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    # T: O(n), S: O(n)
    def addWord(self, word: str) -> None:
        curr = self.root
        for ch in word:
            idx = ord(ch) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = TrieNode()
            curr = curr.children[idx]
        curr.is_end_of_word = True

    # T (best no wildcards): O(n)
    # T (worst with wildcards): O(26^n)
    # S: O(n)
    def search(self, word: str) -> bool:
        return self._search_helper(word, 0, self.root)

    # T (best no wildcards): O(n)
    # T (worst with wildcards): O(26^n)
    # S: O(n)
    def _search_helper(self, word: str, idx: int, node: TrieNode) -> bool:
        if idx == len(word):
            return node.is_end_of_word

        ch = word[idx]

        if ch == '.':
            for child in node.children:
                if child is not None and self._search_helper(word, idx + 1, child):
                    return True
            return False

        char_idx = ord(ch) - ord('a')

        if node.children[char_idx] is None:
            return False

        return self._search_helper(word, idx + 1, node.children[char_idx])


def main() -> None:
    wd = WordDictionary()
    wd.addWord("bad")
    wd.addWord("dad")
    wd.addWord("mad")
    print(wd.search("pad"))  # false
    print(wd.search("bad"))  # true
    print(wd.search(".ad"))  # true
    print(wd.search("b.."))  # true


if __name__ == "__main__":
    main()

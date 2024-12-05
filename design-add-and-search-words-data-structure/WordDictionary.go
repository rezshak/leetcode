// https://leetcode.com/problems/design-add-and-search-words-data-structure/

package main

import (
	"fmt"
)

type TrieNode struct {
	children    [26]*TrieNode
	isEndOfWord bool
}

type WordDictionary struct {
	root *TrieNode
}

func Constructor() WordDictionary {
	return WordDictionary{root: &TrieNode{}}
}

// T: O(n), S: O(n)
func (wd *WordDictionary) AddWord(word string) {
	curr := wd.root
	for _, ch := range word {
		idx := ch - 'a'
		if curr.children[idx] == nil {
			curr.children[idx] = &TrieNode{}
		}
		curr = curr.children[idx]
	}
	curr.isEndOfWord = true
}

// T (best no wildcards): O(n)
// T (worst with wildcards): O(26^n)
// S: O(n)
func (wd *WordDictionary) Search(word string) bool {
	return wd.searchHelper(word, 0, wd.root)
}

// T (best no wildcards): O(n)
// T (worst with wildcards): O(26^n)
// S: O(n)
func (wd *WordDictionary) searchHelper(word string, idx int, node *TrieNode) bool {
	if idx == len(word) {
		return node.isEndOfWord
	}

	ch := word[idx]

	if ch == '.' {
		for _, child := range node.children {
			if child != nil && wd.searchHelper(word, idx+1, child) {
				return true
			}
		}
		return false
	}

	charIdx := ch - 'a'

	if node.children[charIdx] == nil {
		return false
	}

	return wd.searchHelper(word, idx+1, node.children[charIdx])
}

func main() {
	wd := Constructor()
	wd.AddWord("bad")
	wd.AddWord("dad")
	wd.AddWord("mad")
	fmt.Println(wd.Search("pad")) // false
	fmt.Println(wd.Search("bad")) // true
	fmt.Println(wd.Search(".ad")) // true
	fmt.Println(wd.Search("b..")) // true
}

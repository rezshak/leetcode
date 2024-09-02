// https://leetcode.com/problems/group-anagrams/

package main

import (
	"fmt"
	"sort"
)

// T: O(nk log k), S: O(nk)
func groupAnagrams(strs []string) [][]string {
	dict := make(map[string][]string)
	for _, str := range strs {
		key := makeKey(str)
		dict[key] = append(dict[key], str)
	}

	result := make([][]string, 0, len(dict))
	for _, group := range dict {
		result = append(result, group)
	}
	return result
}

func makeKey(s string) string {
	runes := []rune(s)
	sort.Slice(runes, func(i, j int) bool {
		return runes[i] < runes[j]
	})
	return string(runes)
}

func main() {
	strs1 := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	strs2 := []string{""}
	strs3 := []string{"a"}
	fmt.Println(groupAnagrams(strs1))
	fmt.Println(groupAnagrams(strs2))
	fmt.Println(groupAnagrams(strs3))
}

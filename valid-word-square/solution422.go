// https://leetcode.com/problems/valid-word-square/

package main

import (
	"fmt"
)

func validWordSquare(words []string) bool {
	rows := len(words)
	for row := 0; row < rows; row++ {
		word := words[row]
		for col := 0; col < len(word); col++ {
			if col >= rows || row >= len(words[col]) || word[col] != words[col][row] {
				return false
			}
		}
	}
	return true
}

func main() {
	words1 := []string{"abcd", "bnrt", "crmy", "dtye"}
	words2 := []string{"abcd", "bnrt", "crm", "dt"}
	words3 := []string{"ball", "area", "read", "lady"}
	words4 := []string{"ball", "asee", "let", "lep"}

	fmt.Println(validWordSquare(words1)) // true
	fmt.Println(validWordSquare(words2)) // true
	fmt.Println(validWordSquare(words3)) // false
	fmt.Println(validWordSquare(words4)) // false
}

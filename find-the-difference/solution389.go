// https://leetcode.com/problems/find-the-difference/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func findTheDifference(s string, t string) byte {
	sSum, tSum := 0, 0
	for _, ch := range s {
		sSum += int(ch)
	}
	for _, ch := range t {
		tSum += int(ch)
	}
	return byte(tSum - sSum)
}

// T: O(n), S: O(1)
func findTheDifferenceDict(s string, t string) byte {
	dict := make([]int, 128)
	for _, ch := range s {
		dict[ch]++
	}
	for _, ch := range t {
		if dict[ch] == 0 {
			return byte(ch)
		}
		dict[ch]--
	}
	return '\x00'
}

// T: O(n), S: O(n)
func findTheDifferenceMap(s string, t string) byte {
	sCounts := make(map[rune]int)
	for _, ch := range s {
		sCounts[ch]++
	}
	for _, ch := range t {
		if _, ok := sCounts[ch]; !ok || sCounts[ch] == 0 {
			return byte(ch)
		}
		sCounts[ch]--
	}
	return '\x00'
}

// T: O(n), S: O(1)
func findTheDifferenceBitwise(s string, t string) byte {
	var res rune
	for _, ch := range s {
		res ^= ch
	}
	for _, ch := range t {
		res ^= ch
	}
	return byte(res)
}

func main() {
	s1, t1 := "abcd", "abcde"
	fmt.Println(string(findTheDifference(s1, t1)))        // e
	fmt.Println(string(findTheDifferenceMap(s1, t1)))     // e
	fmt.Println(string(findTheDifferenceDict(s1, t1)))    // e
	fmt.Println(string(findTheDifferenceBitwise(s1, t1))) // e
	s2, t2 := "", "y"
	fmt.Println(string(findTheDifference(s2, t2)))        // y
	fmt.Println(string(findTheDifferenceMap(s2, t2)))     // y
	fmt.Println(string(findTheDifferenceDict(s2, t2)))    // y
	fmt.Println(string(findTheDifferenceBitwise(s2, t2))) // y
	s3, t3 := "a", "aa"
	fmt.Println(string(findTheDifference(s3, t3)))        // a
	fmt.Println(string(findTheDifferenceMap(s3, t3)))     // a
	fmt.Println(string(findTheDifferenceDict(s3, t3)))    // a
	fmt.Println(string(findTheDifferenceBitwise(s3, t3))) // a
}

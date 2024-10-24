// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

package main

import (
	"fmt"
	"strings"
)

// T: O(nm), S: O(1)
func strStr(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
	m, n := len(haystack), len(needle)
	i, j := 0, 0
	for i < m && j < n {
		if haystack[i] == needle[j] {
			i++
			j++
			if j == n {
				return i - n
			}
		} else {
			i = i - j + 1
			j = 0
		}
	}
	return -1
}

// T: O(n + m), S: O(1)
func strStrBuiltin(haystack string, needle string) int {
	return strings.Index(haystack, needle)
}

// T: O(nm), S: O(n)
func strStrSlidingWindowSubstring(haystack string, needle string) int {
	m, n := len(haystack), len(needle)
	for i := 0; i <= m-n; i++ {
		if haystack[i:i+n] == needle {
			return i
		}
	}
	return -1
}

// T: O(n + m), S: O(1)
func strStrRabinKarp(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
	if len(needle) > len(haystack) {
		return -1
	}

	base := 256  // A base for hashing, considering all ASCII characters.
	prime := 101 // A prime number to mod the hash values, reducing the hash value size.
	needleHash, haystackHash := 0, 0
	n, m := len(haystack), len(needle)

	// Pre-compute the highest base exponent for the needle length (base^(m-1) % prime).
	highestBasePower := 1
	for i := 0; i < m-1; i++ {
		highestBasePower = (highestBasePower * base) % prime
	}

	// Calculate the hash value of the needle and the first window of the haystack.
	for i := 0; i < m; i++ {
		needleHash = (needleHash*base + int(needle[i])) % prime
		haystackHash = (haystackHash*base + int(haystack[i])) % prime
	}

	// Slide over the haystack string to find the first occurrence of the needle.
	for i := 0; i <= n-m; i++ {
		// If the current window's hash matches with the needle's hash, do a direct comparison.
		if needleHash == haystackHash {
			if haystack[i:i+m] == needle {
				return i
			}
		}

		// Calculate the hash value for the next window in the haystack (if not at the end).
		if i < n-m {
			haystackHash = (haystackHash - int(haystack[i])*highestBasePower) % prime
			haystackHash = (haystackHash*base + int(haystack[i+m])) % prime

			// We might get a negative hash value, convert it to positive.
			if haystackHash < 0 {
				haystackHash += prime
			}
		}
	}

	return -1
}

func main() {
	fmt.Println(strStr("sadbutsad", "sad"))                           // 0
	fmt.Println(strStr("leetcode", "leeto"))                          // -1
	fmt.Println(strStr("mississippi", "issip"))                       // 4
	fmt.Println(strStrBuiltin("mississippi", "issip"))                // 4
	fmt.Println(strStrSlidingWindowSubstring("mississippi", "issip")) // 4
	fmt.Println(strStrRabinKarp("mississippi", "issip"))              // 4
	fmt.Println(strStr("mississippi", ""))                            // 0
}

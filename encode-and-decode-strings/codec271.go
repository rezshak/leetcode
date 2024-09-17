// https://leetcode.com/problems/encode-and-decode-strings/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

type Codec struct{}

// T: O(n), S: O(n)
func (codec *Codec) Encode(strs []string) string {
	var sb strings.Builder
	for _, str := range strs {
		lenStr := strconv.Itoa(len(str))
		sb.WriteString(lenStr)
		sb.WriteString("#")
		sb.WriteString(str)
	}
	return sb.String()
}

// T: O(n), S: O(n)
func (codec *Codec) Decode(s string) []string {
	var result []string
	start, end := 0, 0
	lenS := len(s)
	for start < lenS {
		for s[end] != '#' {
			end++
		}
		wordLen, _ := strconv.Atoi(s[start:end])
		word := s[end+1 : end+wordLen+1]
		result = append(result, word)
		start = end + wordLen + 1
		end = start
	}
	return result
}

func main() {
	codec := Codec{}
	encoded := codec.Encode([]string{"hello", "world"})
	fmt.Println("Encoded:", encoded)
	decoded := codec.Decode(encoded)
	fmt.Println("Decoded:", decoded)
}

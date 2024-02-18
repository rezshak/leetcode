// https://leetcode.com/problems/reverse-bits/

package main

import (
	"fmt"
	"strconv"
)

// T: O(1), S: O(1)
func reverseBits(num uint32) uint32 {
	var res uint32
	var lsb uint32
	for i := 31; i >= 0; i-- {
		lsb = num & 1
		lsb <<= i
		res |= lsb
		num >>= 1
	}
	return res
}

func main() {
	num, _ := strconv.ParseUint("00000010100101000001111010011100", 2, 32)
	fmt.Println(reverseBits(uint32(num))) // 964176192
}

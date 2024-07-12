// https://leetcode.com/problems/flipping-an-image/

package main

import "fmt"

// T: O(n), S: O(1)
func flipAndInvertImage(image [][]int) [][]int {
	n := len(image)
	for _, row := range image {
		left, right := 0, n-1
		for left <= right {
			if left == right || row[left] == row[right] {
				row[left], row[right] = row[right]^1, row[left]^1
			}
			left++
			right--
		}
	}
	return image
}

func printImage(image [][]int) {
	for _, row := range image {
		fmt.Println(row)
	}
}

func main() {
	img1 := [][]int{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}
	img2 := [][]int{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}
	res1 := flipAndInvertImage(img1)
	res2 := flipAndInvertImage(img2)
	printImage(res1) // [[1 0 0] [0 1 0] [1 1 1]]
	printImage(res2) // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
}

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(n), S: O(logn)
func sortedArrayToBST(nums []int) *TreeNode {
	return helper(nums, 0, len(nums)-1)
}

func helper(nums []int, left, right int) *TreeNode {
	if left > right {
		return nil
	}
	mid := left + (right-left)/2
	node := &TreeNode{Val: nums[mid]}
	node.Left = helper(nums, left, mid-1)
	node.Right = helper(nums, mid+1, right)
	return node
}

func main() {
	nums1 := []int{-10, -3, 0, 5, 9}
	nums2 := []int{1, 3}
	root1 := sortedArrayToBST(nums1)
	fmt.Println(root1) // [0,-10,5,null,-3,null,9]
	root2 := sortedArrayToBST(nums2)
	fmt.Println(root2) // [1,null,3]
}

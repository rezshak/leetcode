// https://leetcode.com/problems/minimum-depth-of-binary-tree/

package main

import (
	"fmt"
	"math"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(n), S: O(h)
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil {
		return minDepth(root.Right) + 1
	}
	if root.Right == nil {
		return minDepth(root.Left) + 1
	}
	leftDepth := minDepth(root.Left)
	rightDepth := minDepth(root.Right)
	return int(math.Min(float64(leftDepth), float64(rightDepth))) + 1
}

func main() {
	// Balanced tree
	root1 := &TreeNode{Val: 3}
	root1.Left = &TreeNode{Val: 9}
	root1.Right = &TreeNode{Val: 20}
	root1.Right.Left = &TreeNode{Val: 15}
	root1.Right.Right = &TreeNode{Val: 7}
	fmt.Println(minDepth(root1)) // 2
	// Skewed tree
	root2 := &TreeNode{Val: 2}
	root2.Right = &TreeNode{Val: 3}
	root2.Right.Right = &TreeNode{Val: 4}
	root2.Right.Right.Right = &TreeNode{Val: 5}
	root2.Right.Right.Right.Right = &TreeNode{Val: 6}
	fmt.Println(minDepth(root2)) // 5
	// Empty tree
	var root3 *TreeNode
	fmt.Println(minDepth(root3)) // 0
	// Single node tree
	root4 := &TreeNode{Val: 1}
	fmt.Println(minDepth(root4)) // 1
}

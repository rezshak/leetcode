// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(n), S: O(n)
func findTarget(root *TreeNode, k int) bool {
	seen := make(map[int]bool)
	return findTargetInorder(root, k, seen)
}

func findTargetInorder(root *TreeNode, k int, seen map[int]bool) bool {
	if root == nil {
		return false
	}
	diff := k - root.Val
	if _, found := seen[diff]; found {
		return true
	}
	seen[root.Val] = true
	return findTargetInorder(root.Left, k, seen) ||
		findTargetInorder(root.Right, k, seen)
}

func main() {
	// // [5,3,6,2,4,null,7]
	root := &TreeNode{Val: 5}
	root.Left = &TreeNode{Val: 3}
	root.Right = &TreeNode{Val: 6}
	root.Left.Left = &TreeNode{Val: 2}
	root.Left.Right = &TreeNode{Val: 4}
	root.Right.Right = &TreeNode{Val: 7}
	fmt.Println(findTarget(root, 9)) // true
}

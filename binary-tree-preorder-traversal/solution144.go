// https://leetcode.com/problems/binary-tree-preorder-traversal/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(n), S: O(n)
func preorderTraversal(root *TreeNode) []int { // nlr
	var result []int
	preorderHelper(root, &result)
	return result
}

func preorderHelper(node *TreeNode, result *[]int) {
	if node == nil {
		return
	}
	*result = append(*result, node.Val)
	preorderHelper(node.Left, result)
	preorderHelper(node.Right, result)
}

// T: O(n), S: O(n)
func preorderTraversalStack(root *TreeNode) []int { // nlr
	var result []int
	var stack []*TreeNode
	curr := root

	for curr != nil || len(stack) > 0 {
		for curr != nil {
			result = append(result, curr.Val)
			stack = append(stack, curr)
			curr = curr.Left
		}
		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		curr = curr.Right
	}

	return result
}

func main() {
	root1 := &TreeNode{Val: 1}
	root1.Right = &TreeNode{Val: 2}
	root1.Right.Left = &TreeNode{Val: 3}

	fmt.Println(preorderTraversal(root1))      // [1, 2, 3]
	fmt.Println(preorderTraversalStack(root1)) // [1, 2, 3]
	fmt.Println(preorderTraversalStack(nil))   // []
}

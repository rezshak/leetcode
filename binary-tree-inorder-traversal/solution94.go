// https://leetcode.com/problems/binary-tree-inorder-traversal/

package main

import "fmt"

type TreeNode struct {
	Val         int
	Left, Right *TreeNode
}

func NewTreeNode(val int) *TreeNode {
	return &TreeNode{
		Val: val,
	}
}

// T: O(n), S: O(n)
func inorderTraversal(root *TreeNode) []int {
	var res []int
	helper(root, &res)
	return res
}

func helper(node *TreeNode, res *[]int) {
	if node != nil {
		helper(node.Left, res)
		*res = append(*res, node.Val)
		helper(node.Right, res)
	}
}

// T: O(n), S: O(n)
func inorderTraversalStack(root *TreeNode) []int {
	var result []int
	stack := []*TreeNode{}
	curr := root
	for curr != nil || len(stack) > 0 {
		for curr != nil {
			stack = append(stack, curr)
			curr = curr.Left
		}
		curr, stack = stack[len(stack)-1], stack[:len(stack)-1]
		result = append(result, curr.Val)
		curr = curr.Right
	}
	return result
}

func main() {
	// 1,null,2,3
	root1 := NewTreeNode(1)
	root1.Left = nil
	root1.Right = NewTreeNode(2)
	root1.Right.Left = NewTreeNode(3)
	fmt.Println(inorderTraversal(root1))      // [1,3,2]
	fmt.Println(inorderTraversalStack(root1)) // [1,3,2]
	var root2 *TreeNode = nil
	fmt.Println(inorderTraversal(root2))      // []
	fmt.Println(inorderTraversalStack(root2)) // []
}

// https://leetcode.com/problems/binary-tree-postorder-traversal/

package main

import "fmt"

type TreeNode struct {
	Val         int
	Left, Right *TreeNode
}

func NewTreeNode(Val int) *TreeNode {
	return &TreeNode{Val: Val}
}

// T: O(n), S: O(n)
func postorderTraversal(root *TreeNode) []int {
	var result []int
	helper(root, &result)
	return result
}

func helper(node *TreeNode, result *[]int) {
	if node != nil {
		helper(node.Left, result)
		helper(node.Right, result)
		*result = append(*result, node.Val)
	}
}

// T: O(n), S: O(n)
func postorderTraversalIterative(root *TreeNode) []int {
	var result []int
	if root == nil {
		return result
	}
	var s1 []*TreeNode
	var s2 []*TreeNode
	s1 = append(s1, root)
	for len(s1) > 0 {
		curr := s1[len(s1)-1]
		s1 = s1[:len(s1)-1]
		s2 = append(s2, curr)

		if curr.Left != nil {
			s1 = append(s1, curr.Left)
		}
		if curr.Right != nil {
			s1 = append(s1, curr.Right)
		}
	}
	for len(s2) > 0 {
		result = append(result, s2[len(s2)-1].Val)
		s2 = s2[:len(s2)-1]
	}
	return result
}

func main() {
	// [1,null,2,3]
	root1 := NewTreeNode(1)
	root1.Right = NewTreeNode(2)
	root1.Right.Left = NewTreeNode(3)
	fmt.Println(postorderTraversal(root1))          // [3,2,1]
	fmt.Println(postorderTraversalIterative(root1)) // [3,2,1]
}

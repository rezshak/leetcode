// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(n), S: O(h)
func kthSmallest(root *TreeNode, k int) int {
	var list []int
	inorder(root, &list)
	return list[k-1]
}

func inorder(node *TreeNode, list *[]int) {
	if node == nil {
		return
	}
	inorder(node.Left, list)
	*list = append(*list, node.Val)
	inorder(node.Right, list)
}

// T: T: O(h + k), S: O(h)
func kthSmallestIterative(root *TreeNode, k int) int {
	stack := []*TreeNode{}
	curr := root

	for curr != nil || len(stack) > 0 {
		for curr != nil {
			stack = append(stack, curr)
			curr = curr.Left
		}

		curr = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		k--

		if k == 0 {
			return curr.Val
		}

		curr = curr.Right
	}

	return -1
}

func main() {
	root1 := &TreeNode{Val: 3}
	root1.Left = &TreeNode{Val: 1}
	root1.Left.Right = &TreeNode{Val: 2}
	root1.Right = &TreeNode{Val: 4}
	fmt.Println(kthSmallest(root1, 1))          // 1
	fmt.Println(kthSmallestIterative(root1, 1)) // 1

	root2 := &TreeNode{Val: 5}
	root2.Left = &TreeNode{Val: 3}
	root2.Left.Left = &TreeNode{Val: 2}
	root2.Left.Left.Left = &TreeNode{Val: 1}
	root2.Left.Right = &TreeNode{Val: 4}
	root2.Right = &TreeNode{Val: 6}
	fmt.Println(kthSmallest(root2, 3))          // 3
	fmt.Println(kthSmallestIterative(root2, 3)) // 3
}

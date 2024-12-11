// https://leetcode.com/problems/invert-binary-tree/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(n), S: O(w)
func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	queue := []*TreeNode{root}

	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]

		// Swap the left and right children
		curr.Left, curr.Right = curr.Right, curr.Left

		if curr.Left != nil {
			queue = append(queue, curr.Left)
		}
		if curr.Right != nil {
			queue = append(queue, curr.Right)
		}
	}

	return root
}

// T: O(n), S: O(h)
func invertTreeDfs(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	// Recursively invert the left and right subtrees
	tempLeft := invertTreeDfs(root.Left)
	tempRight := invertTreeDfs(root.Right)

	// Swap the left and right children
	root.Left = tempRight
	root.Right = tempLeft

	return root
}

func printTreeInorder(root *TreeNode) {
	if root == nil {
		return
	}
	printTreeInorder(root.Left)
	fmt.Printf("%d ", root.Val)
	printTreeInorder(root.Right)
}

func main() {
	root1 := &TreeNode{Val: 4}
	root1.Left = &TreeNode{Val: 2}
	root1.Right = &TreeNode{Val: 7}
	root1.Left.Left = &TreeNode{Val: 1}
	root1.Left.Right = &TreeNode{Val: 3}
	root1.Right.Left = &TreeNode{Val: 6}
	root1.Right.Right = &TreeNode{Val: 9}
	fmt.Print("\nOriginal Tree (Inorder): ")
	printTreeInorder(root1)
	fmt.Print("\nInverted Tree (Inorder): ")
	printTreeInorder(invertTree(root1))

	root2 := &TreeNode{Val: 2}
	root2.Left = &TreeNode{Val: 1}
	root2.Right = &TreeNode{Val: 3}
	fmt.Print("\nOriginal Tree (Inorder): ")
	printTreeInorder(root2)
	fmt.Print("\nInverted Tree (Inorder): ")
	printTreeInorder(invertTreeDfs(root2))
}

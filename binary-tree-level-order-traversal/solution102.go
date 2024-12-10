// https://leetcode.com/problems/binary-tree-level-order-traversal/

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
func levelOrder(root *TreeNode) [][]int {
	var result [][]int
	if root == nil {
		return result
	}
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		levelSize := len(queue)
		var currLevel []int
		for i := 0; i < levelSize; i++ {
			currNode := queue[0]
			queue = queue[1:]
			currLevel = append(currLevel, currNode.Val)
			if currNode.Left != nil {
				queue = append(queue, currNode.Left)
			}
			if currNode.Right != nil {
				queue = append(queue, currNode.Right)
			}
		}
		result = append(result, currLevel)
	}
	return result
}

func main() {
	root1 := &TreeNode{Val: 3}
	root1.Left = &TreeNode{Val: 9}
	root1.Right = &TreeNode{Val: 20}
	root1.Right.Left = &TreeNode{Val: 15}
	root1.Right.Right = &TreeNode{Val: 7}
	fmt.Println(levelOrder(root1)) // [[3],[9,20],[15,7]]

	root2 := &TreeNode{Val: 1}
	fmt.Println(levelOrder(root2)) // [[1]]

	var root3 *TreeNode = nil
	fmt.Println(levelOrder(root3)) // []
}

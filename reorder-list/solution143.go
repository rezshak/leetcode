// https://leetcode.com/problems/reorder-list/

package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(n), S: O(1)
func reorderList(head *ListNode) {
	// Find the mid
	slow, fast := head, head.Next
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	first, second := head, slow.Next
	// Sever the lists
	slow.Next = nil
	var prev *ListNode
	// Reverse the second list
	for second != nil {
		tempNext := second.Next
		second.Next = prev
		prev = second
		second = tempNext
	}
	second = prev
	for second != nil {
		temp1 := first.Next
		temp2 := second.Next
		first.Next = second
		second.Next = temp1
		first = temp1
		second = temp2
	}
}

func printList(head *ListNode) {
	for head != nil {
		fmt.Print(head.Val)
		if head.Next != nil {
			fmt.Print(" -> ")
		}
		head = head.Next
	}
	fmt.Println()
}

func main() {
	head1 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, nil}}}}
	printList(head1) // 1 -> 2 -> 3 -> 4
	reorderList(head1)
	printList(head1) // 1 -> 4 -> 2 -> 3
}

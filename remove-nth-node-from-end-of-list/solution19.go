// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

package main

import (
	"fmt"
	"strings"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(n), S: O(1)
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	right := head
	for i := 0; i < n && right != nil; i++ {
		right = right.Next
	}
	if right == nil {
		return head.Next
	}
	left := head
	for right.Next != nil {
		right = right.Next
		left = left.Next
	}
	left.Next = left.Next.Next
	return head
}

// T: O(n), S: O(1)
func removeNthFromEndTwoPass(head *ListNode, n int) *ListNode {
	if head == nil {
		return head
	}
	size := 0
	curr := head
	for curr != nil {
		curr = curr.Next
		size++
	}
	if size == n {
		return head.Next
	}
	prev := head
	for i := 0; i < size-n-1; i++ {
		prev = prev.Next
	}
	prev.Next = prev.Next.Next
	return head
}

func printList(head *ListNode) {
	var sb strings.Builder
	sb.WriteString("[ ")
	curr := head
	for curr != nil {
		sb.WriteString(fmt.Sprintf("%d ", curr.Val))
		curr = curr.Next
	}
	sb.WriteString("]")
	fmt.Println(sb.String())
}

func main() {
	head1 := &ListNode{Val: 1}
	head1.Next = &ListNode{Val: 2}
	head1.Next.Next = &ListNode{Val: 3}
	head1.Next.Next.Next = &ListNode{Val: 4}
	head1.Next.Next.Next.Next = &ListNode{Val: 5}
	printList(head1)
	newHead1 := removeNthFromEnd(head1, 2)
	printList(newHead1) // [ 1 2 3 5 ]
	head2 := &ListNode{Val: 1}
	printList(head2)
	newHead2 := removeNthFromEnd(head2, 1)
	printList(newHead2) // [ ]
	head3 := &ListNode{Val: 3, Next: &ListNode{Val: 4}}
	newHead3 := removeNthFromEndTwoPass(head3, 1)
	printList(newHead3) // [ 3 ]
}

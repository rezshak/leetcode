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
	fake := &ListNode{Val: -1, Next: head}
	left, right := fake, head
	for i := 0; i < n && right != nil; i++ {
		right = right.Next
	}
	for right != nil {
		right = right.Next
		left = left.Next
	}
	left.Next = left.Next.Next
	return fake.Next
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
	printList(removeNthFromEnd(head1, 2)) // [ 1 2 3 5 ]
	head2 := &ListNode{1, nil}
	printList(head2)
	printList(removeNthFromEnd(head2, 1)) // [ ]
}

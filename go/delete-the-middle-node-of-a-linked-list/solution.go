// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

package main

import (
	"fmt"
	"strings"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func NewListNode(val int) *ListNode {
	return &ListNode{Val: val, Next: nil}
}

// T: O(n), S: O(1)
func deleteMiddle(head *ListNode) *ListNode {
	fake := NewListNode(-1)
	fake.Next = head
	prev, slow, fast := fake, head, head
	for fast != nil && fast.Next != nil {
		prev = slow
		slow = slow.Next
		fast = fast.Next.Next
	}
	prev.Next = slow.Next
	return fake.Next
}

func (l *ListNode) printList(head *ListNode) {
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
	var head1 = NewListNode(1) // [1,3,4,7,1,2,6]
	head1.Next = NewListNode(3)
	head1.Next.Next = NewListNode(4)
	head1.Next.Next.Next = NewListNode(7)
	head1.Next.Next.Next.Next = NewListNode(1)
	head1.Next.Next.Next.Next.Next = NewListNode(2)
	head1.Next.Next.Next.Next.Next.Next = NewListNode(6)
	head1.printList(head1)
	head1 = deleteMiddle(head1)
	head1.printList(head1)
}

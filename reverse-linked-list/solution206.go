// https://leetcode.com/problems/reverse-linked-list/

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func NewListNode(val int) *ListNode {
	return &ListNode{Val: val, Next: nil}
}

// T: O(n), S: O(1)
func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	var prev, curr *ListNode = nil, head
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	return prev
}

func printList(head *ListNode) {
	fmt.Print("[ ")
	for curr := head; curr != nil; curr = curr.Next {
		fmt.Printf("%d ", curr.Val)
	}
	fmt.Println("]")
}

func main() {
	head1 := NewListNode(1)
	head1.Next = NewListNode(2)
	head1.Next.Next = NewListNode(3)
	head1.Next.Next.Next = NewListNode(4)
	head1.Next.Next.Next.Next = NewListNode(5)
	printList(head1)
	head1 = reverseList(head1)
	printList(head1)
}

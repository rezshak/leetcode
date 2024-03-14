// https://leetcode.com/problems/middle-of-the-linked-list/

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(n), S: O(1)
func middleNode(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

func (l *ListNode) printList(head *ListNode) {
	fmt.Print("[ ")
	curr := head
	for curr != nil {
		fmt.Printf("%d ", curr.Val)
		curr = curr.Next
	}
	fmt.Println("]")
}

func main() {
	// 1,2,3,4,5
	head1 := &ListNode{Val: 1}
	head1.Next = &ListNode{Val: 2}
	head1.Next.Next = &ListNode{Val: 3}
	head1.Next.Next.Next = &ListNode{Val: 4}
	head1.Next.Next.Next.Next = &ListNode{Val: 5}
	head1.printList(head1)
	fmt.Println(middleNode(head1).Val) // 3
}

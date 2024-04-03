// https://leetcode.com/problems/linked-list-cycle/

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(n), S: O(1)
func hasCycle(head *ListNode) bool {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return true
		}
	}
	return false
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
	// 3,2,0,-4
	head1 := &ListNode{Val: 3}
	head1.Next = &ListNode{Val: 2}
	head1.Next.Next = &ListNode{Val: 0}
	head1.Next.Next.Next = &ListNode{Val: -4}
	head1.printList(head1)
	fmt.Println(hasCycle(head1)) // false
	head1.Next.Next.Next = head1.Next
	fmt.Println(hasCycle(head1)) // true
}

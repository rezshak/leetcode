// https://leetcode.com/problems/reverse-linked-list/

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(n), S: O(1)
func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	var prev *ListNode
	curr := head
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	return prev
}

// T: O(n), S: O(n)
func reverseListStack(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	stack := []*ListNode{}
	curr := head
	for curr != nil {
		stack = append(stack, curr)
		curr = curr.Next
	}
	newHead := stack[len(stack)-1]
	stack = stack[:len(stack)-1]
	curr = newHead
	for len(stack) > 0 {
		curr.Next = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		curr = curr.Next
	}
	curr.Next = nil
	return newHead
}

// T: O(n), S: O(n)
func reverseListRec(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	reversedListHead := reverseListRec(head.Next)
	head.Next.Next = head
	head.Next = nil
	return reversedListHead
}

func printList(head *ListNode) {
	curr := head
	for curr != nil {
		fmt.Print(curr.Val)
		if curr.Next != nil {
			fmt.Print(" -> ")
		}
		curr = curr.Next
	}
	fmt.Println()
}

func main() {
	list1 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	printList(list1)              // 1 -> 2 -> 3 -> 4 -> 5
	printList(reverseList(list1)) // 5 -> 4 -> 3 -> 2 -> 1

	list2 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, nil}}}}
	printList(list2)                   // 1 -> 2 -> 3 -> 4
	printList(reverseListStack(list2)) // 4 -> 3 -> 2 -> 1

	list3 := &ListNode{1, &ListNode{2, &ListNode{3, nil}}}
	printList(list3)                 // 1 -> 2 -> 3
	printList(reverseListRec(list3)) // 3 -> 2 -> 1
}

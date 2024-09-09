// https://leetcode.com/problems/merge-two-sorted-lists/

package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	fake := &ListNode{-1, nil}
	tail := fake
	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			tail.Next = list1
			list1 = list1.Next
		} else {
			tail.Next = list2
			list2 = list2.Next
		}
		tail = tail.Next
	}
	if list1 == nil {
		tail.Next = list2
	} else {
		tail.Next = list1
	}
	return fake.Next
}

func printList(head *ListNode) {
	curr := head
	fmt.Print("[ ")
	for curr != nil {
		fmt.Print(curr.Val, " ")
		curr = curr.Next
	}
	fmt.Println("]")
}

func main() {
	list1 := &ListNode{1, &ListNode{2, &ListNode{4, nil}}}
	list2 := &ListNode{1, &ListNode{3, &ListNode{4, nil}}}
	merged := mergeTwoLists(list1, list2)
	printList(merged) // [1,1,2,3,4,4]
	list1 = nil
	list2 = &ListNode{0, nil}
	merged = mergeTwoLists(list1, list2)
	printList(merged) // [0]
}

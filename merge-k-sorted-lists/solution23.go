// https://leetcode.com/problems/merge-k-sorted-lists/

package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(nlogk), S: O(1)
func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}
	n := len(lists)
	for i := 1; i < n; i++ {
		lists[i] = merge(lists[i], lists[i-1])
	}
	return lists[n-1]
}

func merge(l1, l2 *ListNode) *ListNode {
	fake := &ListNode{-1, nil}
	curr := fake
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			curr.Next = l1
			l1 = l1.Next
		} else {
			curr.Next = l2
			l2 = l2.Next
		}
		curr = curr.Next
	}
	if l1 != nil {
		curr.Next = l1
	} else {
		curr.Next = l2
	}
	return fake.Next
}

func printList(node *ListNode) {
	for node != nil {
		fmt.Print(node.Val, " -> ")
		node = node.Next
	}
	fmt.Println("None")
}

func main() {
	list1 := &ListNode{1, &ListNode{4, &ListNode{5, nil}}}
	list2 := &ListNode{1, &ListNode{3, &ListNode{4, nil}}}
	list3 := &ListNode{2, &ListNode{6, nil}}
	merged1 := mergeKLists([]*ListNode{list1, list2, list3})
	fmt.Println("Merged list using merge method:")
	printList(merged1)
}

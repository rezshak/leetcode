// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

type ListNode struct {
	Val  int
	next *ListNode
}

// T: O(n), S: O(1)
func deleteDuplicates(head *ListNode) *ListNode {
	curr := head
	for curr != nil && curr.next != nil {
		if curr.next.Val == curr.Val {
			curr.next = curr.next.next
		} else {
			curr = curr.next
		}
	}
	return head
}

func (node *ListNode) String() string {
	var sb strings.Builder
	sb.WriteString("[ ")
	curr := node
	for curr != nil {
		sb.WriteString(strconv.Itoa(curr.Val))
		sb.WriteString(" ")
		curr = curr.next
	}
	sb.WriteString("]")
	return sb.String()
}

func main() {
	// [1,1,2]
	head := &ListNode{Val: 1}
	head.next = &ListNode{Val: 1}
	head.next.next = &ListNode{Val: 2}
	fmt.Println(head.String()) // [1,1,2]
	head = deleteDuplicates(head)
	fmt.Println(head.String()) // [1,2]
}

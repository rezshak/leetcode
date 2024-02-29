// https://leetcode.com/problems/reverse-nodes-in-k-group/

package main

import (
	"fmt"
	"strings"
)

type ListNode struct {
	val  int
	next *ListNode
}

// T: O(n), S: O(1)
func reverseKGroup(head *ListNode, k int) *ListNode {
	fake := &ListNode{-1, head}
	groupPrev := fake
	for {
		kth := getKth(groupPrev, k)
		if kth == nil {
			break
		}
		// reverse group
		groupNext := kth.next
		prev := groupNext
		curr := groupPrev.next
		for curr != groupNext {
			temp := curr.next
			curr.next = prev
			prev = curr
			curr = temp
		}
		temp := groupPrev.next
		groupPrev.next = prev
		groupPrev = temp
	}
	return fake.next
}

func getKth(node *ListNode, k int) *ListNode {
	curr := node
	for i := 0; i < k; i++ {
		if curr.next == nil {
			return nil
		}
		curr = curr.next
	}
	return curr
}

func printList(head *ListNode) {
	var sb strings.Builder
	curr := head
	sb.WriteString("[ ")
	for curr != nil {
		sb.WriteString(fmt.Sprintf("%d ", curr.val))
		curr = curr.next
	}
	sb.WriteString("]")
	fmt.Println(sb.String())
}

func main() {
	head1 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	newHead1 := reverseKGroup(head1, 2)
	printList(newHead1) // [2 1 4 3 5]
	head2 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	newHead2 := reverseKGroup(head2, 3)
	printList(newHead2) // [3 2 1 4 5]
}

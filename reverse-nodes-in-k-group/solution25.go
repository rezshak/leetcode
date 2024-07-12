// https://leetcode.com/problems/reverse-nodes-in-k-group/

package main

import "fmt"

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
		groupNext := kth.next
		newGroupPrev := groupPrev.next // The head of the current group will be the prev of the next group
		groupPrev.next = reverse(groupPrev.next, groupNext)
		groupPrev = newGroupPrev
	}
	return fake.next
}

func reverse(start, end *ListNode) *ListNode {
	prev := end
	for start != end {
		temp := start.next
		start.next = prev
		prev = start
		start = temp
	}
	return prev
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
	curr := head
	fmt.Print("[ ")
	for curr != nil {
		fmt.Print(curr.val, " ")
		curr = curr.next
	}
	fmt.Println("]")
}

func main() {
	head1 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	newHead1 := reverseKGroup(head1, 2)
	printList(newHead1) // [2 1 4 3 5]
	head2 := &ListNode{1, &ListNode{2, &ListNode{3, &ListNode{4, &ListNode{5, nil}}}}}
	newHead2 := reverseKGroup(head2, 3)
	printList(newHead2) // [3 2 1 4 5]
}

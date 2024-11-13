// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(n), S: O(1)
func pairSum(head *ListNode) int {
	firstHalfEnd := findFirstHalfEnd(head)
	secondHalfStart := reverseList(firstHalfEnd.Next)
	maxTwinSum := 0
	curr1, curr2 := head, secondHalfStart
	for curr2 != nil {
		currSum := curr1.Val + curr2.Val
		if currSum > maxTwinSum {
			maxTwinSum = currSum
		}
		curr1 = curr1.Next
		curr2 = curr2.Next
	}
	firstHalfEnd.Next = reverseList(secondHalfStart)
	return maxTwinSum
}

// T: O(n), S: O(1)
func findFirstHalfEnd(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

// T: O(n), S: O(1)
func reverseList(node *ListNode) *ListNode {
	var prev *ListNode
	curr := node
	for curr != nil {
		tempNext := curr.Next
		curr.Next = prev
		prev = curr
		curr = tempNext
	}
	return prev
}

func main() {
	head1 := &ListNode{5, &ListNode{4, &ListNode{2, &ListNode{1, nil}}}}
	head2 := &ListNode{4, &ListNode{2, &ListNode{2, &ListNode{3, nil}}}}
	head3 := &ListNode{1, &ListNode{100000, nil}}
	fmt.Println(pairSum(head1)) // 6
	fmt.Println(pairSum(head2)) // 7
	fmt.Println(pairSum(head3)) // 100001
}

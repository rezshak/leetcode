// https://leetcode.com/problems/intersection-of-two-linked-lists/

package main

import (
	"fmt"
	"math"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(n+m), S: O(1)
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	currA := headA
	currB := headB
	for currA != currB {
		if currA != nil {
			currA = currA.Next
		} else {
			currA = headB
		}
		if currB != nil {
			currB = currB.Next
		} else {
			currB = headA
		}
	}
	return currA
}

// T: O(n+m), S: O(1)
func getIntersectionNodeTwoPtr(headA, headB *ListNode) *ListNode {
	countA := 0
	currA := headA
	for currA != nil {
		currA = currA.Next
		countA++
	}
	countB := 0
	currB := headB
	for currB != nil {
		currB = currB.Next
		countB++
	}
	diff := math.Abs(float64(countA) - float64(countB))
	currA = headA
	currB = headB
	if countA > countB {
		for i := 0; i < int(diff); i++ {
			currA = currA.Next
		}
	} else {
		for i := 0; i < int(diff); i++ {
			currB = currB.Next
		}
	}
	for currA != currB {
		currA = currA.Next
		currB = currB.Next
	}
	return currA
}

// T: O(n), S: O(n)
func getIntersectionNodeSet(headA, headB *ListNode) *ListNode {
	set := make(map[*ListNode]bool)
	currA := headA
	for currA != nil {
		set[currA] = true
		currA = currA.Next
	}
	currB := headB
	for currB != nil {
		if set[currB] {
			return currB
		}
		currB = currB.Next
	}
	return nil
}

func main() {
	// [4,1,8,4,5]
	headA := &ListNode{4, nil}
	headA.Next = &ListNode{1, nil}
	headA.Next.Next = &ListNode{8, nil}
	headA.Next.Next.Next = &ListNode{4, nil}
	headA.Next.Next.Next.Next = &ListNode{5, nil}
	// [5,6,1,8,4,5]
	headB := &ListNode{5, nil}
	headB.Next = &ListNode{6, nil}
	headB.Next.Next = &ListNode{1, nil}
	headB.Next.Next.Next = headA.Next.Next
	fmt.Println(getIntersectionNodeTwoPtr(headA, headB).Val) // 8
	fmt.Println(getIntersectionNodeSet(headA, headB).Val)    // 8
}

// https://leetcode.com/problems/add-two-numbers/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// T: O(max(m, n)), S: O(max(m, n))
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	fake := &ListNode{}
	tail := fake
	carry := 0
	for l1 != nil || l2 != nil {
		sum := carry
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		carry = sum / 10
		tail.Next = &ListNode{Val: sum % 10}
		tail = tail.Next
	}
	if carry > 0 {
		tail.Next = &ListNode{Val: carry}
	}
	return fake.Next
}

func (ln *ListNode) String() string {
	var sb strings.Builder
	for ln != nil {
		sb.WriteString(strconv.Itoa(ln.Val))
		if ln.Next != nil {
			sb.WriteString(" -> ")
		}
		ln = ln.Next
	}
	return sb.String()
}

func main() {
	l1 := &ListNode{Val: 2}
	l1.Next = &ListNode{Val: 4}
	l1.Next.Next = &ListNode{Val: 3}
	l2 := &ListNode{Val: 5}
	l2.Next = &ListNode{Val: 6}
	l2.Next.Next = &ListNode{Val: 4}
	l := addTwoNumbers(l1, l2)
	fmt.Println(l) // 7 -> 0 -> 8
}

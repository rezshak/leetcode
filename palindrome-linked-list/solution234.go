// https://leetcode.com/problems/palindrome-linked-list/

package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func NewListNode(val int) *ListNode {
	return &ListNode{Val: val, Next: nil}
}

// T: O(n), S: O(1)
func isPalindrome(head *ListNode) bool {
	firstHalfEnd := firstHalfEnd(head)
	secondHalfStart := reverseList(firstHalfEnd.Next)

	result := true
	for curr1, curr2 := head, secondHalfStart; result && curr2 != nil; curr1, curr2 = curr1.Next, curr2.Next {
		if curr1.Val != curr2.Val {
			result = false
		}
	}
	firstHalfEnd.Next = reverseList(secondHalfStart)
	return result
}

func firstHalfEnd(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

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

// T: O(n), S: O(n)
func isPalindromeHalfStack(head *ListNode) bool {
	var st []int
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		st = append(st, slow.Val)
		slow = slow.Next
		fast = fast.Next.Next
	}
	if fast != nil {
		slow = slow.Next
	}
	i := len(st) - 1
	for slow != nil && len(st) != 0 {
		val := slow.Val
		if val != st[i] {
			return false
		}
		i--
		slow = slow.Next
	}
	return true
}

// T: O(n), S: O(n)
func isPalindromeFullStack(head *ListNode) bool {
	var st []int
	curr := head
	for curr != nil {
		st = append(st, curr.Val)
		curr = curr.Next
	}
	curr = head
	i := len(st) - 1
	for curr != nil {
		val := st[i]
		if val != curr.Val {
			return false
		}
		i--
		curr = curr.Next
	}
	return true
}

func main() {
	// [1,2,2,1]
	head1 := NewListNode(1)
	head1.Next = NewListNode(2)
	head1.Next.Next = NewListNode(2)
	head1.Next.Next.Next = NewListNode(1)
	fmt.Println(isPalindrome(head1))          // true
	fmt.Println(isPalindromeHalfStack(head1)) // true
	fmt.Println(isPalindromeFullStack(head1)) // true
	// [1,2]
	head2 := NewListNode(1)
	head2.Next = NewListNode(2)
	fmt.Println(isPalindrome(head2))          // false
	fmt.Println(isPalindromeHalfStack(head2)) // false
	fmt.Println(isPalindromeFullStack(head2)) // false
	// [1,1,2,1]
	head3 := NewListNode(1)
	head3.Next = NewListNode(1)
	head3.Next.Next = NewListNode(2)
	head3.Next.Next.Next = NewListNode(1)
	fmt.Println(isPalindrome(head3))          // false
	fmt.Println(isPalindromeHalfStack(head3)) // false
	fmt.Println(isPalindromeFullStack(head3)) // false
	// [1,0,1]
	var head4 = NewListNode(1)
	head4.Next = NewListNode(0)
	head4.Next.Next = NewListNode(1)
	fmt.Println(isPalindrome(head4))          // true
	fmt.Println(isPalindromeHalfStack(head4)) // true
	fmt.Println(isPalindromeFullStack(head4)) // true
}

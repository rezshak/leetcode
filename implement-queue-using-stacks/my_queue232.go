// https://leetcode.com/problems/implement-queue-using-stacks/

package main

import (
	"container/list"
	"fmt"
)

type MyQueue struct {
	s1 *list.List
	s2 *list.List
}

func Constructor() MyQueue {
	return MyQueue{s1: list.New(), s2: list.New()}
}

// T: O(n), S: O(n)
func (q *MyQueue) Push(x int) {
	q.s1.PushBack(x)
}

// T: O(1), S: O(1)
func (q *MyQueue) Pop() int {
	if q.s2.Len() == 0 {
		for q.s1.Len() > 0 {
			q.s2.PushBack(q.s1.Remove(q.s1.Back()))
		}
	}
	e := q.s2.Back()
	q.s2.Remove(e)
	return e.Value.(int)
}

// T: O(1), S: O(1)
func (q *MyQueue) Peek() int {
	if q.s2.Len() == 0 {
		for q.s1.Len() > 0 {
			q.s2.PushBack(q.s1.Remove(q.s1.Back()))
		}
	}
	e := q.s2.Back()
	return e.Value.(int)
}

// T: O(1), S: O(1)
func (q *MyQueue) Empty() bool {
	return q.s1.Len() == 0 && q.s2.Len() == 0
}

func main() {
	q := Constructor()
	q.Push(1)
	q.Push(2)
	fmt.Println(q.Peek())  // prints 1
	fmt.Println(q.Pop())   // prints 1
	fmt.Println(q.Empty()) // prints false
}

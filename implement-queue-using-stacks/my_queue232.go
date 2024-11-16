// https://leetcode.com/problems/implement-queue-using-stacks/

package main

import (
	"container/list"
	"fmt"
)

type MyQueue struct {
	st1 *list.List
	st2 *list.List
}

func Constructor() MyQueue {
	return MyQueue{st1: list.New(), st2: list.New()}
}

// T: O(n), S: O(n)
func (q *MyQueue) Push(x int) {
	q.st1.PushBack(x)
}

// T: O(1), S: O(1)
func (q *MyQueue) Pop() int {
	if q.st2.Len() == 0 {
		for q.st1.Len() > 0 {
			q.st2.PushBack(q.st1.Remove(q.st1.Back()))
		}
	}
	e := q.st2.Back()
	q.st2.Remove(e)
	return e.Value.(int)
}

// T: O(1), S: O(1)
func (q *MyQueue) Peek() int {
	if q.st2.Len() == 0 {
		for q.st1.Len() > 0 {
			q.st2.PushBack(q.st1.Remove(q.st1.Back()))
		}
	}
	e := q.st2.Back()
	return e.Value.(int)
}

// T: O(1), S: O(1)
func (q *MyQueue) Empty() bool {
	return q.st1.Len() == 0 && q.st2.Len() == 0
}

func main() {
	q := Constructor()
	q.Push(1)
	q.Push(2)
	fmt.Println(q.Peek())  // 1
	fmt.Println(q.Pop())   // 1
	fmt.Println(q.Empty()) // false
}

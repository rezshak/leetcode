// https://leetcode.com/problems/implement-stack-using-queues/

package main

import (
	"container/list"
	"fmt"
)

type MyStack struct {
	q1, q2 *list.List
	top    int
}

func Constructor() MyStack {
	return MyStack{
		q1:  list.New(),
		q2:  list.New(),
		top: 0,
	}
}

// T: O(1), S: O(n)
func (st *MyStack) Push(x int) {
	st.q1.PushBack(x)
	st.top = x
}

// T: O(n), S: O(n)
func (st *MyStack) Pop() int {
	for st.q1.Len() > 1 {
		st.top = st.q1.Remove(st.q1.Front()).(int)
		st.q2.PushBack(st.top)
	}
	val := st.q1.Remove(st.q1.Front()).(int)
	st.q1, st.q2 = st.q2, st.q1
	return val
}

// T: O(1), S: O(1)
func (st *MyStack) Top() int {
	return st.top
}

// T: O(1), S: O(1)
func (st *MyStack) Empty() bool {
	return st.q1.Len() == 0 && st.q2.Len() == 0
}

func main() {
	st := Constructor()
	st.Push(1)
	st.Push(2)
	fmt.Println(st.Top())   // 2
	fmt.Println(st.Pop())   // 2
	fmt.Println(st.Empty()) // false
}

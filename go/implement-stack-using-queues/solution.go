// https://leetcode.com/problems/implement-stack-using-queues/

package main

import (
	"container/list"
	"fmt"
)

type MyStack struct {
	queue *list.List
}

func Constructor() MyStack {
	return MyStack{queue: list.New()}
}

// T: O(1), S: O(n)
func (st *MyStack) Push(x int) {
	st.queue.PushBack(x)
}

// T: O(1), S: O(1)
func (st *MyStack) Pop() int {
	e := st.queue.Back()
	st.queue.Remove(e)
	return e.Value.(int)
}

// T: O(1), S: O(1)
func (st *MyStack) Top() int {
	e := st.queue.Back()
	return e.Value.(int)
}

// T: O(1), S: O(1)
func (st *MyStack) Empty() bool {
	return st.queue.Len() == 0
}

func main() {
	st := Constructor()
	st.Push(1)
	st.Push(2)
	fmt.Println(st.Top())   // 2
	fmt.Println(st.Pop())   // 2
	fmt.Println(st.Empty()) // false
}

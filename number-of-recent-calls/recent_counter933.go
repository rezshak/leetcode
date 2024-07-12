// https://leetcode.com/problems/number-of-recent-calls/

package main

import (
	"container/list"
	"fmt"
)

const WIN int = 3000

type RecentCounter struct {
	reqs *list.List
}

func Constructor() RecentCounter {
	return RecentCounter{
		reqs: list.New(),
	}
}

// T: O(n), S: O(1)
func (rc *RecentCounter) Ping(t int) int {
	rc.reqs.PushBack(t)
	for rc.reqs.Front().Value.(int) < t-WIN {
		rc.reqs.Remove(rc.reqs.Front())
	}
	return rc.reqs.Len()
}

func main() {
	rc := Constructor()
	fmt.Println(rc.Ping(1))    // 1
	fmt.Println(rc.Ping(100))  // 2
	fmt.Println(rc.Ping(3001)) // 3
	fmt.Println(rc.Ping(3002)) // 3
}

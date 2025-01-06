// https://leetcode.com/problems/time-based-key-value-store/

package main

import "fmt"

type TimeMap struct {
	store map[string][]pair
}

type pair struct {
	timestamp int
	value     string
}

func Constructor() TimeMap {
	return TimeMap{
		store: make(map[string][]pair),
	}
}

func (tm *TimeMap) Set(key string, value string, timestamp int) {
	tm.store[key] = append(tm.store[key], pair{timestamp: timestamp, value: value})
}

func (tm *TimeMap) Get(key string, timestamp int) string {
	pairs, exists := tm.store[key]
	if !exists {
		return ""
	}

	// Binary search for the value
	left, right := 0, len(pairs)-1

	// If timestamp is less than the first entry
	if right < 0 || pairs[0].timestamp > timestamp {
		return ""
	}

	// If timestamp is greater than or equal to the last entry
	if pairs[right].timestamp <= timestamp {
		return pairs[right].value
	}

	for left < right {
		mid := left + (right-left+1)/2
		if pairs[mid].timestamp <= timestamp {
			left = mid
		} else {
			right = mid - 1
		}
	}

	return pairs[left].value
}

func main() {
	tm := Constructor()
	tm.Set("foo", "bar", 1)
	fmt.Println(tm.Get("foo", 1)) // Output: bar
	fmt.Println(tm.Get("foo", 3)) // Output: bar
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Set(key,value,timestamp);
 * param_2 := obj.Get(key,timestamp);
 */

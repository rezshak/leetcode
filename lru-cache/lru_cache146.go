// https://leetcode.com/problems/lru-cache/

package main

import (
	"fmt"
)

type Node struct {
	key, value int
	prev, next *Node
}

type LRUCache struct {
	cache    map[int]*Node
	fakeHead *Node
	fakeTail *Node
	capacity int
}

// S: O(capacity)
func Constructor(capacity int) LRUCache {
	fakeHead := &Node{}
	fakeTail := &Node{}
	fakeHead.next = fakeTail
	fakeTail.prev = fakeHead
	return LRUCache{
		cache:    make(map[int]*Node),
		fakeHead: fakeHead,
		fakeTail: fakeTail,
		capacity: capacity,
	}
}

// T: O(1)
func (lru *LRUCache) Get(key int) int {
	node, exists := lru.cache[key]
	if !exists {
		return -1
	}
	lru.moveToHead(node)
	return node.value
}

// T: O(1)
func (lru *LRUCache) Put(key int, value int) {
	node, exists := lru.cache[key]
	if !exists {
		if len(lru.cache) >= lru.capacity {
			lru.removeTail()
		}
		node = &Node{key: key, value: value}
		lru.cache[key] = node
	} else {
		node.value = value
	}
	lru.moveToHead(node)
}

func (lru *LRUCache) moveToHead(node *Node) {
	// Existing node
	if node.prev != nil {
		node.prev.next = node.next
		node.next.prev = node.prev
	}
	node.next = lru.fakeHead.next
	node.prev = lru.fakeHead
	lru.fakeHead.next.prev = node
	lru.fakeHead.next = node
}

func (lru *LRUCache) removeTail() {
	lastNode := lru.fakeTail.prev
	delete(lru.cache, lastNode.key)
	lastNode.prev.next = lru.fakeTail
	lru.fakeTail.prev = lastNode.prev
}

func main() {
	cache := Constructor(2)
	cache.Put(1, 1)
	cache.Put(2, 2)
	fmt.Println(cache.Get(1)) // 1
	cache.Put(3, 3)           // evicts key 2
	fmt.Println(cache.Get(2)) // 1
	cache.Put(4, 4)           // evicts key 1
	fmt.Println(cache.Get(1)) // -1 (not found)
	fmt.Println(cache.Get(3)) // 3
	fmt.Println(cache.Get(4)) // 4
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */

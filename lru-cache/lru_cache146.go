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
func (l *LRUCache) Get(key int) int {
	node, exists := l.cache[key]
	if !exists {
		return -1
	}
	l.moveToHead(node)
	return node.value
}

// T: O(1)
func (l *LRUCache) Put(key, value int) {
	if node, exists := l.cache[key]; exists {
		node.value = value
		l.moveToHead(node)
	} else {
		if len(l.cache) >= l.capacity {
			l.removeTail()
		}
		newNode := &Node{key: key, value: value}
		l.cache[key] = newNode
		l.addToHead(newNode)
	}
}

func (l *LRUCache) moveToHead(node *Node) {
	l.removeNode(node)
	l.addToHead(node)
}

func (l *LRUCache) addToHead(node *Node) {
	node.prev = l.fakeHead
	node.next = l.fakeHead.next
	l.fakeHead.next.prev = node
	l.fakeHead.next = node
}

func (l *LRUCache) removeNode(node *Node) {
	node.prev.next = node.next
	node.next.prev = node.prev
}

func (l *LRUCache) removeTail() {
	tail := l.fakeTail.prev
	l.removeNode(tail)
	delete(l.cache, tail.key)
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

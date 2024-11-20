# https://leetcode.com/problems/lru-cache/

class Node:

    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

    def __str__(self):
        return f"{self.key}: {self.value}"


class LRUCache:

    # S: O(capacity)
    def __init__(self, capacity: int):
        self.cache = {}
        self.fake_head = Node(0, 0)
        self.fake_tail = Node(0, 0)
        self.capacity = capacity
        self.fake_head.next = self.fake_tail
        self.fake_tail.prev = self.fake_head

    # T: O(1)
    def get(self, key: int) -> int:
        node = self.cache.get(key)
        if not node:
            return -1
        self.move_to_head(node)
        return node.value

    # T: O(1)
    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key)
        if not node:
            if len(self.cache) >= self.capacity:
                self.remove_tail()
            node = Node(key, value)
            self.cache[key] = node
        else:
            node.value = value

        self.move_to_head(node)

    def move_to_head(self, node: Node) -> None:
        # Existing node
        if node.prev:
            node.prev.next = node.next
            node.next.prev = node.prev
        node.next = self.fake_head.next
        node.prev = self.fake_head
        self.fake_head.next.prev = node
        self.fake_head.next = node

    def remove_tail(self) -> None:
        last_node = self.fake_tail.prev
        self.cache.pop(last_node.key)
        last_node.prev.next = self.fake_tail
        self.fake_tail.prev = last_node.prev


def main() -> None:
    lru = LRUCache(2)
    lru.put(1, 1)
    lru.put(2, 2)
    print(lru.get(1))  # 1
    lru.put(3, 3)      # evicts key 2
    print(lru.get(2))  # -1
    lru.put(4, 4)      # evicts key 1
    print(lru.get(1))  # -1
    print(lru.get(3))  # 3
    print(lru.get(4))  # 4


if __name__ == "__main__":
    main()

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

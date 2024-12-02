# https://leetcode.com/problems/merge-k-sorted-lists/

from heapq import heappush, heappop
from typing import List, Optional


class ListNode:

    def __init__(self, val: int = 0, next: Optional['ListNode'] = None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next.__repr__() if self.next else 'None'}"


class Solution23:

    # T: O(nlogk), S: O(1)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        n = len(lists)
        for i in range(1, n):
            lists[i] = self.merge(lists[i], lists[i - 1])
        return lists[n - 1]

    def merge(self, l1, l2):
        fake = ListNode(-1)
        curr = fake
        while l1 and l2:
            if l1.val <= l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
        curr.next = l1 if l1 else l2
        return fake.next


def main() -> None:
    sol = Solution23()
    l1 = ListNode(1, ListNode(4, ListNode(5)))
    l2 = ListNode(1, ListNode(3, ListNode(4)))
    l3 = ListNode(2, ListNode(6))
    lists = [l1, l2, l3]
    merged_list = sol.mergeKLists(lists)
    print(merged_list)


if __name__ == "__main__":
    main()

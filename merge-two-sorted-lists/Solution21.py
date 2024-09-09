# https://leetcode.com/problems/merge-two-sorted-lists/

from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next}"


class Solution21:
    # T: O(n), S: O(1)
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        fake = ListNode(-1)
        tail = fake
        while list1 is not None and list2 is not None:
            if list1.val <= list2.val:
                tail.next = list1
                list1 = list1.next
            else:
                tail.next = list2
                list2 = list2.next
            tail = tail.next
        tail.next = list1 if list1 else list2
        return fake.next


def main():
    sol = Solution21()
    list1 = ListNode(1, ListNode(2, ListNode(4)))  # [1,2,4]
    list2 = ListNode(1, ListNode(3, ListNode(4)))  # [1,3,4]
    print(sol.mergeTwoLists(list1, list2))  # [1,1,2,3,4,4]

    list1 = None
    list2 = ListNode(0)
    print(sol.mergeTwoLists(list1, list2))  # [0]


if __name__ == "__main__":
    main()

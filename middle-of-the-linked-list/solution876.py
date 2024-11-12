# https://leetcode.com/problems/middle-of-the-linked-list/

from typing import Optional


class ListNode:

    def __init__(self, val: int = 0, next: Optional['ListNode'] = None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next.__repr__() if self.next else 'None'}"


class Solution876:

    # O(n), S: O(1)
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow


def main() -> None:
    sol = Solution876()
    head1 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(sol.middleNode(head1))


if __name__ == "__main__":
    main()

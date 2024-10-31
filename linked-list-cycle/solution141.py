# https://leetcode.com/problems/linked-list-cycle/

from typing import Optional


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution141:

    # T: O(n), S: O(1)
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False


def main() -> None:
    sol = Solution141()
    # 3,2,0,-4
    head1 = ListNode(3)
    head1.next = ListNode(2)
    head1.next.next = ListNode(0)
    head1.next.next.next = ListNode(-4)
    print(sol.hasCycle(head1))  # False
    head1.next.next.next.next = head1.next
    print(sol.hasCycle(head1))  # True


if __name__ == "__main__":
    main()

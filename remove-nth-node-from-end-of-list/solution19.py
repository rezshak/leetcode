# https://leetcode.com/problems/remove-nth-node-from-end-of-list/

from typing import Optional


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution19:

    # T: O(n), S: O(1)
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        right = head
        for _ in range(n):
            if right:
                right = right.next
        if not right:
            return head.next
        left = head
        while right.next:
            right = right.next
            left = left.next
        left.next = left.next.next
        return head

    # T: O(n), S: O(1)
    def removeNthFromEndTwoPass(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if not head:
            return head
        size = 0
        curr = head
        while curr:
            curr = curr.next
            size += 1
        if size == n:
            return head.next
        prev = head
        for _ in range(size - n - 1):
            prev = prev.next
        prev.next = prev.next.next
        return head


def printList(head):
    print("[ ", end="")
    while head:
        print(head.val, end=" ")
        head = head.next
    print("]")


def main() -> None:
    sol = Solution19()
    head1 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    printList(head1)
    new_head1 = sol.removeNthFromEnd(head1, 2)
    printList(new_head1)  # [1 2 3 5]

    head2 = ListNode(1)
    printList(head2)
    new_head2 = sol.removeNthFromEnd(head2, 1)
    printList(new_head2)  # []

    head3 = ListNode(3, ListNode(4))
    new_head3 = sol.removeNthFromEndTwoPass(head3, 1)
    printList(new_head3)  # [3]


if __name__ == "__main__":
    main()

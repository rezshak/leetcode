# https://leetcode.com/problems/add-two-numbers/

from typing import Optional


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution2:

    # T: O(max(m, n)), S: O(max(m, n))
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        fake = ListNode(-1)
        tail = fake
        carry = 0
        while l1 or l2:
            sum = carry
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
            carry = sum // 10
            tail.next = ListNode(sum % 10)
            tail = tail.next

        if carry > 0:
            tail.next = ListNode(carry)

        return fake.next


def print_list(node: ListNode):
    while node:
        print(node.val, end=" -> " if node.next else "\n")
        node = node.next


def main() -> None:
    sol = Solution2()
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)
    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)
    l = sol.addTwoNumbers(l1, l2)
    print_list(l)  # 7 -> 0 -> 8


if __name__ == "__main__":
    main()

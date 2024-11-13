# https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

from typing import Optional


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution2130:

    # T: O(n), S: O(1)
    def pairSum(self, head: Optional[ListNode]) -> int:
        first_half_end = self.find_first_half_end(head)
        second_half_start = self.reverse_list(first_half_end.next)
        max_twin_sum = 0
        curr1, curr2 = head, second_half_start
        while curr2:
            curr_sum = curr1.val + curr2.val
            if curr_sum > max_twin_sum:
                max_twin_sum = curr_sum
            curr1 = curr1.next
            curr2 = curr2.next
        first_half_end.next = self.reverse_list(second_half_start)
        return max_twin_sum

    # T: O(n), S: O(1)
    def find_first_half_end(self, head: ListNode) -> ListNode:
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    # T: O(n), S: O(1)
    def reverse_list(self, node: ListNode) -> ListNode:
        prev = None
        curr = node
        while curr:
            temp_next = curr.next
            curr.next = prev
            prev = curr
            curr = temp_next
        return prev


def main() -> None:
    sol = Solution2130()
    head1 = ListNode(5, ListNode(4, ListNode(2, ListNode(1))))
    head2 = ListNode(4, ListNode(2, ListNode(2, ListNode(3))))
    head3 = ListNode(1, ListNode(100000))
    print(sol.pairSum(head1))  # 6
    print(sol.pairSum(head2))  # 7
    print(sol.pairSum(head3))  # 100001


if __name__ == "__main__":
    main()

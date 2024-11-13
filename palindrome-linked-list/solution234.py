# https://leetcode.com/problems/palindrome-linked-list/

from typing import Optional


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution234:

    # T: O(n), S: O(n)
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        lst = []
        curr = head
        while curr:
            lst.append(curr.val)
            curr = curr.next
        left, right = 0, len(lst) - 1
        while left < right:
            if lst[left] != lst[right]:
                return False
            left += 1
            right -= 1
        return True

    # T: O(n), S: O(1)
    def isPalindromeInPlace(self, head: Optional[ListNode]) -> bool:
        first_half_end = self.firstHalfEnd(head)
        second_half_start = self.reverseList(first_half_end.next)
        curr1, curr2 = head, second_half_start
        result = True
        while result and curr2:
            if curr1.val != curr2.val:
                result = False
            curr1 = curr1.next
            curr2 = curr2.next
        first_half_end.next = self.reverseList(second_half_start)
        return result

    def firstHalfEnd(self, head: ListNode) -> ListNode:
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def reverseList(self, node: ListNode) -> ListNode:
        prev, curr = None, node
        while curr:
            temp_next = curr.next
            curr.next = prev
            prev = curr
            curr = temp_next
        return prev

    # T: O(n), S: O(n)
    def isPalindromeHalfStack(self, head: Optional[ListNode]) -> bool:
        st = []
        slow, fast = head, head
        while fast and fast.next:
            st.append(slow.val)
            slow = slow.next
            fast = fast.next.next
        if fast:
            slow = slow.next
        while st and slow:
            val = st.pop()
            if val != slow.val:
                return False
            slow = slow.next
        return True

    # T: O(n), S: O(n)
    def isPalindromeFullStack(self, head: Optional[ListNode]) -> bool:
        st = []
        curr = head
        while curr:
            st.append(curr.val)
            curr = curr.next
        curr = head
        while curr:
            val = st.pop()
            if curr.val != val:
                return False
            curr = curr.next
        return True


def main() -> None:
    sol = Solution234()
    # [1,2,2,1]
    head1 = ListNode(1)
    head1.next = ListNode(2)
    head1.next.next = ListNode(2)
    head1.next.next.next = ListNode(1)
    print(sol.isPalindrome(head1))  # True
    print(sol.isPalindromeInPlace(head1))  # True
    print(sol.isPalindromeHalfStack(head1))  # True
    print(sol.isPalindromeFullStack(head1))  # True
    # [1,2]
    head2 = ListNode(1)
    head2.next = ListNode(2)
    print(sol.isPalindrome(head2))  # False
    print(sol.isPalindromeInPlace(head2))  # False
    print(sol.isPalindromeHalfStack(head2))  # False
    print(sol.isPalindromeFullStack(head2))  # False
    # [1,1,2,1]
    head3 = ListNode(1)
    head3.next = ListNode(1)
    head3.next.next = ListNode(2)
    head3.next.next.next = ListNode(1)
    print(sol.isPalindrome(head3))  # False
    print(sol.isPalindromeInPlace(head3))  # False
    print(sol.isPalindromeHalfStack(head3))  # False
    print(sol.isPalindromeFullStack(head3))  # False
    # [1,0,1]
    head4 = ListNode(1)
    head4.next = ListNode(0)
    head4.next.next = ListNode(1)
    print(sol.isPalindrome(head4))  # True
    print(sol.isPalindromeInPlace(head4))  # True
    print(sol.isPalindromeHalfStack(head4))  # True
    print(sol.isPalindromeFullStack(head4))  # True


if __name__ == "__main__":
    main()

# https://leetcode.com/problems/reorder-list/

class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __repr__(self):
        result = []
        current = self
        while current:
            result.append(str(current.val))
            current = current.next
        return " -> ".join(result)


class Solution143:

    def reorderList(self, head):
        if not head or not head.next:
            return

        # Find the mid
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        first, second = head, slow.next
        # Sever the lists
        slow.next = None
        # Reverse the second list
        prev = None
        while second:
            temp_next = second.next
            second.next = prev
            prev = second
            second = temp_next
        second = prev
        # Rebuild the list
        while second:
            temp1 = first.next
            temp2 = second.next
            first.next = second
            second.next = temp1
            first = temp1
            second = temp2


def main() -> None:
    head1 = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    print(head1)  # 1 -> 2 -> 3 -> 4
    sol = Solution143()
    sol.reorderList(head1)
    print(head1)  # 1 -> 4 -> 2 -> 3


if __name__ == "__main__":
    main()

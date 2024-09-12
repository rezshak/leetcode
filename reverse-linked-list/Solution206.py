# https: // leetcode.com/problems/reverse-linked-list/

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next}"


class Solution206:

    # T: O(n), S: O(1)
    def reverseList(self, head):
        if head is None or head.next is None:
            return head
        prev, curr = None, head
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        return prev

    # T: O(n), S: O(n)
    def reverseListStack(self, head):
        if head is None or head.next is None:
            return head
        stack = []
        curr = head
        while curr:
            stack.append(curr)
            curr = curr.next
        new_head = stack.pop()
        curr = new_head
        while stack:
            curr.next = stack.pop()
            curr = curr.next
        curr.next = None
        return new_head

    # T: O(n), S: O(n)
    def reverseListRec(self, head):
        if head is None or head.next is None:
            return head
        reversed_list_head = self.reverseListRec(head.next)
        head.next.next = head
        head.next = None
        return reversed_list_head


def main() -> None:
    sol = Solution206()

    list1 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    print(list1)  # 1 -> 2 -> 3 -> 4 -> 5 -> None
    print(sol.reverseList(list1))  # 5 -> 4 -> 3 -> 2 -> 1 -> None

    list2 = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    print(list2)  # 1 -> 2 -> 3 -> 4 -> None
    print(sol.reverseListStack(list2))  # 4 -> 3 -> 2 -> 1 -> None

    list3 = ListNode(1, ListNode(2, ListNode(3)))
    print(list3)  # 1 -> 2 -> 3 -> None
    print(sol.reverseListRec(list3))  # 3 -> 2 -> 1 -> None


if __name__ == "__main__":
    main()

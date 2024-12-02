// https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

class Solution23 {

    // T: O(nlogk), S: O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length;
        for (int i = 1; i < n; i++) {
            lists[i] = merge(lists[i], lists[i - 1]);
        }
        return lists[n - 1];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode curr = fake;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return fake.next;
    }

    // T: O(nlogk), S: O(k)
    public ListNode mergeKListsMinHeap(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        var minHeap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (var list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode fake = new ListNode(0);
        ListNode curr = fake;
        while (!minHeap.isEmpty()) {
            var node = minHeap.poll();
            curr.next = node;
            curr = curr.next;
            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }
        return fake.next;
    }

    public static void main(String[] args) {
        var sol = new Solution23();
        var list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        var list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        var list3 = new ListNode(2, new ListNode(6));
        var merged1 = sol.mergeKLists(new ListNode[] { list1, list2, list3 }); // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
        System.out.println(merged1);
        list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        var merged2 = sol.mergeKListsMinHeap(new ListNode[] { list1, list2 }); // 1 -> 1 -> 3 -> 4 -> 4 -> 5
        System.out.println(merged2);
    }

}

// https://leetcode.com/problems/add-two-numbers/

class ListNode {
    val: number;
    next: ListNode | null;
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined) ? 0 : val;
        this.next = (next === undefined) ? null : next;
    }
}

// T: O(max(m, n)), S: O(max(m, n))
function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    const fake: ListNode = new ListNode(-1);
    let tail: ListNode = fake;
    let carry: number = 0;
    while (l1 || l2) {
        let sum: number = carry;
        if (l1) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2) {
            sum += l2.val;
            l2 = l2.next;
        }
        carry = Math.floor(sum / 10);
        tail.next = new ListNode(sum % 10);
        tail = tail.next
    }
    if (carry) {
        tail.next = new ListNode(carry);
    }
    return fake.next;
}

function printList(node: ListNode | null): void {
    const values: number[] = [];
    while (node) {
        values.push(node.val);
        node = node.next;
    }
    console.log(values.join(' -> '));
}

let l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
let l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
printList(addTwoNumbers(l1, l2)); // 7 -> 0 -> 8

l1 = new ListNode(0);
l2 = new ListNode(0);
printList(addTwoNumbers(l1, l2)); // 0

l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
printList(addTwoNumbers(l1, l2)); // 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1

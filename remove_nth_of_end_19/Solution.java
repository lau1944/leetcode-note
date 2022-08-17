package remove_nth_of_end_19;

public class Solution {
    /**
     * 记录前一个指向target的node和target node
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode[] target = findLast(head, n);

        if (target[0].next == head) {
            return head.next;
        }

        target[0].next = target[1].next;
        return head;
    }

    ListNode[] findLast(ListNode head, int n) {
        ListNode p = head;
        for (int i = 0; i < n; ++i) {
            p = p.next;
        }
        ListNode prev = new ListNode(-1);
        ListNode target = head;
        prev.next = target;
        while (p != null) {
            prev.next = target;
            prev = prev.next;
            target = target.next;
            p = p.next;
        }

        return new ListNode[]{prev, target};
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
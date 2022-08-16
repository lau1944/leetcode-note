package partition_list_86;

class Solution {
    /**
     * 思路 : 链表整合 创建两个链表， 一边小于等于x，一边比x大
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1), start = left;
        ListNode right = new ListNode(-1), end = right;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                left.next = p;
                left = left.next;
            } else {
                right.next = p;
                right = right.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        // merge
        left.next = end.next;
        return start.next;
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

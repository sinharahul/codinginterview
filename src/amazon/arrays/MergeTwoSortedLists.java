package amazon.arrays;

/**
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * https://leetcode.com/explore/interview/card/amazon/77/linked-list/2976/
 */
public class MergeTwoSortedLists {
    public static class ListNode {
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

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = cf();
        ListNode l2 = cs();
        ListNode ml=m.mergeTwoLists(l1,l2);
        while(ml!=null){
            System.out.println(ml.val);
            ml=ml.next;
        }
    }

    private static ListNode cs() {
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 3;
        ListNode l3 = new ListNode();
        l3.val = 4;

        l1.next=l2;
        l2.next=l3;

        return l1;
    }

    private static ListNode cf() {
        ListNode l1 = new ListNode();
        l1.val = 1;
        ListNode l2 = new ListNode();
        l2.val = 2;
        ListNode l3 = new ListNode();
        l3.val = 4;

        l1.next=l2;
        l2.next=l3;

        return l1;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (cur == null) {
                    cur = l1;
                } else {
                    cur.next = l1;
                    cur=l1;
                }
                l1 = l1.next;
            } else {
                if (cur == null) {
                    cur = l2;
                } else {
                    cur.next = l2;
                    cur=l2;
                }
                l2 = l2.next;
            }
            if (root == null) {
                root = cur;
            }

        }

        while (l1 != null) {
            cur.next = l1;
            cur=l1;
            l1 = l1.next;

        }
        while (l2 != null) {
            cur.next = l2;
            cur=l2;
            l2 = l2.next;

        }
        return root;
    }
}

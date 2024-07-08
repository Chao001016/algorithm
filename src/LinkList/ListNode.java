package LinkList;

public class ListNode {
    int val;
    ListNode next;
    public ListNode () {}
    public ListNode (int val) {
        this.val = val;
    }
    public ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode createListNode (int[] nums) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head.next;
    }
    public static void traverseListNode (ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static int getLength (ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

}

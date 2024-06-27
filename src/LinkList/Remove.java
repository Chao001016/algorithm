package LinkList;
class Remove {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{7,7,7,7});
        ListNode rs = removeElement(head, 7);
        ListNode.traverseListNode(rs);

        ListNode head2 = ListNode.createListNode(new int[]{1,2,7,7});
        ListNode rs2 = removeElement(head2, 7);
        ListNode.traverseListNode(rs2);
    }

    // 核心思想是，如果 p.next.val == val,那么 p.next = p.next.next，否则p = p.next;
    // 保证p.next能遍历整个数组
    public static ListNode removeElement (ListNode head, int val) {
        ListNode p = new ListNode(0, head);
        head = p;
        // 头节点后面的为val时
        while(p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            }
            else p = p.next;
        }
        return head.next;
    }
}
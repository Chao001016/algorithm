package LinkList;

public class reverseList {
    public static void main(String[] args) {
//        int[] list = {2,3,1};
//        ListNode head = ListNode.createListNode(list);
//        ListNode rs = reverse(head);
//        ListNode.traverseListNode(rs);

//        int[] list1 = {2,3};
//        ListNode head1 = ListNode.createListNode(list1);
//        ListNode rs1 = reverse(head1);
//        ListNode.traverseListNode(rs1);
    }
    public static ListNode reverse (ListNode head) {
        if (head == null) return head;
        ListNode i = head, j = i.next;
        // 保证头节点的next指针为空
        i.next = null;
        while (j != null) {
            ListNode k = j.next;
            j.next = i;
            i = j;
            j = k;
        }
        return i;
    }
}

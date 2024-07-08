package LinkList;

/**
 * 获取相交的链表
 */
public class IntersectionNode {
    public static void main(String[] args) {
        ListNode a = ListNode.createListNode(new int[]{ 4,1,8,4,5 });
        ListNode b = ListNode.createListNode(new int[]{ 5,0,1,8,4,5 });
        System.out.println(getIntersectionNode(a, b));
    }

    // TODO 待优化 这里没有必要通过求长度来使得两链表末端对齐
    public static ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        int lenA = ListNode.getLength(headA);
        int lenB = ListNode.getLength(headB);
        ListNode longer;
        ListNode shorter;
        int instance;
        if (lenA - lenB > 0) {
            instance = lenA - lenB;
            longer = headA;
            shorter = headB;

        } else {
            instance = lenB - lenA;
            longer = headB;
            shorter = headA;
        }
        for (int i = 0; i < instance; i++) {
            longer = longer.next;
        }
        while (longer != null) {
            if (longer == shorter) {
                return shorter;
            }
            longer = longer.next;
            shorter = shorter.next;
        }

        return null;
    }
}

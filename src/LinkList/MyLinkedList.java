package LinkList;

public class MyLinkedList {
    public ListNode head;
    int size;
    public MyLinkedList(int[] nums) {
        this.head = new ListNode();
        size = 0;
    }

    public int get (int index) {
        ListNode temp = head.next;
        int num = 0;
        while (num < index && temp != null) {
            temp = temp.next;
            num++;
        }
        if (temp != null) {
            return temp.val;
        }
        return -1;
    }

    public void addAtHead (int val) {
        addAtIndex(0, val);
    }

    public void addAtTail (int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex (int index, int val) {
        if (index > size) return;
        index = Math.max(0, index);
        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        int num = 0;
        // 寻找index - 1的节点
        while (num < index) {
            temp = temp.next;
            num++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void deleteAtIndex (int index) {
        if (index < 0 || index > size) return;
        ListNode temp = head;
        // 寻找指向待删除节点的前一个位置
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        size--;
        temp.next = temp.next.next;
    }
}

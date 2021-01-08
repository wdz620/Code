package offer.ListNode;

/**
 * @Author: Wdz
 * @Date 2020/10/8 14:24
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(findKthToTail(l1, 4).val);

    }

    //自答，快慢指针，先指针先走k步，然后慢的再出发，当快的到末尾，慢的就是想要的值。
    // 牛客未通过，LC通过！
    // 牛客的测试用例更多，比如有空的，或者错误的情况！！
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null) return null;
        ListNode f = head, s = head;
        while (k > 0) {
            //这一步判断是检查k是否超过链表的长度！！！
            if (f != null) f = f.next;
            else return null;
            k--;
        }
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

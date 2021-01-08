package leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/11/20 8:52
 * @Description: 147. 对链表进行插入排序
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 */
public class InsertionSortList {
    // 思路：将链表遍历到数组中去，排完序然后在循环赋值
    public static ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // 第一次遍历链表
        ListNode first = head;
        while (first != null) {
            list.add(first.val);
            first = first.next;
        }
        Collections.sort(list);
        // 将排序好的数组改写成链表
        ListNode res = head;
        for (int i = 0; i < list.size(); i++) {
            res.val = list.get(i);
            res = res.next;
        }
        return res;
    }

    // 上述方法可以，但是面试中缺乏专业性，可以考虑尝试下述标准插入方法 TODO 标准插入排序
    public ListNode insertionSortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        // 虚拟节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 尾节点，当前遍历节点
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            // 正常顺序插入
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                // 找到该节点应该插入的位置
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

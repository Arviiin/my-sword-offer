package cn.edu.dhu.leetcode.package1_10;

import cn.edu.dhu.datastruct.ListNode;

/**
 *   给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
 */
public class Algorithm002AddTwoNumbers {
    public static void main(String[] args) {
        ListNode list1 = ListNode.genNodeList();
        ListNode list2 = ListNode.genNodeList();
        ListNode list = addTwoNumbers(list1, list2);
        while (list.hasListNext()){
            System.out.println(list.val);
            list = list.next;
        }

    }
    /**
     *     Definition for singly-linked list.
     *     public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     *
     *   输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
         输出：7 -> 0 -> 8
         原因：342 + 465 = 807

        [1,8]
        [0]
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = null; //记录第一个节点，在后面遍历的时候使用
        ListNode node = null;  //保存当前输入的节点使用
        int plus = 0;
        while (l1!=null || l2!=null){
            int tmpVal = l1.val + l2.val + plus;
            int val = tmpVal % 10;
            plus = tmpVal / 10;
            ListNode tmpNode = new ListNode(val);
            if (first == null) {
                first = tmpNode;
                node = tmpNode;
            } else {
                node.next = tmpNode;
                node = tmpNode;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        node = first;
        return node;
    }
}

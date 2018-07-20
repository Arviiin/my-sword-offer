package cn.edu.dhu.swordoffer.package1_20;

import cn.edu.dhu.datastruct.ListNode;

import static cn.edu.dhu.datastruct.ListNode.GenNodeList;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
//思路：相当于一个k长度的尺子，先行指针先走到第k个位置，然后两个一起走，相当于中间差k个，当第一个走到尾部的时候，
//      第二个尺子正好是倒数第k个
public class Algorithm14FindKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k <= 0) {//如果链表为空，或者要找的位置为负数或者0，则返回空
            return null;
        }
        ListNode pre = head; //先行的指针
        ListNode last = head;//后行的指针
        for (int i = 1; i < k; i++) {//从头指针开始往后遍历，若链表长度小于k则返回null
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {//这里如果链表长度大于k则往后继续，若正好等于则返回第一个节点
            pre = pre.next;
            last = last.next;
        }
        return last;
    }

    public static void main(String[] args) {
        ListNode nodelist = GenNodeList();
        ListNode listNode = FindKthToTail(nodelist, 3);
        System.out.println(listNode.val);
    }
}


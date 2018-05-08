package cn.edu.dhu.swordoffer.package1_20;

import cn.edu.dhu.datastruct.ListNode;

import static cn.edu.dhu.datastruct.ListNode.GenNodeList;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
//思路：利用指针p ,q ，head，用p来在断掉链表之前保存后面的数据
public class Algorithm15ReverseList {
    public static ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }else {
            ListNode p = null;
            ListNode q = null;
            p = head.next;
            head.next= q;//将原本头结点的next域置为空
            while(p != null){
                q = p;
                p = p.next;
                q.next = head;
                head = q;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode nodelist = GenNodeList();
        ListNode listNode = ReverseList(nodelist);
        System.out.println(listNode.val);
    }
}

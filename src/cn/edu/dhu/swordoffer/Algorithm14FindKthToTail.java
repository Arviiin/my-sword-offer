package cn.edu.dhu.swordoffer;

import cn.edu.dhu.datastruct.ListNode;

import java.util.ArrayList;

import static cn.edu.dhu.datastruct.ListNode.GenNodeList;

/**
 * 输入一个链表，输出该链表中倒数第k 个结点。
 */
public class Algorithm14FindKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {

        if(head == null){
            return null;
        }
        int count = 0;
        while(head.next != null){
            count ++ ;
        }

        for(int i =1 ;  i<= count - k +1 ; i++){
            if( i == count - k +1){
                System.out.println(head.val);
            }
            head = head.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode nodelist = GenNodeList();
        ListNode listNode = FindKthToTail(nodelist, 1);
        System.out.println(listNode);
    }
}

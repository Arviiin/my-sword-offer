package cn.edu.dhu.swordoffer.package1_20;

import cn.edu.dhu.datastruct.ListNode;

import static cn.edu.dhu.datastruct.ListNode.GenNodeList;

/**
 *输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
//思路：首先判断若list1为空，则直接返回list2，反之一样，定义一个合并后的头指针，和当前已经合并了的最后一个节点指针，
    //第一次比较如果list1.val <= list2.val，则list1所表示的节点为结果的头结点，反之亦然。
public class Algorithm16Merge {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;     
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                   mergeHead = current = list1;
                }else{
                   current.next = list1;
                   current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                   mergeHead = current = list2;
                }else{
                   current.next = list2;
                   current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;

    }

    public static void main(String[] args) {
        ListNode list1 = GenNodeList();
        ListNode list2 = GenNodeList();
        ListNode listNode = Merge(list1,list2);
        while (listNode !=null ){
            System.out.println(listNode.val);
        }
    }
}
//思路二：把list1当作最后结果，即把list2合并到list1上，还有些细节问题没搞清。
/*if (list1 ==null){
            return list2;
        }else if (list2 ==null){
            return list1;
        }
        ListNode p = list1, q = list2;
        ListNode pPre =list1,qPre =list2;
        while (p != null && q != null){
            if (p.val <= q.val){
                pPre = p;
                p = p.next;
            }else if (p.val > q.val ){
                qPre = q;
                q = q.next;
                qPre.next = p;
                pPre.next = qPre;
            }
        }

        if (p == null){
             pPre.next=q;
        }else if (q == null){
            qPre.next = p;
        }

        return list1;*/

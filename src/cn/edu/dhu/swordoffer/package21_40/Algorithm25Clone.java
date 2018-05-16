package cn.edu.dhu.swordoffer.package21_40;

import cn.edu.dhu.datastruct.RandomListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 5.12
 */
public class Algorithm25Clone {
    /**
     *
     * @param pHead
     * @return RandomListNode
     * 思路先从前往后复制next，再从前往后复制random域。然后再拆分链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode pCur = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pCur != null) {
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;//重新pCur指向表头
        //复制random              注意：pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pCur != null) {
            if (pCur.random != null)
                pCur.next.random = pCur.random.next;//因为pCur.random.next其实就是原链表的复制，如果不加next指向的是原来链表中的节点，而不是复制的，随便画个图看一下即可。
            pCur = pCur.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        //拆分链表
        while (pCur != null) {
            pCur.next = pCur.next.next;
            if (cur.next != null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }
}
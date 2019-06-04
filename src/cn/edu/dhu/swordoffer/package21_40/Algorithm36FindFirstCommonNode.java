package cn.edu.dhu.swordoffer.package21_40;

import cn.edu.dhu.datastruct.ListNode;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * <p>
 * 如果存在共同节点的话，那么从该节点开始，两个链表之后的元素都是相同的。
 * 也就是说两个链表从尾部往前到某个点，节点都是一样的。注意：不仅是值相同，next域也相同，即是val 和 next 都一样， 此时就不用分开比较，直接比较两个节点。
 * 我们可以用两个栈分别来装这两条链表。一个一个比较出来的值。
 * 找到第一个相同的节点。
 */
public class Algorithm36FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //方法一：
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonListNode = null;

        //stack1.peek().val准确来说是不需要.val的，但是我们创建链表的时候，是分开创建的，所以所谓公共节点只有值相同，next域的地址是不一样的。
        //所以用.val来比较
        //两个栈如果指向的是同一个地址才算是相同节点 所以直接用＝＝
        //后面做了改进，拼接了链表使其是具有公共链表的。所以删掉了.val
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            stack2.pop();
            commonListNode = stack1.pop();
        }
        return commonListNode;


        //方法二：
        //如果两个链表没有相同的结点，会报错

        //两个链表如果确定一定有交点的话，方法是指向短链表指针先走完，
        // 然后指向长链表，指向长链表指针后走完，指向短链表。所以，第二次走过，一定会在交点相遇
        //相同长度不说，若长度不同，则不管先走短的再走长的和先走长的再走短的，最终走的是一样长的
        // 如一链表为1 3 5 8 9 另一2 4 8 9
        // 合起来1 3 5 8 9 2 4 8 9
        // 合起来2 4 8 9 1 3 5 8 9 注意到了吗8 9
        /*ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while( p1 != p2){
            p1 = (p1==null ? pHead2 : p1.next);
            p2 = (p2==null ? pHead1 : p2.next);
        }
        return p1;*/


        /*//方法三：用hashmap
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;


        HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2))
                return current2;
            current2 = current2.next;
        }

        return null;*/
    }

    public static void main(String[] args) {
        //这里要创建有公共节点的两个链表
        ListNode createCommonListNode = ListNode.genNodeList();//公共节点部分
        ListNode listNode1 = ListNode.genNodeList();
        //将公共节点接在listNode1后面
        ListNode p = listNode1;
        while (p.next != null) {
            p = p.next;
        }
        p.next = createCommonListNode;

        ListNode listNode2 = ListNode.genNodeList();
        //将公共节点接在listNode2后面
        ListNode q = listNode2;
        while (q.next != null) {
            q = q.next;
        }
        q.next = createCommonListNode;

        Algorithm36FindFirstCommonNode a = new Algorithm36FindFirstCommonNode();
        ListNode findFirstCommonNode = a.FindFirstCommonNode(listNode1, listNode2);
        System.out.println(findFirstCommonNode.val);
    }
}
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
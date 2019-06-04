package cn.edu.dhu.swordoffer.package1_20;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * <p>
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */

//数据结构定义如下
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */

import cn.edu.dhu.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Stack;

import static cn.edu.dhu.datastruct.ListNode.genNodeList;


public class Algorithm03 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode nodelist = genNodeList();
        ArrayList<Integer> arrayList = printListFromTailToHead(nodelist);
        System.out.println(arrayList);
        /*System.out.println(node.val + "");
        while(node.hasListNext()) {
            node = node.next;
            System.out.println(node.val + " ");
        }*/
    }
}
package cn.edu.dhu.swordoffer;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
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
import java.util.Scanner;
import java.util.Stack;


public class Algorithm03 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static void main(String[] args) {

        ListNode first = null; //记录第一个节点，在后面遍历的时候使用
        ListNode node = null; //保存当前输入的节点使用
        Scanner sc = new Scanner(System.in);
        //int int2 = sc.nextInt();
        while (!sc.hasNext("0")) {//hasnext()方法会死循环因此需要设置一个结束标志，我也不太清楚。！sc.hasNext("0").也就是说以0结束
            //int2--;
            int v = sc.nextInt();
            ListNode n = new ListNode(v);
            if (first == null) {
                first = n;
                node = n;
            } else {
                node.add(n);
                node = n;
            }
        }

        if(first == null) {
            System.out.println("没有数字输入");
        } else {
            node = first;
            ArrayList<Integer> arrayList = printListFromTailToHead(node);
            System.out.println(arrayList);
            /*System.out.println(node.val + "");
            while(node.hasListNext()) {
                node = node.next;
                System.out.println(node.val + " ");
            }*/
        }
    }
}
package cn.edu.dhu.datastruct;

import java.util.ArrayList;
import java.util.Scanner;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    public void add(ListNode node) {
        this.next = node;
    }

    public boolean hasListNext() {
        return this.next == null ? false : true;
    }

    public static ListNode GenNodeList(){

        ListNode first = null; //记录第一个节点，在后面遍历的时候使用
        ListNode node = null; //保存当前输入的节点使用
        Scanner sc = new Scanner(System.in);

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

            /*System.out.println(node.val + "");
            while(node.hasListNext()) {
                node = node.next;
                System.out.println(node.val + " ");
            }*/
        }
        return node;
    }

}

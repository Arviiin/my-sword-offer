package cn.edu.dhu.leetcode.package1_10;

import cn.edu.dhu.datastruct.ListNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
        while (list!=null){
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

         [5]
         [5]

     [9,8]
     [1]

     [1]
     [9,9]

     [9,9]
     [9]
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //思想：空的地方赋值为0
        ListNode first = null;
        ListNode cur = null;
        int carry = 0;
        while (l1 !=null || l2 !=null){
            int x = (l1 == null)? 0 : l1.val;
            int y = (l2 == null)? 0 : l2.val;
            int res = x + y +carry;
            carry = res /10;
            ListNode tmpNode = new ListNode(res % 10);
            if (first == null){
                first = tmpNode;
                cur = tmpNode;
            }else{
                cur.next = tmpNode;
                cur = tmpNode;
            }
            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2 .next;
        }
        if (carry > 0){
            ListNode listNode = new ListNode(carry);
            cur.next = listNode;
        }
        return first;

        /*超时了
        ListNode first = null; //记录第一个节点，在后面遍历的时候使用
        ListNode node = null;  //保存当前输入的节点使用
        int plus = 0;
        while (l1!=null && l2!=null){
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
        if (l1 ==null && l2 ==null){
            if (plus>0){
                ListNode tmpNode = new ListNode(plus);
                node.next = tmpNode;
            }
            return first;
        }else if(l1 == null){
            if (l2.val+plus<10){
                l2.val = l2.val+plus;
                node.next=l2;
            }else {
                while (l2!=null && l2.val+plus>=10){
                    int tmp =l2.val+plus;
                    int val = tmp % 10;
                    plus = tmp / 10;
                    ListNode tmpNode = new ListNode(val);
                    node.next = tmpNode;
                    node = tmpNode;
                    l2 = l2.next;
                }
                if (l2 == null){
                    if (plus>0){
                        ListNode tmpNode = new ListNode(plus);
                        node.next = tmpNode;
                    }
                    return first;
                }
                if (l2.val+plus<10){
                    l2.val = l2.val+plus;
                    node.next=l2;
                    return first;
                }

            }
        }else if (l2 == null){
            if (l1.val+plus<10){
                l1.val = l1.val+plus;
                node.next=l1;
            }else {
                while (l1!=null && l1.val+plus>=10){
                    int tmp =l1.val+plus;
                    int val = tmp % 10;
                    plus = tmp / 10;
                    ListNode tmpNode = new ListNode(val);
                    node.next = tmpNode;
                    node = tmpNode;
                    l1 = l1.next;
                }
                if (l1 == null){
                    if (plus>0){
                        ListNode tmpNode = new ListNode(plus);
                        node.next = tmpNode;
                    }
                    return first;
                }
                if (l1.val+plus<10){
                    l1.val = l1.val+plus;
                    node.next=l1;
                    return first;
                }

            }
        }
        return first;*/
    }
}

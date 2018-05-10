package cn.edu.dhu.swordoffer.package21_40;
import cn.edu.dhu.datastruct.TreeNode;

import java.util.*;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
//实际上就是二叉树的层次遍历，那么一般使用队列实现，先入根节点，然后根节点出队，判断出队节点的左右孩子
//若其左孩子不为空，则入其左孩子，再判断仿照判断其右孩子执行相应操作，再判断队列此时的情况，若不为空重复上述操作
//本体中，还另外创建一个List来存储每次出栈的元素，最后返回
public class Algorithm22TreePrintFromTopToBottom {

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        //最佳实践：面向接口编程，而不是面向实现编程
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//因为LinkedList实现了Queue接口。此处实际上是父类引用指向子类对象
        queue.offer(root);//入队  Queue中的方法
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();//出队   Queue中的方法
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] datas = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List binaryTree = TreeNode.creatBinaryTree(datas);
        TreeNode root = (TreeNode) binaryTree.get(0);
        System.out.println(PrintFromTopToBottom(root));
    }
}
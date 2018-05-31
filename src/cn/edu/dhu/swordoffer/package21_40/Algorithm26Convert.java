package cn.edu.dhu.swordoffer.package21_40;

import cn.edu.dhu.datastruct.TreeNode;

import java.util.List;

import static cn.edu.dhu.datastruct.TreeNode.creatBinaryTree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 5.13
 */
//思路 利用二叉树的中序遍历，遍历的结果很明显是排好序的，在遍历的过程中对遍历的每个非空节点进行相应指针的变换，使其构造成
//    一个双向链表（没说循环，所以不要考虑最后一个节点的后继。）
public class Algorithm26Convert {
    static TreeNode head = null;
    static TreeNode realHead = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private static void ConvertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }

    public static void main(String[] args) {
        int[] datas = new int[]{5, 3, 7, 1, 4, 6, 8};  //输出true
        List binaryTree = creatBinaryTree(datas);
        TreeNode pRootOfTree = (TreeNode) binaryTree.get(0);
        TreeNode realHead = Convert(pRootOfTree);
        while (realHead != null){
            System.out.print(realHead.val + "\t");
            realHead = realHead.right;

        }
    }
}
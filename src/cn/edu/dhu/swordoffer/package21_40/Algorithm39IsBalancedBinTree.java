package cn.edu.dhu.swordoffer.package21_40;

import cn.edu.dhu.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * <p>
 * 这里有一点需要注意,平和二叉树的基础是它是一颗二叉排序树,因为避免单支情况退化为链表.故提出平衡二叉树,
 * 即:每个结点的左右子树的高度之差的绝对值（平衡因子）最多为1。
 * <p>
 * 以下代码不考虑判定是否为二叉排序树,默认符合,主要判定:是否每个结点的左右子树的高度之差的绝对值（平衡因子）最多为1
 */
public class Algorithm39IsBalancedBinTree {

    //    从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
    //-1即是:不满足
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        Integer[] datas = new Integer[]{1, 2, 3, 4, 5, null, null, null, null, 6};//当设计到有null的时候可以使用包装类
        List nodeList = TreeNode.creatBinaryTree(datas);
        TreeNode root = (TreeNode) nodeList.get(0);
        Algorithm39IsBalancedBinTree obj = new Algorithm39IsBalancedBinTree();
        boolean result = obj.IsBalanced_Solution(root);
        System.out.println(result);
    }
}
/**
 * public class TreeNode {
 * int val = 0;
 * TreeNode left = null;
 * TreeNode right = null;
 * public TreeNode(int val) {
 * this.val = val;
 * }
 * }
 */
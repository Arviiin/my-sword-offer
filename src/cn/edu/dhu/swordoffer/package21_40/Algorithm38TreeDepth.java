package cn.edu.dhu.swordoffer.package21_40;

import cn.edu.dhu.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Algorithm38TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0, count = 0, nextCount = 1;
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            count++;
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            if (count == nextCount) {//这里用来比对，来判断进行到哪一层。最初nextCount赋值为1，是因为根节点只有一个，
                                     // 然后每出队则记一次count（在每层开始处清0），nextCount实际上就是每层的节点数，这样一比对就可以判断一层遍历完。层数加1
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
    /*递归写法
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }*/

    public static void main(String[] args) {
        int[] datas = new int[]{1, 2, 3, 4, 5, -1, 6, -1, -1, 7};
        List nodeList = TreeNode.creatBinaryTree(datas);
        TreeNode root = (TreeNode) nodeList.get(0);
        Algorithm38TreeDepth obj = new Algorithm38TreeDepth();
        int result = obj.TreeDepth(root);
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
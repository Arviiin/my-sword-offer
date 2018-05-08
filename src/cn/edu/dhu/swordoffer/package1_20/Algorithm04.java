package cn.edu.dhu.swordoffer.package1_20;

import cn.edu.dhu.datastruct.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

//solution类，实现重建二叉树
public class Algorithm04 {
    /**
     * @param pre 前序序列
     * @param in  中序序列
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //判断输入的前序序列和中序序列是否为空
        if (pre == null || in == null) {
            return null;
        }
        TreeNode mm = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return mm;
    }

    //核心递归
    public static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode tree = new TreeNode(pre[preStart]);//以先序的第一个元素作为根
        tree.left = null;
        tree.right = null;
        //若只有一个元素，则返回此树
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        //在中序中找从前序得知的根节点所在位置
        int root = 0;
        for (root = inStart; root < inEnd; root++) {
            if (pre[preStart] == in[root]) {
                break;
            }
        }
        int leftLength = root - inStart;//得到左子树的长度
        int rightLength = inEnd - root;//得到右子树的长度
        if (leftLength > 0) {//若左子树长度不为空则将左子树当做一颗二叉树递归遍历
            tree.left = reConstructBinaryTreeCore(pre, in, preStart + 1, preStart + leftLength, inStart, root - 1);
        }
        if (rightLength > 0) {//若左子树长度不为空则将左子树当做一颗二叉树递归遍历
            tree.right = reConstructBinaryTreeCore(pre, in, preStart + 1 + leftLength, preEnd, root + 1, inEnd);
        }
        return tree;
    }

    //将二叉树先序遍历，用于测试结果
    public static void preTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + ",");
        if (node.left != null) {
            preTraverseBinTree(node.left);
        }
        if (node.right != null) {
            preTraverseBinTree(node.right);
        }
    }

    //将二叉树中序遍历，用于测试结果
    public static void inTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inTraverseBinTree(node.left);
        }
        System.out.print(node.val + ",");
        if (node.right != null) {
            inTraverseBinTree(node.right);
        }
    }

    //将二叉树后序遍历，用于测试结果
    public static void postTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postTraverseBinTree(node.left);
        }
        if (node.right != null) {
            postTraverseBinTree(node.right);
        }
        System.out.print(node.val + ",");
    }

    //主函数，用于测试结果
    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 8, 5, 8, 6};
        TreeNode tree = reConstructBinaryTree(pre, in);
        System.out.print("先序遍历结果:  {");
        preTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("中序遍历结果:  {");
        inTraverseBinTree(tree);
        System.out.println("}");
        System.out.print("后序遍历结果:  {");
        postTraverseBinTree(tree);
        System.out.println("}");
    }
}
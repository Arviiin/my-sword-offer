package cn.edu.dhu.swordoffer;

import cn.edu.dhu.datastruct.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。(实际上就是递归交换其左右子树)
 */
public class Algorithm18Mirror {

    public void Mirror(TreeNode root) {
        if(root == null){
            return ;
        }
        TreeNode tmp = null;
        if (root != null){
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null)
                Mirror(root.left);
            if (root.right != null)
                Mirror(root.right);
        }
    }

}
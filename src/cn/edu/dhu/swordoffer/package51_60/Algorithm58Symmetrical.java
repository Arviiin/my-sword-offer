package cn.edu.dhu.swordoffer.package51_60;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/

import cn.edu.dhu.datastruct.ListNode;
import cn.edu.dhu.datastruct.TreeNode;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

/*思路：首先根节点以及其左右子树，左子树的左子树和右子树的右子树相同
 * 左子树的右子树和右子树的左子树相同即可，采用递归
 * 非递归也可，采用栈或队列存取各级子树根节点
 */
public class Algorithm58Symmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }

    private boolean comRoot(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}
package cn.edu.dhu.OtherAlgorithmImplement;

import cn.edu.dhu.basedatastruct.TreeNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * 实现关于二叉树的各种操作方法
 */
public class BinaryTree {


    static int counter = 0;//定义一个静态计数变量
    /**
     * 构造二叉树
     */
    public static TreeNode createBiTree(TreeNode root, int[] a, int i) {
        if (i < a.length) {
            if (a[i] == 0) {
                root = null;
            } else {
                TreeNode lchild = new TreeNode();
                TreeNode rchild = new TreeNode();
                root.val = a[i];
                root.left = createBiTree(lchild, a, ++counter);
                root.right = createBiTree(rchild, a, ++counter);
            }
        }
        return root;
    }


    //非递归中序遍历
    public static void inOrderTraverse(TreeNode root)
    {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;//让p指向根节点
        while(!stack .empty() || p != null  )
        {
            //一直遍历到左子树最下边，边遍历边保存根节点到栈中(每个节点都可以看成一个新的子树的根节点)
            while(p != null)
            {
                stack.push(p);//若节点的左孩子不为空，将左孩子压栈，因为需要借助遍历过的节点进入右子树
                p = p.left;
            }
            //当p为空时，说明已经到达左子树最下边，这时需要出栈了
            if(stack != null)
            {
                p = stack.pop();
                System.out.print(p.val + "-->");//访问根节点
                p = p.right;//进入右子树，此时p是右子树的根节点（开始新一轮的遍历）
            }
        }

    }
}

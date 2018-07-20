package cn.edu.dhu.swordoffer.package61_66;
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

import cn.edu.dhu.datastruct.TreeNode;

import java.util.List;

/**
 * 给定一棵二叉搜索树,请找出其中的第k小的结点。
 * 例如, （5,3,7,2,4,6,8）    中,按结点数值大小顺序第三小结点的值为4。
 */
//思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。
//     所以，按照中序遍历顺序找到第k个结点就是结果。

//如果没有if(node != null)这句话  那么那个root就是返回给上一级的父结点的，而不是递归结束的条件了,
// 有了这句话过后，一旦返回了root，那么node就不会为空了，就一直一层层的递归出去到结束了。
// 举第一个例子{8,6,5,7,},1 答案应该是5，如果不加的时候，开始，root=8，node=kth（6,1），
// 继续root=6，node=kth（5,1）root =5 返回null，这时向下执行index=k=1了，返回 5给root=6递归的时候的node，
// 这时回到root=8了，往后面调右孩子的时候为空而把5给覆盖了。
// 现在就为空了，有了这句话后虽然为空，但不把null返回，而是继续返回5，个人理解
public class Algorithm62KthNode {
    int index = 0; //计数器
    TreeNode KthNode(TreeNode pRoot, int k) {
        if( pRoot != null){ //中序遍历寻找第k个
            TreeNode node = KthNode( pRoot.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return  pRoot;
            node = KthNode( pRoot.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
    public static void main(String[] args) {
        Algorithm62KthNode obj = new Algorithm62KthNode();
        Integer[] data = {5,3,7,2,4,6,8};
        List list = TreeNode.creatBinaryTree(data);
        TreeNode treeNode = (TreeNode) list.get(0);
        TreeNode result = obj.KthNode(treeNode,3);
        System.out.println(result.val);
    }
}
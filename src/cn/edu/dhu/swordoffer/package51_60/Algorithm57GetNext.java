package cn.edu.dhu.swordoffer.package51_60;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * <p>
 * 1、有右子树的，那么下个结点就是右子树最左边的点；
 * 2、没有右子树的，也可以分成两类，
 * a)是父节点左孩子 ，那么父节点就是下一个节点 ；
 * b)是父节点的右孩子,找他的父节点的父节点...直到
 * 当前结点(当前节点每次判断若自己不是父节点的左孩子位置就将父节点赋给当前节点,也即父节点成为了新的当前节点)
 * 处于其父节点的左孩子位置。
 * 如果没有eg：M，那么他就是尾节点。
 * <p>
 * <p>
 * //分析二叉树的下一个节点，一共有以下情况：
 * //1.二叉树为空，则返回空；
 * //2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
 * //3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
 */
public class Algorithm57GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {    //如果有右子树，则找右子树的最左节点
            pNode = pNode.right;
            while (pNode.left != null) pNode = pNode.left;
            return pNode;
        }
        while (pNode.next != null) { //没右子树，则找第一个当前节点是父节点左孩子的节点
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
}
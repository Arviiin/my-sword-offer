package cn.edu.dhu.datastruct;

/**
 * 建立一个二叉树类（采用二叉链表）
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
        //如果一个类，你没有定义构造函数，那么系统默认会有一个无参的构造函数
        //但如果你定义了一个有参的构造函数，为了保证正确性，系统不会创建无参构造函数，这时候，如果你还想允许无参构造，就必须显式的声明一个
    }
}

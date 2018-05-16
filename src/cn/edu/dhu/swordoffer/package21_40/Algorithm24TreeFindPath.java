package cn.edu.dhu.swordoffer.package21_40;
/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 5.11
 */
import cn.edu.dhu.datastruct.TreeNode;
import java.util.ArrayList;
import java.util.List;

import static cn.edu.dhu.datastruct.TreeNode.creatBinaryTree;

public class Algorithm24TreeFindPath {

    private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();//用来存储所有的情况
    private static ArrayList<Integer> list = new ArrayList<Integer>();//用来存储满足调节的一个路径

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)//当满足从根节点到此叶子结点的路径节点的和等于target。加入
            listAll.add(new ArrayList<Integer>(list));//因为add添加的是引用，如果不new一个的话，后面的操作会更改这个list
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);//移除最后一个元素，深度遍历完一条路径后要回退
        return listAll;
    }

    public static void main(String[] args) {
        int[] datas = new int[]{1, 2, 3, 4, 5, 4, 7};  //输出true
        List binaryTree = creatBinaryTree(datas);
        TreeNode root = (TreeNode) binaryTree.get(0);
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(root, 8);
        System.out.println(arrayLists.toString());
    }
}
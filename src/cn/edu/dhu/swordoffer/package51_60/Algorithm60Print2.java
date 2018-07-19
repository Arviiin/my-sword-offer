package cn.edu.dhu.swordoffer.package51_60;
import cn.edu.dhu.datastruct.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 思路:使用层次遍历,用队列.根出队,判断左右孩子是否为空,不空则入其左右孩子
 */
public class Algorithm60Print2 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null){
            return arrayLists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> queueList = new ArrayList<>();
        queue.add(pRoot);
        int start =0, end = 1;//第一层节点数为1,即只有一个根节点
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.remove();
            queueList.add(treeNode.val);
            start++;
            if (treeNode.left!=null){
                queue.add(treeNode.left);
            }
            if (treeNode.right != null){
                queue.add(treeNode.right);
            }
            if (start == end){
                end = queue.size();//将下一层的节点赋给end
                start =0;
                arrayLists.add(queueList);
//                queueList.clear(); 不能用clear,因为这里添加到arrayLists里的只是一个引用.clear就有空
                queueList = new ArrayList<Integer>();//所以要重新创建.
            }
        }
        return arrayLists;
    }

    public static void main(String[] args) {
        Algorithm60Print2 obj = new Algorithm60Print2();
        Integer[] data = {8, 6, 10, 5, 7, 9, 11};
        List list = TreeNode.creatBinaryTree(data);
        ArrayList<ArrayList<Integer>> result = obj.Print((TreeNode) list.get(0));
        System.out.println(result);
    }
}
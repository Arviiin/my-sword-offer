package cn.edu.dhu.swordoffer.package21_40;
import cn.edu.dhu.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Algorithm22TreePrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return null;
        }else {
            arrayList.add(root.val);
        }
        if (root.left != null){
            PrintFromTopToBottom(root.left);
        }
        if (root.right != null) {
            PrintFromTopToBottom(root.right);
        }

        return arrayList;
    }
}
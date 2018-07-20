package cn.edu.dhu.swordoffer.package61_66;

import cn.edu.dhu.datastruct.TreeNode;

import java.util.List;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 算法思想：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
 * 依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
 * 另外，结点之间的数值用逗号隔开。
 */
public class Algorithm61SerializeAndDeserialize {

    public int index = -1;

    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) {
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        Algorithm61SerializeAndDeserialize obj = new Algorithm61SerializeAndDeserialize();
        Integer[] data = {8, 6, 10, 5, 7, 9, 11};
        List list = TreeNode.creatBinaryTree(data);
        String result = obj.Serialize((TreeNode) list.get(0));
        System.out.println(result);
        TreeNode treeNode = obj.Deserialize(result);
        System.out.println(treeNode.val);
    }
}
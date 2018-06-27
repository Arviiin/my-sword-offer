package cn.edu.dhu.other.test;

import cn.edu.dhu.datastruct.TreeNode;
import org.junit.Test;

import static cn.edu.dhu.other.BinaryTree.*;

public class TestBinaryTree {

    static int counter = 0;//定义一个静态计数变量
    @Test
    public void TestInOrderTraverse(){
        TreeNode root = new TreeNode();
        int[] a = { 1, 2, 3, 0, 0, 4, 0, 0, 5, 0, 0 };
        root = createBiTree(root, a, counter);
        inOrderTraverse(root);
    }
}

package cn.edu.dhu.OtherAlgorithmImplement.test;

import cn.edu.dhu.basedatastruct.TreeNode;
import org.junit.Test;

import static cn.edu.dhu.OtherAlgorithmImplement.BinaryTree.*;

public class BinaryTreeTest {

    static int counter = 0;//定义一个静态计数变量
    @Test
    public void TestInOrderTraverse(){
        TreeNode root = new TreeNode();
        int[] a = { 1, 2, 3, 0, 0, 4, 0, 0, 5, 0, 0 };
        root = createBiTree(root, a, counter);
        inOrderTraverse(root);
    }
}

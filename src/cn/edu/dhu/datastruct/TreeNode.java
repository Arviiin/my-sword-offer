package cn.edu.dhu.datastruct;
/**
 public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
         this.val = val;
    }
 }
 */

import java.util.LinkedList;
import java.util.List;

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


    /**
     * 创建一颗二叉树
     * @param datas 实现二叉树各节点值的数组
     */
    public static List creatBinaryTree(int[] datas){
        List<TreeNode> treeNodeList = new LinkedList<>();//因为LinkedList实现了List接口。此处实际上是父类引用指向子类对象，面向接口编程而不是面向实现编程
        //将数组变成TreeNode节点
        for(int i=0;i<datas.length;i++){
            TreeNode treeNode = new TreeNode(datas[i]);
            treeNodeList.add(treeNode);
        }
        //给所有父节点设定子节点    //若数节点总数为n,最后一个非叶子节点是 n/2   又因为这里从0开始，所以-1
        for(int index=0;index<treeNodeList.size()/2-1;index++){
            //编号为n的节点他的左子节点编号为2*n 右子节点编号为2*n+1 但是因为list从0开始编号，所以还要+1
            //这里父节点有1（2,3）,2（4,5）,3（6,7）,4（8,9） 但是最后一个父节点有可能没有右子节点 需要单独处理
            treeNodeList.get(index).left = treeNodeList.get(index*2+1);
            treeNodeList.get(index).right = treeNodeList.get(index*2+2);
        }
        //单独处理最后一个父节点  因为它有可能没有右子节点
        int index = treeNodeList.size()/2-1;
        treeNodeList.get(index).left = treeNodeList.get(index*2+1); //先设置左子节点
        if(treeNodeList.size() % 2 == 1){ //如果有奇数个节点，最后一个父节点才有右子节点
            treeNodeList.get(index).right = treeNodeList.get(index*2+2);
        }
        return treeNodeList;
    }

}

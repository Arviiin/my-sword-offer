package cn.edu.dhu.swordoffer.package21_40;

import cn.edu.dhu.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
//BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
// 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义
public class Algorithm23TreeVerifySquenceOfBST {

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        boolean flag = isBST(sequence, 0, sequence.length - 1);
        return flag;
    }

    /**
     * 递归实现检测
     * <p>
     * 对于后序遍历来说，序列数组的最后一个元素一定是根节点,
     * 则根据这个元素，将前面的数组分为左、右两个部分，左侧部分都小，右侧部分都大，
     * 如果右侧部分有比该根节点小的元素，那么就不是后序遍历,如此递归进行
     * 和快速排序有点像
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static boolean isBST(int[] arr, int start, int end) {
        //遍历完数组的一部分，没报错，返回true
        if (start >= end) { //这个=号很重要，有了以后可以减少递归运算次数
            // 比如当分割的序列最后只有第一个元素时，其实开始是0结束也是0从这里便可以结束调用
            return true;
        }
        // 当前数组(从start到end部分)的根节点
        int curElement = arr[end];
        int splitIndex;
        // 找到比curElement大和比curElement小的分界点,分成左侧、右侧两组数据
        for (splitIndex = start; splitIndex < end; splitIndex++) {
            if (arr[splitIndex] > curElement)
                break;
        }
        // 只需要看右侧即可，因为前面的for循环，已经确保左侧部分全部都小于curElement
        for (int i = splitIndex; i < end; i++) {
            if (arr[i] < curElement) {
                return false;//只要右边有比左边大的直接返回不是
            }
        }
        //下面再递归其左子树和右子数
        return isBST(arr, start, splitIndex - 1) && isBST(arr, splitIndex, end - 1);
    }


    public static void main(String[] args) {
        int[] datas = new int[]{4, 8, 6, 12, 16, 14, 10};  //输出true
        System.out.println(VerifySquenceOfBST(datas));
    }
}
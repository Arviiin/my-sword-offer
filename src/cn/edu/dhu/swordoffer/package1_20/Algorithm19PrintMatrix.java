package cn.edu.dhu.swordoffer.package1_20;

import cn.edu.dhu.datastruct.ListNode;
import cn.edu.dhu.datastruct.TreeNode;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *         则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
// 画图让抽象形象化
//主体循环部分才5行。其实是有规律可循的。将每一层的四个边角搞清楚就可以打印出来了
//层数是以最短边的对角线为基准的，比如（0，0）,(1,1)...，只取一半。之所以-1和+1当对角线元素个数为基数时候，会出现个0.5层，需要进为1
//4*4是两层，在纸上画画，只需要两个圈就能遍历所有的点了

import java.util.ArrayList;

public class Algorithm19PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<> ();
        if(matrix.length==0) return result;
        int rowLen = matrix.length,colLen = matrix[0].length;
        int layers = (Math.min(rowLen,colLen)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            for(int k = i;k<colLen-i;k++) result.add(matrix[i][k]);//左至右
            for(int j=i+1;j<rowLen-i;j++) result.add(matrix[j][colLen-i-1]);//右上至右下
            for(int k=colLen-i-2;(k>=i)&&(rowLen-i-1!=i);k--) result.add(matrix[rowLen-i-1][k]);//右至左//这个条件我是没想到还要&&(rowLen-i-1!=i)，这个是考虑了行数小于列数的情况，比如三行六列，当到第二圈的时候，没有限制条件的话就会重复了，
            for(int j=rowLen-i-2;(j>i)&&(colLen-i-1!=i);j--) result.add(matrix[j][i]);//左下至左上
        }
        return result;
    }

    public static void main(String[] args) {
        int[] matrix[] = new int[][]{{1, 2, 3 ,4 },{5 ,6 ,7, 8 },{9, 10 ,11, 12 },{13 ,14, 15 ,16}};
        ArrayList<Integer> printMatrix = printMatrix(matrix);
        System.out.println(printMatrix);
    }
}

/*  很好的思路。java中不太可行，python中比较好
        可以模拟魔方逆时针旋转的方法，一直做取出第一行的操作
        例如
        1 2 3
        4 5 6
        7 8 9
        输出并删除第一行后，再进行一次逆时针旋转，就变成：
        6 9
        5 8
        4 7
        继续重复上述操作即可。*/

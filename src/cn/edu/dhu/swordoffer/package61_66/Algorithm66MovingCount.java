package cn.edu.dhu.swordoffer.package61_66;

import java.util.Stack;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 *
 * 【java】和上一题类似，本题依然用DFS来解题，依然提供递归和非递归两种方法，了解一下！
 * 方法一：非递归
 * 思路：不带记忆的DFS搜索 + 限定条件 = 普通的DSF例题
 * 1.需要记录已经遍历过的节点，用辅助矩阵visited[rows * cols]
 * 2.每次加入栈时，count++，标记已经遍历，这样下一个节点就不会遍历了
 * 入栈条件：
 * 1.每一位的和小于等于threshold：
 * 2.x和 y  的边界条件
 * 3.没有遍历过
 *
 *
 * 方法二：递归
 * * 递归的方式更加简单了，比上一题简单
 * * 出口：
 * *    0:不满足边界条件 ；已经遍历过；位数和大于阈值
 * * 1.递：
 * *     1.1标记遍历
 * *     1.2上下左右递归
 * * 2.归：返回count
 */
public class Algorithm66MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols];//记录是否已经走过
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }
    private int movingCountCore(int threshold, int rows, int cols,
                                int row, int col, boolean[] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        int i = row * cols + col;
        if (visited[i] || !checkSum(threshold, row, col)) return 0;
        visited[i] = true;
        return 1 + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                + movingCountCore(threshold, rows, cols, row - 1, col, visited);
    }
    private boolean checkSum(int threshold, int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        if (sum > threshold) return false;
        return true;
    }

    public static void main(String[] args) {
        Algorithm66MovingCount obj = new Algorithm66MovingCount();
        //递归版
        int result1 = obj.movingCount(8,4,5);
        System.out.println(result1);
        //非递归
        int result2 = obj.movingCount2(8,4,5);
        System.out.println(result2);
    }

    //非递归版本
    public int movingCount2(int threshold, int rows, int cols)
    {
        if(rows <= 0 || cols <= 0 || threshold < 0) return 0;
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[rows * cols];
        int[][] xoy = {{0,1,0,-1},{1,0,-1,0}};
        int count = 0;
        s.add(0);
        visited[0] = true;
        while(!s.empty()) {
            int  cur = s.pop();
            count++;
            for (int i = 0; i < 4; i++) {
                int x = cur % cols + xoy[0][i];
                int y = cur / cols + xoy[1][i];
                int sum = getDigitSum(x) + getDigitSum(y);
                if(x >= 0 && x < cols && y >= 0 && y < rows
                        && sum <= threshold && !visited[x + y * cols]) {
                    s.add(x + y * cols);
                    visited[x + y * cols] = true;
                }
            }
        }
        return count;
    }

    private int getDigitSum(int i) {//获取位的和
        int sum = 0;
        while(i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}


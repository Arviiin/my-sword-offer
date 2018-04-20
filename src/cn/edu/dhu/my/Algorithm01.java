package cn.edu.dhu.my;


public class Algorithm01 {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * longlong
     */
    private static boolean Find(int target, int [][] array) {
        boolean found = false;
        int rowLen = array.length;
        int colLen = array[0].length;
        int row= 0;
        int col = colLen-1;
        while(row < rowLen && col >= 0){
            int tempValue = array[row][col];
            if (target > tempValue) {
                ++row;
            } else if (target < tempValue) {
                --col;
            } else {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] array= new int[][]{{1,3,5},{4,6,8},{8,17,19}};
        boolean find = Find(12,array);
        System.out.println(find);
    }
}
package cn.edu.dhu.swordoffer.package21_40;
/**
 * 统计一个数字在排序数组中出现的次数。
 * 测试用例:
 * [1,2,3,3,3,3,4,5],3
 * 对应输出应该为:  4
 * <p>
 * 思路关键词:有序,那么就想到二分查找  找到第一个K 和 最后一个K 二者位置相减
 */
public class Algorithm37GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
    }
    public int biSearch(int[] array, double num) {
        int s = 0, e = array.length - 1;
        while (s <= e) {
            int mid = (e - s) / 2 + s;
            if (array[mid] < num)
                s = mid + 1;
            else if (array[mid] > num)
                e = mid - 1;
        }
        return s;
    }
    /*笨写法
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }

        }
        return count;
    }*/
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        Algorithm37GetNumberOfK a = new Algorithm37GetNumberOfK();
        int result = a.GetNumberOfK(array, 3);
        System.out.println(result);
    }
}
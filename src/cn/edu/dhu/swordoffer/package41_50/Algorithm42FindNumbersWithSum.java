package cn.edu.dhu.swordoffer.package41_50;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * <p>
 * 思路:不用考虑乘积最小,a+b=sum,a和b越远乘积越小,所以第一个找到的就是
 */
public class Algorithm42FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        //方法一:两头夹击,不用考虑乘积最小,a+b=sum,a和b越远乘积越小,
        /**
         * 数列满足递增，设两个头尾两个指针i和j，
         * 若ai + aj == sum，就是答案（相差越远乘积越小）
         * 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
         * 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
         * O(n)
         */
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return list;
        /*   方法二:
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayToList = new ArrayList<>();
        //将数组元素放入list中,主要想利用他的contains方法
        for (int i = 0; i < array.length; i++) {
            arrayToList.add(array[i]);
        }
        //用sum依次减去每个元素来判断数组中是否包含"差",第一个找到我们就结束.
        for (int i = 0; i < array.length; i++) {
            if (arrayToList.contains(sum - array[i])){
                arrayList.add(array[i]);
                arrayList.add(sum-array[i]);
                return arrayList;
            }
        }
        return arrayList;*/
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 4, 6, 8, 10};
        Algorithm42FindNumbersWithSum obj = new Algorithm42FindNumbersWithSum();
        ArrayList<Integer> result = obj.FindNumbersWithSum(data, 10);
        System.out.println(result);
    }
}

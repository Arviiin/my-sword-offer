package cn.edu.dhu.swordoffer.package21_40;

import java.util.ArrayList;
import java.util.List;

/**
 *输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 */
public class Algorithm29GetLeastNumbers {
    //初步思路从后往前冒泡排序，把小的放在前面，遍历k次即可
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        List<Integer> arrayList = new ArrayList<>();
        //判断k是否大于数组个数
        if (input.length < k){
            return (ArrayList)arrayList;
        }
        int count =1;
        int temp=0;
        while (count <= k){

            for (int i = input.length-1; i >= count; i--) {
                if (input[i]<input[i-1]){
                    temp = input[i];
                    input[i]= input[i-1];
                    input[i-1]= temp;
                }
            }
            arrayList.add(input[count-1]);
            count++;
        }


        return (ArrayList) arrayList;

    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,1,6,2,7,3,8};
//        int[] array = new int[]{4,2,1,4,2,4};
        Algorithm29GetLeastNumbers a = new Algorithm29GetLeastNumbers();
        ArrayList<Integer> arrayList = a.GetLeastNumbers_Solution(array, 4);
        System.out.println(arrayList.toString());
    }
}
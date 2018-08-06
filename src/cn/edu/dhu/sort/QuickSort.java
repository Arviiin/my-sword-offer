package cn.edu.dhu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] keys = {38,38,97,75,61,19,26,49};
        QuickSort obj = new QuickSort();
        int[] result = obj.quickSort(keys,0, keys.length-1);
        System.out.println(Arrays.toString(result));
    }

    private int[] quickSort(int[] keys, int low, int high) {
        if (low > high){
            return null;
        }
        int i = low, j = high;
        int vot = keys[i];
        while (i < j){
            while (i < j && keys[j] >= vot)
                j--;
            if (i < j)
                keys[i++] = keys[j];
            while (i < j && keys[i] <= vot)
                i++;
            if (i < j)
                keys[j--] = keys[i];
        }
        keys[i] = vot;
        quickSort(keys,low,i-1);
        quickSort(keys,j+1,high);
        return keys;
    }

}

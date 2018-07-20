package cn.edu.dhu.swordoffer.package41_50;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 */
public class Algorithm50Duplicate {

    //    Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {

        boolean[] k = new boolean[length];//初始化一个boolean型的数组
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;//每遇到新数就将对应boolean数组位赋值为true.
        }
        return false;
    }
/*
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length; i++) {
                for (int j = i+1; j < length; j++) {
                    if (numbers[i] == numbers[j]){
                        duplication[0] = numbers[i];
                        return true;
                    }
                }
        }
        duplication[0] = -1;
        return false;
    }
*/

    public static void main(String[] args) {
        int[] data = new int[]{2, 1, 3, 0, 4};
        int length = data.length;
        int[] duplication = new int[1];

        Algorithm50Duplicate obj = new Algorithm50Duplicate();
        boolean result = obj.duplicate(data, length, duplication);//[2,1,3,0,4]         "false,-1"
        System.out.println(result);
    }
}



    /*public int StrToInt(String str) {
        if ("".equals(str.trim()))
            return 0;
        int flag = 1;
        if (str.startsWith("-")){
            flag = -1;
        }
        String substring = "";
        if (str.startsWith("+") || str.startsWith("-")){
            substring = str.substring(1);
        }else {
            substring = str;
        }

        char[] strChars = substring.toCharArray();
        int length = strChars.length;
        int result = 0;
        int temp = -1;
        for (int i = 0; i < length && temp != -11; i++) {
            switch(strChars[i]){
                case '0':
                    //;
                    temp = 0;
                    break;
                case '1':
                    //...;
                    temp = 1;
                    break;
                case '2':
                    //
                    temp = 2;
                    break;
                case '3':
                    //...;
                    temp = 3;
                    break;
                case '4':
                    //;
                    temp = 4;
                    break;
                case '5':
                    //...;
                    temp = 5;
                    break;
                case '6':
                    //;
                    temp = 6;
                    break;
                case '7':
                    //...;
                    temp = 7;
                    break;
                case '8':
                    //;
                    temp = 8;
                    break;
                case '9':
                    //...;
                    temp = 9;
                    break;
                default:
                    //...;
                    temp = -11;
                    break;
            }
            int currentResult = (int) (temp * (Math.pow(10,length -1 -i)));
            result += currentResult;
        }
        if (temp == -11){
            return 0;
        }
        return flag*result;
    }*/

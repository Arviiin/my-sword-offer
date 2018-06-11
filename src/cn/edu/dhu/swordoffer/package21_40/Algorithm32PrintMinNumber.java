package cn.edu.dhu.swordoffer.package21_40;
/**
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。即是321 32 3
 *
 * 首先因为数组可能非常长，那么元素就有很多了，所以不可能存在一个整数类型，使得其大小可以容纳所有的数组元素组成的数。
 * 比如array = {3333,444,53,5,4,6,5555,45635463546,5643563546,35634563,54463456,3456,3456,3456,3456}。不能存在这么大的类型
 * 因此我们选择直接输出这个数组，转成字符串拼接让其看起来像一个整数，这样我们就可以把问题转化为：如何给这个数组排序，使其看做一个数字的时候最小。
 *
 * 第一个想到的可能是按字典序排序，小的在前面。可惜这个是不可行的，比如32的字典序比322小，但是32322比32232大，
 * 所以在这里自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，
 * 比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面（因为是找最小的的数）。
 *
 * 思路：第一个数组元素s1和第二个数组元素s2比较，若组成的s1+s2 < s2+s1 则不处理，再用第一个和第三个比较，
 * 若1+s2 > s2+s1则双方交换位置，再用交换过的第一和第三个比较，后面的元素都是这样操作，目的的最后的第一个位置与任意一个元素组成的数字都是最小的。
 * 然后从第二个数组元素重复上述步骤。
 */
import java.util.ArrayList;

public class Algorithm32PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        String str = "";
        for (int i=0; i<numbers.length; i++){
            for (int j=i+1; j<numbers.length; j++){
                Long a = Long.valueOf(numbers[i]+""+numbers[j]);//s1+s2
                Long b = Long.valueOf(numbers[j]+""+numbers[i]);//s2+s1
                if (a > b){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(String.valueOf(numbers[i]));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] array = new int[]{3,32,321};
        Algorithm32PrintMinNumber a = new Algorithm32PrintMinNumber();
        String minNumber = a.PrintMinNumber(array);
        System.out.println(minNumber);
    }
}
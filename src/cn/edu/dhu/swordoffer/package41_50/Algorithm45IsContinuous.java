package cn.edu.dhu.swordoffer.package41_50;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 * 为了方便起见,你可以认为大小王是0。
 * <p>
 * <p>
 * max 记录 最大值
 * min 记录  最小值
 * min ,max 都不记0
 * 满足条件 1 max - min <5
 *                2 除0外没有重复的数字(牌)
 *                3 数组长度 为5
 */
public class Algorithm45IsContinuous {

    public boolean isContinuous(int[] numbers) {
        int len = numbers.length;
        if (len != 5) {
            return false;
        }
        int[] d = new int[14];
        d[0] = -5;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (d[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 3, 2, 5, 4};//[1,3,2,5,4]
        Algorithm45IsContinuous obj = new Algorithm45IsContinuous();
//        String result = obj.isContinuous(numbers);
        boolean result = obj.isContinuous(numbers);
        System.out.println(result);
    }
}

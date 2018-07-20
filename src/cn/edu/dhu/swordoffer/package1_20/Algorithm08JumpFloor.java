package cn.edu.dhu.swordoffer.package1_20;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路，从最后登上最高台阶考虑，比如10，那么只有两种可能，从第8个台阶跨两步或者从第9个台阶跨1步。
 * 然后分别把第8个台阶，第9个台阶视为最高台阶如前所述向前递推，容易知道f（10） = f（9）+f（8），也即是
 * f（n） = f（n-1）+ f（n-2）
 */
public class Algorithm08JumpFloor {
    public static int JumpFloor(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(JumpFloor(n));
    }
}
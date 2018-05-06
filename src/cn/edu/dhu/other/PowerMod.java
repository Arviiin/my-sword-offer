package cn.edu.dhu.other;

import java.util.Scanner;

public class PowerMod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong(), y = sc.nextLong(), N = sc.nextLong();
        long res = 1;
        x = x % N;

        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % N;
            y /= 2;
            x = (x * x) % N;
        }
        System.out.println(res);
    }
}
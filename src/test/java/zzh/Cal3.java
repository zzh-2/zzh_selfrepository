package zzh;

import java.util.*;

public class Cal3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.next());

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            System.out.println(1);
        }

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
            System.out.println("reverseNum:" + reverseNum);
            System.out.println("x:" + x);
        }

        System.out.println(x == reverseNum || x == reverseNum / 10);
    }
}

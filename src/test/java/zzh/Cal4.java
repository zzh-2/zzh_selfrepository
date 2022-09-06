package zzh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cal4 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int total = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); ) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (s.charAt(i) == 'I' && i <= s.length() - 2) {
                    if (s.charAt(i + 1) == 'V') {
                        total = total + 4;
                        i++;
                        break;
                    }
                    if (s.charAt(i + 1) == 'X') {
                        total = total + 9;
                        i++;
                        break;
                    }
                }
                if (s.charAt(i) == 'X' && i <= s.length() - 2) {
                    if (s.charAt(i + 1) == 'L') {
                        total = total + 40;
                        i++;
                        break;
                    }
                    if (s.charAt(i + 1) == 'C') {
                        total = total + 90;
                        i++;
                        break;
                    }
                }
                if (s.charAt(i) == 'C' && i <= s.length() - 2) {
                    if (s.charAt(i + 1) == 'D') {
                        total = total + 400;
                        i++;
                        break;
                    }
                    if (s.charAt(i + 1) == 'M') {
                        total = total + 900;
                        i++;
                        break;
                    }
                }
                if (s.charAt(i) == entry.getKey()) {
                    total = total + entry.getValue();
                }
            }
            i++;
        }
        System.out.println("Total ===== " + total);
    }
}

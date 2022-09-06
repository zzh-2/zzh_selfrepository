package zzh;

import java.util.HashMap;
import java.util.Map;

public class Cal5 {
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

        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                total = total - value;
            } else {
                total = total + value;
            }
        }
        System.out.println("Total ===== " + total);
    }
}

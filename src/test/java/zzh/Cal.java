package zzh;

import java.io.*;
import java.util.*;

public class Cal {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("H:\\zzh_selfrepository\\src\\test\\resources\\test.txt"));
        BufferedReader reader = new BufferedReader(isr);

        int count = 0;
        int currentLine = 1;

        String content;
        int maxCount;
        String maxWord;

        HashMap<Integer, String> map = new HashMap<Integer, String>();
        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        while ((content = reader.readLine()) != null) {
            map.put(currentLine, content);
            currentLine++;
        }

        System.out.println(map);

        for (Integer key : map.keySet()) {
            if (key == 1) {
                count++;
            } else {
                String value = map.get(key);
                for (Integer key1 : map.keySet()) {
                    if (value.equals(map.get(key1))) {
                        count++;
                    }
                }
            }
            list.add(count);
            map2.put(count, map.get(key));
            count = 0;
        }

        System.out.println("map2=  " + map2);

        maxCount = Collections.max(list);
        maxWord = map2.get(maxCount);
        System.out.println("maxCount=  " + maxCount);
        System.out.println("maxWord=  " + maxWord);
    }
}

package zzh;

import cn.hutool.core.lang.hash.Hash;
import cucumber.api.java.bs.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cal2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("H:\\zzh_selfrepository\\src\\test\\resources\\test.txt"));
        BufferedReader reader = new BufferedReader(isr);

        String content;
        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        while((content = reader.readLine()) != null){
            arrayList.add(content);
        }

        System.out.println(arrayList);

        Integer count = null;
        for(String word: arrayList){
            count = map.put(word, 1);
            if (count != null){
                map.put(word, count+1);
            }
        }

        int maxCount = 0;
        String maxWord = null;
        for(HashMap.Entry<String,Integer> e : map.entrySet()){
            int value = e.getValue();
            String word = e.getKey();
            if(e.getValue() > maxCount){
                maxCount = value;
                maxWord = word;
            }
        }

        System.out.println("maxCount=  "+maxCount);
        System.out.println("maxWord=  "+ maxWord);
    }
}

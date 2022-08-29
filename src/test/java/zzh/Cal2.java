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
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\zzh_selfrepository\\src\\test\\resources\\test.txt"));
        BufferedReader reader = new BufferedReader(isr);

        String content;
        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        while((content = reader.readLine()) != null){
            arrayList.add(content);
        }

        Integer count = null;
        for(String word: arrayList){
            count = map.put(word, 1);
            if (count != null){
                map.put(word, count+1);
            }
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue()-o1.getValue();
                    }
                }
        );


        int maxCount = entryList.get(0).getValue();
        for(Map.Entry<String,Integer> e : entryList){
            if(e.getValue() >= maxCount){
                System.out.println("maxCount=  "+ e.getValue());
                System.out.println("maxWord=  "+ e.getKey());
            }else {
                break;
            }
        }
    }
}

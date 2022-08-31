package zzh;

import java.util.*;

public class Cal3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double y = Double.parseDouble(sc.next());
        int numCount = 0;
        int temp = (int)y;
        double temp2;
        double temp3 = 0;
        int temp4 = (int)y;
        int temp5 = (int)y;

        while((temp % 10) >= 1 ){
            temp = temp / 10;
            numCount++;
        }

        if(numCount ==1 ){
            System.out.println(y==temp5);
        }else if(numCount % 2 == 0){
            for(int i = numCount / 2; i <= numCount / 2 && i > 0; i--){
                temp2 = (temp4 % 10) * (Math.pow(10, i-1));
                temp4 = temp4 / 10;
                temp3 = temp3 + temp2;
            }
            System.out.println(temp3==temp4);
        }else{
            int j = numCount / 2 + 1;
            for(int i = j; i <= j && i > 0; i--){
                temp2 = (temp4 % 10) * (Math.pow(10, i-1));
                temp4 = temp4 / 10;
                temp3 = temp3 + temp2;
                j--;
            }
            temp5 = (int)(temp5 / Math.pow(10,j+1));
            System.out.println(temp3==temp5);
        }

//        int i = 1212;
//        String sI = String.valueOf(i);
//        StringBuilder sb= new StringBuilder(sI);
//
//        System.out.println(i);
//        String bs = sb.reverse().toString();
//        System.out.println(bs);
//
//        boolean result = bs.equals(sI);
//        System.out.println(result);
    }
}

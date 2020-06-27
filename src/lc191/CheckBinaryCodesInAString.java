package lc191;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckBinaryCodesInAString {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110",2));
    }
    public static boolean hasAllCodes(String s, int k) {
        Map<String,Integer> codes=new HashMap<>();
        int cur=0;
        while(cur+k<=s.length()){
            String str=s.substring(cur,cur+k);
            codes.compute(str,(key,v)->v==null?1:v+1);
            cur++;
        }
        int n= (int) Math.pow(2,k);
        return n==codes.size();
    }


}

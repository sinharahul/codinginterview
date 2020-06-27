package amazon.arrays;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};
        MostCommonWord m=new MostCommonWord();
        System.out.println(m.mostCommonWord(paragraph,banned));
    }
    String remove(String s){
        StringBuilder sb=new StringBuilder();
        for(Character ch:s.toCharArray()){
            if(Character.isAlphabetic(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public  String mostCommonWord(String paragraph, String[] banned) {
        Map<String,String> map=new HashMap<>();
        paragraph=paragraph.replaceAll(","," ");
        for(int i=0;i<banned.length;i++){
            map.put(banned[i].toLowerCase(),banned[i]);
        }
        Map<String,Integer> freq=new HashMap<>();
        int max=Integer.MIN_VALUE;
        String[] paras=paragraph.split(" ");
        String common="";
        for(int i=0;i<paras.length;i++){
            String key=paras[i].toLowerCase();
            if(key.trim().equals(""))continue;
            key=remove(key);
            freq.compute(key,(k,v)->v==null?1:v+1);
            if(map.get(key)==null){
                int f=freq.get(key);
                if(f>max){
                    max=f;
                    common=paras[i];
                }
            }
        }
        return remove(common.toLowerCase());
    }
}

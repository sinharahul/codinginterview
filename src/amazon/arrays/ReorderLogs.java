package amazon.arrays;

import java.util.Arrays;

public class ReorderLogs {
    public static void main(String[] args) {
        ReorderLogs reorderLogs=new ReorderLogs();
        String[] logs={"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        logs=reorderLogs.reorderLogFiles(logs);
        for(String log:logs){
            System.out.println(log);
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        int cmp=0;
        String[] result=new String[logs.length];
        Arrays.sort(logs,(s1, s2)->{
            String[] arr1=s1.split(" ");
            String[] arr2=s2.split(" ");
            String f1=arr1[1];
            String f2=arr2[1];
            boolean isdigits1=isDigits(f1);
            boolean isdigits2=isDigits(f2);
            if(isdigits1 && isdigits2)return 0;
            if(isdigits1 && !isdigits2)return 1;
            if(!isdigits1 && isdigits2)return -1;
            int cn1=1,cnt2=1;
            boolean eq=false;
            while(cn1<arr1.length && cnt2 < arr2.length){
                String str1=arr1[cn1];
                String str2=arr2[cnt2];
                if(str1.equals(str2) || str1.compareTo(str2)==0){
                    cn1++;
                    cnt2++;
                    continue;
                }
                if(str1.compareTo(str2) !=0) {
                    return str1.compareTo(str2);
                }
                cn1++;
                cnt2++;
            }
            return arr1[0].compareTo(arr2[0]);
        });
        return logs;
    }
    boolean isDigits(String s){
        boolean f=true;
        for(Character character:s.toCharArray()){
             if(!Character.isDigit(character)){
                 return false;
             }
        }

        return f;
    }
}

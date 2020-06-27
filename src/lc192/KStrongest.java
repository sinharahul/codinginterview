package lc192;

import java.util.Arrays;

public class KStrongest {
    int median1;
    public static void main(String[] args) {

        KStrongest ks=new KStrongest();
        int[] arr={1,2,3,4,5};
        int[] res=ks.getStrongest(arr,2);
        for(int i:res){
            System.out.println(i);
        }
    }
    public int[] getStrongest(int[] arr, int k) {
       int[] res=new int[k];
       median1=median(arr);
       arr= Arrays.stream(arr).
               boxed().
               sorted((a, b) ->
                       {
                        return stronger(a,b);
                       }

               ).
               mapToInt(i -> i).
               toArray()
       ;
       for(int i=0;i<k;i++){
           res[i]=arr[arr.length-1-i];
       }
       return res;
    }

    private int stronger(Integer a, Integer b) {
        int cmp=0;
        if(a.equals(b))return 0;
        int am=Math.abs(a-median1);
        int bm=Math.abs(b-median1);
        if(am>bm)return 1;
        if(am==bm && a>b)return 1;
        return -1;
    }

    int median(int[] arr){
        Arrays.sort(arr);
        int len=arr.length;
        int middle=0;
        if(len % 2 != 0 ){
           middle=(len-1)/2;
           return arr[middle];
        }else{
            middle=(len-1)/2;
            return arr[middle];
        }
    }
}

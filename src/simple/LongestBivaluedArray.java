package simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestBivaluedArray {


    public static int solutionOnePass(int[] A){
     int max=1;
     int s=0;
     Map<Integer,Integer> map=new HashMap<>();
     for(int i=0;i<A.length;i++){
         int elem=A[i];
         map.compute(elem,(k,v)->v==null?1:v+1);
         int count=map.get(elem);
         if(count==2){
            max=Math.max(max,(i-s+1));
         }
         if(count>2){
             s=s+1;
             //map.clear();
             map.remove(elem);
             map.put(elem,1);
         }
     }
     return max;
    }
    /**
     * return length of  longest bivalued  array
     *
     */

    public static int solution(int[] A){
        if(A.length==0 || A.length==1){
            return 0;
        }
        if(A.length==2){
            if(A[0] != A[1]){
                return 2;
            }
        }
        int s=0 ,e=s+1;
        int max=0;
        while(s< A.length && e<A.length){
            if(range(A,s,e) <=2){
                int l=e-s+1;
                if(l>max )max=l;
            }
            if(range(A,s,e) <= 2){
                e++;
                continue;
            }
            if(range(A,s,e) >2){
                s++;
                continue;
            }

            e++;
        }
        return max;
    }

    static private int range(int[] a, int s, int e) {
        Set<Integer> set = new HashSet<>();
        if(s==a.length || e==a.length)return 0;
        for(int i=s;i<=e;i++){
            set.add(a[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
     //int arr[]={4,8,5,2,5};
       int arr[]={4,8,5,2,9};
        System.out.println(solutionOnePass(arr));
    }
}

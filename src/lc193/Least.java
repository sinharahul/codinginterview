package lc193;

import java.util.*;

public class Least {
    public static void main(String[] args) {
        int[] arr={4,3,1,1,3,3,2};
        System.out.println(findLeastNumOfUniqueInts(arr,3));
    }
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int l=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.compute(arr[i],(k1,v)->v==null?1:v+1);
        }
        Queue<Integer> queue=new PriorityQueue<>(arr.length,(i, j)->{
            Integer i1=map.get(i);
            Integer j1=map.get(j);
            return Integer.compare(i1,j1);
        });
        HashSet set=new HashSet();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            Integer int1= (Integer) iterator.next();
            int ci=map.get(int1);
            for(int a=0;a<ci;a++) {
                queue.add(int1);
            }
        }
        for(int i=0;i<k;i++){
            if(!queue.isEmpty()){
                queue.poll();
            }
        }
         set=new HashSet();
        l=queue.size();
        for(int i=0;i<l;i++){
            set.add(queue.poll());
        }
        return set.size();
    }
}

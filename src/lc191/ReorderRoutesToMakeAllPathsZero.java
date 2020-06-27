package lc191;

import java.util.HashSet;
import java.util.Set;

public class ReorderRoutesToMakeAllPathsZero {
    public static void main(String[] args) {
        int[][]arr={{0,1},{2,1},{3,2},{0,4},{5,1},{2,6},{5,7},{3,8},{8,9}};
        System.out.println(minReorder(9,arr));
    }
    public static int minReorder(int n, int[][] connections) {
        int ord=0;
        Set<Integer> roots=new HashSet<>();
        roots.add(0);
        int elem=Integer.MIN_VALUE;
        for (int i=0;i<connections.length;i++){
            int[]arr=connections[i];
            if(roots.contains(arr[0]))
            {
              ord++;
              roots.add(arr[1]);
            }
            else if(roots.contains(arr[1])){
              roots.add(arr[0]);
            }else {
              throw new RuntimeException("Bomb");
            }

        }
        return ord;
    }
}

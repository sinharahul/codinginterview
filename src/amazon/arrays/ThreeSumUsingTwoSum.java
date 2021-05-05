package amazon.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumUsingTwoSum {
    static Integer[] twosum(int[] arr,int pos,int ts ){
        Arrays.sort(arr);
        int target=ts-arr[pos];
        int s=0,e=arr.length-1;
        while(s<e ){
            if(s==pos){
                s++;
                continue;
            }
            if(e==pos){
                e--;
                continue;
            }
            int sum=arr[s]+arr[e];
            if(sum==target){
                Integer[] res=new Integer[3];
                res[0]=arr[s];
                res[1]=arr[pos];
                res[2]=arr[e];
                return res;
            }else if(sum<target){
                s++;
            }else {
                e--;
            }
        }
        return null;
    }
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        //a) iterate b_find 2 sum for target elelemnt
        List<Integer[]> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            Integer[] res=twosum(array,i,targetSum);
            if(res != null){
                list.add(res);
            }
        }
        if(list.size()>0){
            return list;
        }else
            //
            return new ArrayList<Integer[]>();
    }
    public static void main(String[] args) {
        int[] nums={-1, 0, 1, 2, -1, -4};
        List<Integer[]> list=threeNumberSum(nums,0);
        for(Integer[] arr:list){
            for(int i:arr) {
                System.out.println(i);
            }
            System.out.println(">>>>>>");
        }
    }
}

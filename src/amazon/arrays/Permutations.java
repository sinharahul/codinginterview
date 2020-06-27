package amazon.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0)return res;
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        helper(list,nums.length,1);
        return res;
    }


    void helper(List<Integer> sl, int n, int index){
        if(index>=n)return;
        if(sl.size()==n){
            res.add(sl);
            //  sl=new ArrayList<>();
        }
        for(int i=index;i<n;i++){
            Collections.swap(sl,index-1,i);
            helper(sl,n,index+1);
            Collections.swap(sl,i,index-1);
        }
    }
    public static void main(String[] args) {
      Permutations p=new Permutations();
      int[]arr= {1,2,3};
        List<List<Integer>> l=p.permute(arr);

    }

}

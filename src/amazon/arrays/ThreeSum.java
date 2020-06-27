package amazon.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum=new ThreeSum();
        int[] nums={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> llist=new ArrayList<>();
        Map<Integer,List<Integer>> map =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list=map.get(nums[i]);
            if(list==null){
                list=new ArrayList<>();
                map.put(nums[i],list);
            }
            list.add(i);
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int s=nums[i]+nums[j];
                if(map.get(-s)!=null){
                    List<Integer> pl=map.get(-s);
                    for(int k=0;k<pl.size();k++){
                        int e=pl.get(k);
                        if(i!=e && j!=e){
                            List<Integer> res=new ArrayList<>();
                            res.add(nums[i]) ;
                            res.add(nums[j]);
                            res.add(nums[e]);
                            llist.add(res);
                        }
                    }
                }
            }
        }

        return llist;
    }
}

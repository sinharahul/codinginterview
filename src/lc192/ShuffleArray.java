package lc192;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
     int[] nums={2,5,1,3,4,7};
     int [] res=shuffle(nums,3);
        Arrays.stream(res).forEach((s)-> System.out.println(s));
    }
    public static int[] shuffle(int[] nums, int num) {
        int[] res=new int[2*num];
 //       if(2*num > res.length)return res;
        int c=0; int n=c+num;
        int f=0;
        while(n<nums.length){
            res[f++]=nums[c++];
            res[f++]=nums[n++];
        }
        return res;
    }
}

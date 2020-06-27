package amazon.arrays;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2963/https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2963/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
      int[] arr={1,1};
      System.out.println(maxArea(arr));
    }

    /**
     * start from left .find the highest index
     * start from right find the hoghest index .
     * Calculate the area.
     * then move the pointers outward to get the max area
     */
    public static int maxArea(int[] h) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<h.length-1;i++){
            for(int j=i+1;j<h.length;j++){
                int w=j-i;
                int hi=Math.min(h[i],h[j]);
                max=Math.max(max,hi);
            }
        }
        return max;
    }
}

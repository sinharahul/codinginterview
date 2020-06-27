package dp;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(combinationSum4(arr, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    dp[i] = nums[j];
                }else{
                    if(nums[j]<i) {
                        dp[i] += dp[i - j];
                    }
                }
            }
        }
        return dp[target];
    }
}

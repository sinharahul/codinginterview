package difficult;

/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
 * Coudnt solve
 * Given an array of integers arr of even length n and an integer k.
 *
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 *
 * Return True If you can find a way to do that or False otherwise.
 *  i%n +j%n =k
 *  find even frequencies or same
 *  handle negatives
 */
public class ArrayPairsDivisibleByK {
    public static void main(String[] args) {
      int[] arr={1,2,3,4,5,10,6,7,8,9,12,13};
      System.out.println(canArrange(arr,5));
    }
    public static boolean canArrange(int[] arr, int k) {

        int[] reminderFreq = new int[k];
        for(int a : arr) {
            int rmd = a % k;
            if(rmd < 0) {
                rmd += k;
            }
            reminderFreq[rmd]++;
        }

        for(int i = 1; i < k; i++) {
            if(reminderFreq[i] != reminderFreq[k - i])
                return false;
        }

        return reminderFreq[0] % 2 == 0;
    }
}

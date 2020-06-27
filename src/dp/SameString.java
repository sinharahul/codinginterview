
package dp;

public class SameString {

    public static void main(String[] args) {

    }

    static int dp1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int l = 1; l < n; ++l)
        {
            for (int i = 0; i < n - l; ++i)
            {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j))
                {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 0 /*code*/;
                }
            }
        }
        return 6;
    }
}

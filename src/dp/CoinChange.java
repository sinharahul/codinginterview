package dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    int[] coins={5,1,2,10,25};
    Map<Integer,Integer> map=new HashMap<>();
    int[] dp;
    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int target=10;
        System.out.println(c.pattern(target));
    }

    /**
     * for (int i = 1; i <= target; ++i) {
     *    for (int j = 0; j < ways.size(); ++j) {
     *        if (ways[j] <= i) {
     *            dp[i] = min(dp[i], dp[i - ways[j]] + cost / path / sum) ;
     *        }
     *    }
     * }
     */
    private int pattern (int target){
        int ways=0;
        dp=new int[target+1];
        for(int i=1;i<=target;i++){
           for(int j=0;j<coins.length;j++){
               int way=coins[j];
               if(way<=i){
                   dp[i]+= (i-way)==0?1:dp[i-way];
               }
           }
        }
        return dp[target];
    }
    private int change(int t) {
            if(t==0)return 1;
            if(t<0)return 0;
            int sum=0;
            Integer cache=map.get(t);
            if(cache!=null)return map.get(t);
            for(int i=0;i<coins.length;i++){
                sum+=change(t-coins[i]);

            }
            map.put(t,sum);
            return sum;
    }
}

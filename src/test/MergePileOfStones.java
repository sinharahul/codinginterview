package test;
import java.util.*;
public class MergePileOfStones {
    int max=Integer.MAX_VALUE;
    public int mergeStones(int[] stones, int k) {
        int n=stones.length;
        if(n%k!=0)return -1;
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<stones.length;i++){
            l.add(stones[i]);
        }

        find(l,n,0,k);
        return max;
    }
    List<Integer> merge(List<Integer> list,int s,int e){
        int sum=0;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<s;i++){
            res.add(list.get(i));

        }
        for(int i=s;i<=e;i++){
            sum+=list.get(i);
        }
        res.add(sum);
        for(int i=e+1;i<list.size();i++){
            res.add(list.get(i));
        }
        return res;
    }
    void find(List<Integer> list,int n,int sum,int k){
        if(list.size()==1){
            max=Math.min(max,sum);
            return;
        }
        int c=0;
        while(c+k<n){
            int t=0;
            for(int i=c;i<k;i++){
                t=t+list.get(i);
            }
            List<Integer> ml=merge(list,c,c+k-1);
            find(ml,ml.size(),sum+t,k);
            c+=k;
        }
    }
    public static void main(String[] args) {
        MergePileOfStones pds=new MergePileOfStones();
        int[] stones={3,2,4,1};
        pds.mergeStones(stones,2);
        ArrayDeque deque=new ArrayDeque();
        deque.push("");
    }

}

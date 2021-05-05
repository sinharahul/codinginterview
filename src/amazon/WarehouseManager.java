package amazon;

/**
 * /*
 * Amazon warehouse manager has to process N coming trucks with available parking slots.
 * The warehouse has K slots, and we know trucks arrival and departure time.  T
 * he manager wants to find out whether there are enough slots to satisfy the demand.
 * o
 * o	Inputs:
 * o	* First list for arrival time of parking
 * o	* Second list for departure time of parking
 * o	* Third is K which denotes the count of slot
 * o
 * o	a = [1, 2, 5] d = [7, 4, 6], k=2. ans = true
 *      1           7
 *        2  4
 * o           5 6
 *      1 2  2 2 2  1
 *
 *      [1 2 5]
 *      [4 6 7]
 *      i=0 j=0
 *      i=1 j=4
 *      while(i<len(a) && j<len(b)):
 *        if(a[i]<b[j]) i++;cnt++
 *        else j++; cnt--
 *        max=max(cnt,max)
 *      iterate through time interval *max (departure)
 *      for t in 1 to max(departure)
 *          iterate i: len(a) times :
 *                cnt=0
 *                find if t in range(d[i]-a[i]):
 *                   increment cnt
 *                if cnt>k then return false
 *      return true
 *
 *      O(len(d)) *O(len(D)
 *
 *      map ( time -> number(slots))
 *      set(d)
 *      for i 1 to len(a):
 *          if i lies between a[i-1] and d[i-1](start, end inclusive)
 *          map.put(i,map.get(i)+1)
 *          if(map.get(i) >k)return false
 *          if(i in set(d)):
 *             map.put(i,map.get(i)-1)
 *      return true;
 *
 * o	Follow ups
 * o	based on complexity of initial solution, can we have another approach to improve on time or space complexity?
 *
 * */

public class WarehouseManager {
     //non overlapping slots should be >=k
    //iterate through a
    // 1 -7
    // 2 ->4
    //create intervals
    //merge intervals
    //
    static int slots(int[] arrival,int[] departure,int k){
        int res=0;
        return res;
    }
}

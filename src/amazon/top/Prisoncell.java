package amazon.top;
import java.util.*;
public class Prisoncell {
    public static void main(String[] args) {

    }
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=N;i++){
            mark(map,cells);
            change(map,cells);

        }
        return cells;
    }
    void change(Map<Integer,Integer> map,int[] cells){
        for(int i=0;i<cells.length;i++){
            cells[i]=map.get(i+1);
        }
    }
    void mark( Map<Integer,Integer> map,int[] cells){

        map.put(1,0);
        map.put(8,0);
        for(int i=1;i<cells.length-1;i++){
            if(cells[i-1]==1 && cells[i+1]==1 ||(cells[i-1]==0 && cells[i+1]==0)){
                map.put(i+1,1);
            }
            else{
                map.put(i+1,0);
            }
        }

    }
}

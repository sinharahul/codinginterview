package lc191;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxArea {
    public static void main(String[] args) {
        int[] h={5,7,3,4,6};
        int[] v={2};
        System.out.println(maxArea(8,3,h,v));
    }
    public static int maxArea(int h, int w, int[] hcuts, int[] vcuts) {
        long area=0;
        int hlen=hcuts.length;int vlen=vcuts.length;
        int H=0;int V=0;
        if(hlen==1){
            H=Math.max(hcuts[0],Math.abs(hcuts[0]-h));
        }else {
            List<Integer> l=new ArrayList<>();
            l.add(0);
            for(int i=0;i<hcuts.length;i++){
                l.add(hcuts[i]);
            }
            l.add(h);
            Collections.sort(l);
            int max=0;
            int f=l.get(0);
            for(int i=1;i<l.size();i++){
                max=Math.max(max,l.get(i)-f);
                f=l.get(i);
            }
            H=max;
        }
        if(vlen==1){
            V=Math.max(vcuts[0],Math.abs(vcuts[0]-w));
        }else{
            List<Integer> l=new ArrayList<>();
            l.add(0);
            for(int i=0;i<vcuts.length;i++){
                l.add(hcuts[i]);
            }
            l.add(w);
            Collections.sort(l);
            int max=0;
            int f=l.get(0);
            for(int i=1;i<l.size();i++){
                max=Math.max(max,l.get(i)-f);
                f=l.get(i);
            }
            V=max;

        }
        area=H*V;
        return (int)(area %(1000000000l+7));
    }
}

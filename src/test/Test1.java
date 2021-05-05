package test;

import java.util.*;

public class Test1 {

   public static Set<Class> getallDep(Class source){
       Queue<Class> queue=new LinkedList<>();
       queue.add(source);
       Set<Class> visited=new HashSet<>();
       while(!queue.isEmpty()){

           Class cla=queue.poll();
           List<Class> l=getAdj(cla);
           visited.add(cla);
           for(Class c:l){
               if(!visited.contains(c)){
                   queue.add(c);
               }
           }

       }
       return visited;
   }

    private static List<Class> getAdj(Class cla) {
       Class[] arr=cla.getInterfaces();
       List<Class> list=new ArrayList<>();
       for(Class c:arr){
           list.add(c);
       }
       Class super1=cla.getSuperclass();
       if(super1!=null && super1!=cla){
           list.add(super1);
       }
        return list;
    }

    public static  int[] merge(int[] a,int[] b){

        int[]arr=new int[a.length+b.length];
        int curr=0;
        int as=0;
        int bs=0;
        while(as<a.length && bs < b.length){
            if(a[as]<=b[bs]){
                arr[curr++]=a[as++];
            }else {
                arr[curr++]=b[bs++];
            }
        }
        while(as<a.length){
            arr[curr++]=a[as++];
        }
        while(bs<b.length){
            arr[curr++]=b[bs++];
        }
        return arr;
    }

    public static List<Integer> common(int[] a, int[] b){

        //int[]arr=new int[a.length+b.length];
        List<Integer> list=new ArrayList<>();
        int curr=0;
        int as=0;
        int bs=0;
        while(as<a.length && bs < b.length){
            if(a[as]==b[bs]){
                list.add(a[as]);
                as++;
                bs++;
            }else if(a[as]<b[bs]){
                as++;
            }else {
                bs++;
            }

        }

        return list;
    }
    public static void main(String[] args) {
       /**
        List<Integer> res=common(new int[]{1,5,20},new int[]{5,11,25});
        for(int i:res){
            System.out.println(i);
        }
        */
       Set<Class> set=getallDep(TreeMap.class);
       for(Class c:set){
           System.out.println(c.getName());
       }
    }
}

package simple;

public class Gap {
    public static int solution(int N) {
        // write your code in Java SE 8
        int num = N;
        int gap = 0;
        int count = 0;
        boolean start =false;
        boolean end = false;
        while(num != 0){
            int i = num & 1;
            if(i==1){
                if(start) {
                    if(count > gap ){
                        gap = count;
                    }
                    count = 0;
                }else {
                    start=true;
                }

            }else {
                //i==0
                if(start){
                    count++;
                }

            }
            num = num>>1;
        }
        return gap;
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1041));
        System.out.println(solution(0));

    }
}

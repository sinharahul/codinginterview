public class Fibonacci {
    int[] arr=new int[100];
    //n=3
    //fib(2) + fib(1)=1+2=2
    // fib(2)=fib(0)+fib(1)=0+1=1

    int fibRecursive(int n) {
        System.out.println(n);
        if(n<=0)throw  new RuntimeException();
        if( n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        return fibRecursive(n-1)+fibRecursive(n-2);
    }
    void fibIterative(int n){
        int counter=2;
        int num1=0;
        int num2=1;
        if(n==0)return;
        if(n>0 ) {
            System.out.println(num1);
        }
        if(n>1) {
            System.out.println(num2);
        }
        while(counter<n){
            int num3 =num1+num2;
            System.out.println(num3);

            num1=num2;
            num2=num3;
            counter++;
        }
    }
    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        fibonacci.fibIterative(10);
        System.out.println("recursive="+fibonacci.fibRecursive(10));
        //hello
//

    }
}


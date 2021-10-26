package MathCalculations;

public class Fibnocci {
    public int fib(int n) {
        //Recurssion: space O(n) time O(n)
        // if(n==0) return 0;
        // if(n==1) return 1;
        // return fib(n-1) + fib(n-2); 

        //0, 1, 1, 2,3, 5 ......
        
        
        
        //space O(1) time O(n)
        if(n<=1) return n;
        int a=0;
        int b=1;
        for(int i = n ; i > 1; i--) {
            int sum = a+b;
            a=b;
            b=sum;
        }
        return b;
    }
}
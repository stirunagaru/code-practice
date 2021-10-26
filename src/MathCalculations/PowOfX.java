package MathCalculations;

public class PowOfX {
	 public double myPow(double x, int n) {
//       if(n < 0) {
//           x = 1/x;
//           n = -n;
//       }
      
//       double ans = 1;
//       for(int i = 0; i < n; i++) ans = ans*x;
//       return ans;
      
      
//       if(n == 0) return 1.0;
//       long N = n;
//       if(N < 0) {
//           x = 1/x;
//           N = -N;
//       }
      
//       double ans = 1;
//        double current_product = x;
//       for (long i = N; i > 0; i /= 2) {
//           if ((i % 2) == 1) {
//               ans = ans * current_product;
//           }
//           current_product = current_product * current_product;
//       }
//       return ans;
      
       double ans = 1;
       long absN = Math.abs((long)n);
      while(absN > 0) {
          if((absN & 1) == 1) ans= ans*x; // %2
          absN >>= 1; // /=2
          x *= x;
      }
      return  n < 0 ? 1/ans: ans;
  }
}

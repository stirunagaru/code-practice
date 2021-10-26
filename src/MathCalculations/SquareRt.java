package MathCalculations;

public class SquareRt {
    public int mySqrt(int x) {
        if(x < 2) return x;
        
        int l = 2;
        int r = x/2;
        
        while(l <= r) {
            int mid = l+(r-l)/2;
            
            if(mid == x/mid) return mid;
            else if(mid < x/mid) l= mid+1;
            else r = mid-1;;
        }
        return r;
    }
}

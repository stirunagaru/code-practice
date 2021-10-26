package MathCalculations;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }
    
    public static void main (String[] args) {
    	String s = "a";
    	
    	System.out.println(12%1);
    	System.out.println(12%2);

    	System.out.println(12%3);

    	System.out.println(12%4);
    	System.out.println(12%5);
    	
    	
    	
    	
//    	System.out.println("b".compareTo("a"));
//    	System.out.println("d".compareTo("c"));
    }
}

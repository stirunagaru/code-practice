package sums;

public class TwoSumII {
	  public int[] twoSum(int[] numbers, int target) {
	        return binarySearch(numbers, target);
	  }//O(log n);
	        //O(n^2)
	    //     for(int i=0; i< numbers.length; i++) {
	    //         int b = target - numbers[i];
	    //         int k = binarySearchII(numbers, i+1, numbers.length-1, b);
	    //         if(k > 0) return new int[]{i+1,k+1};
	    //     }
	    //     return new int[]{-1, -1};
	    // }
	    
	    public int[] binarySearch(int[] a, int target) {
	        int i=0;
	        int j= a.length -1;
	        while(i<j) {
	            int total = a[i] + a[j];
	            if(total == target) return new int[]{i+1, j+1};
	            if(total > target) {j--;}
	            else i++;
	        }
	         return null;
	    }
	    
	    public int binarySearchII(int[] a, int low, int high, int target) {
	        while(low<high) {
	            int middle = (low + high)/2;
	            if(a[middle] == target) return middle;
	            else if(a[middle] < target) low = middle+1;
	            else high = middle-1;
	            }
	        return (low==high && a[low] == target) ? low : -1;
	    }
}

package MathCalculations;

public class SumOddLengthSubArrays {
	    public int sumOddLengthSubarrays(int[] arr) {
	    	int sum=0;
	        int n = arr.length;
	        for(int i = 0; i<n; i++) {
	            int endCounts = i+1;
	            int startCounts = n-i;
	            int total = startCounts * endCounts; //total number of times a number is added in all subarrays
	            int oddTimes = total/2;
	            if(total % 2 == 1) oddTimes++; // if the total is odd, we need to add back one number
	            sum += oddTimes*arr[i];
	        }
	        return sum;
	//lengthyProcee
	        //         int oddSum = 0;
//	         int j=0;
//	         int n = arr.length;
//	         while(j < n) {
//	             System.out.println(j);
//	             int k = j;
//	             for(int i=0; i<n && k<n; i++, k++)
//	                 oddSum += sumOfTheArray(arr, i,k);
	            
//	             j+=2;
//	         }
//	         return oddSum;
	        
	    }
	    
	    // public int sumOfTheArray(int[] arr, int low, int high){
	    //     int sum = 0;
	    //     for(int i = low; i<=high; i++){
	    //         sum +=arr[i];
	    //     }
	    //     return sum;
	    // }
}

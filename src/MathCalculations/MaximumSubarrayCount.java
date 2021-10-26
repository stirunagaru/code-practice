package MathCalculations;

public class MaximumSubarrayCount {
	 public int maxSubArray(int[] nums) {
	        //O(n^2)
	        // int n = nums.length;
	        // int maxSum = Integer.MIN_VALUE;
	        // for(int i=0; i< n; i++) {
	        //     int sum = nums[i];
	        //     maxSum = Math.max(maxSum, sum);
	        //     for(int j=i+1;j<n; j++) {
	        //         sum += nums[j];
	        //         maxSum = Math.max(maxSum, sum);
	        //     }
	        // }
	        // return maxSum;

	        // using prefixSum techniques TC: O(n), SC:O(1)
	        
	        int n = nums.length;
	        int sum = nums[0];
	        int maxSum = nums[0];
	        for(int i=1; i<n; i++) {
	            sum = Math.max(sum + nums[i], nums[i]);
	            maxSum = Math.max(maxSum, sum);
	        }
	        return maxSum;
	    }  
}

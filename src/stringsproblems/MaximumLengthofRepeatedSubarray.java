package stringsproblems;

public class MaximumLengthofRepeatedSubarray {
	 public int findLengthDP(int[] nums1, int[] nums2) {
	        int n1l = nums1.length;
	        int n2l = nums2.length;
	        int ans = 0;
	        int[][] dp = new int[n1l+1][n2l+1];
	        for(int i = 1; i <= n1l; i++) {
	            for(int j = 1; j <= n2l; j++) {
	                if(nums1[i-1] == nums2[j-1]) {
	                    dp[i][j] = dp[i-1][j-1] + 1;
	                    ans = Math.max(ans, dp[i][j]);
	                }
	            }
	        }
	        return ans;
	    }

    public int findLengthBruteForce(int[] nums1, int[] nums2) {
        int n1l = nums1.length;
        int n2l = nums2.length;
        int len =0;
    
         for(int i = 0; i < n1l; i++) 
             for(int j= 0; j < n2l; j++) {
                 int k = 0;
                 while(i+k < n1l && j+k < n2l && nums1[i+k] == nums2[j+k]) 
                     k++;
                 len = Math.max(len, k);
             }
         return len;
    }
    
     public int findLength(int[] nums1, int[] nums2) {
		 int res = 0;
		 for (int i = 0; i < nums1.length + nums2.length - 1; i++) {
		 /*
		 ** The following [start1, start2] position is important. For example, if nums1.length == 5, nums2.length == 3,
		 ** this is to ensure [start1, start2] are calculated as follows: [4, 0], [3, 0], [2, 0], [1, 0], [0, 0], [0, 1], [0, 2].
		 ** Basically, this algorithm is alike a hard-to-think DP solution, but without additional space used.
		 */
		 int start1 = Math.max(0, nums1.length - i - 1);
		 int start2 = Math.max(0, i - nums1.length + 1);
		 int count = 0;
		 for (int j = start1, k = start2; j < nums1.length && k < nums2.length; j++, k++) {
		 if (nums1[j] == nums2[k])
		 count++;
		 else
		 count = 0;
		 res = Math.max(res, count);
		 }
		 }
		 return res;
	}
}
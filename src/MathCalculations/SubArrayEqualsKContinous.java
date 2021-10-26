package MathCalculations;

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsKContinous {
    public int subarraySum(int[] nums, int k) {
        //brute-force O(n^2)
        // int count =0;
        // int n = nums.length;
        // for(int start=0; start < n; start++) {
        //     int sum = 0;
        //     for(int end = start; end < n; end++) {
        //         sum += nums[end];
        //         if(sum==k) count++;
        //     }
        // }
        // return count;
        
        
        //logical thinking
        // sum of subarray(i,j) - k  which is equal to sum of (0,j) - sum of(0,i-1)
        // So, to save perfix sum we cn use Map to save them as twosum problem
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0; int count=0;
        for(int i=0; i< nums.length; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

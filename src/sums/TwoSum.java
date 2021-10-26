package sums;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	 public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>(); //key = num, value = address 
	        // for(int i=0; i<nums.length; i++) {
	        //     map.put(nums[i], i);
	        // }
	        // for(int i = 0; i < nums.length ; i++) {
	        //     int b = target - nums[i];
	        //     if(map.containsKey(b) && map.get(b) != i) {
	        //         return new int[]{i, map.get(b)};
	        //     }
	        // }
	        
	        for(int i = 0; i < nums.length ; i++) {
	            int b = target - nums[i];
	            if(map.containsKey(b)) {
	                return new int[]{i, map.get(b)};
	            } 
	            map.put(nums[i], i);
	            
	        }      
	        return null;
	    }
}

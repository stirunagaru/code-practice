package sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	    public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums); // O(nlog n)
	        List<List<Integer>> triplets = new ArrayList<>();
	        for(int i = 0 ; i < nums.length && nums[i] <= 0; i++) { //current value is > 0 we wont find lesser element as it is sorted.
	            if(i==0 || nums[i-1] !=  nums[i]) {
	                binarySearch(nums, i, triplets);
	            }   
	        }
	        return triplets;
	        
	    }
	    
	    private List<List<Integer>> binarySearch(int[] nums, int i, List<List<Integer>> res ) {
	        int low = i+1;
	        int high = nums.length-1;
	        while(low < high) {
	            int bc = nums[low] + nums[high]; 
	            if(bc == -nums[i]) {                
	                res.add(Arrays.asList(nums[i], nums[low], nums[high]));
	                low++;high--;
	                while (low < high && nums[low] == nums[low - 1]) low++;
	                while(low < high && nums[high]  == nums[high+1]) high--;
	            }
	            else if(bc > -nums[i]) high--;
	            else low++;
	        }
	        return  null;
	    }
	}
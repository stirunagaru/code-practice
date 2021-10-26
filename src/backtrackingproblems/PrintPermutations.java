package backtrackingproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintPermutations {

	public List<List<Integer>> permute(int[] nums) {  
	       // no.of permutations:  n!
	        List<List<Integer>> perms = new ArrayList<>();
	        List<Integer> nums_list = new ArrayList<>();
	        for(int i:nums) nums_list.add(i);
	        backtrack(nums_list, perms, 0);
	        return perms;
	    }
	    
	 void backtrack(List<Integer> nums, List<List<Integer>> perms, int fixed) {
	        int n = nums.size();
	        if(fixed == n) {
	            System.out.println(n);
	            System.out.println("fixed==n:-"+n+"-- " + fixed +"  " +nums);
	            perms.add(new ArrayList<>(nums));
	        }
	        for(int i = fixed; i < n; i++) {
	            Collections.swap(nums, fixed, i);
	            System.out.println("fixed::i: "+ fixed + "-"+ i + "--" + nums);
	            backtrack(nums, perms, fixed+1);
	            Collections.swap(nums, fixed, i);
	            System.out.println("fixed::i: "+ fixed + "-" + i + "---" + nums);
	        }
	    }
}
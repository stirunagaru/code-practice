package stringsproblems;

import java.util.List;


//Example 1:
//
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
//Example 2:
//
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//Note that you are allowed to reuse a dictionary word.
//Example 3:
//
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false

public class WorkBreak {
	  public boolean wordBreak(String s, List<String> wordDict) {
	        // (O(n*n*n(substring computation))) and space: O(n+1) //boolean array;
	        if(s.length() == 0) return true;
	        if(wordDict.size() == 0) return false;
	        int n  = s.length();
	        int maxLen = 0;
	        for(String word : wordDict) 
	            maxLen = Math.max(maxLen, word.length());
	        
	        boolean[] validIndex = new boolean[n+1];
	        
	        validIndex[0] = true;
	        for(int i = 0 ; i <= n; i++) {
	            for(int j = i-1; j >=0 ; j--) {
	                if(i-j <= maxLen && validIndex[j] && wordDict.contains(s.substring(j, i))) {
	                    validIndex[i] = true;
	                    break;
	                }
	            }        
	        }
	        return validIndex[n];
	    }
}

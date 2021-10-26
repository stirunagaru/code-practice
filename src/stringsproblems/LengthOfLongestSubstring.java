package stringsproblems;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
     
        // a b c d b e f
        // 0 1 2 3 4 5 6    n=7
        //               r
        //     l    
        // a,0   res = 5
        // b,4    
        // c,2    
        // d,3
        // e,5    
        // f,6    
            
        //sliding window    
        
        int n  = s.length();
        Map<Character, Integer> set = new HashMap<Character, Integer> ();
        int maxLen = 0;
        for(int r = 0, l = 0; r < n; r++) {
            if(set.containsKey(s.charAt(r))){
                l = Math.max(l, set.get(s.charAt(r)) +1); 
            }
            set.put(s.charAt(r), r);
            
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
        
    int bruteForceApproach(String s) {   
        int i = 0;
        int n = s.length();
        int maxlen = 0;
        while(i < n) { 
            int j = i+1;
            while(j <= n) {
                if(!findDuplicates(s, i, j)) {
                    maxlen = Math.max(maxlen, j-i);
                } else {
                     j = n+2;
                }
                j++;
            }
            i++;
        }
        return maxlen;
    }
    
    boolean findDuplicates(String s, int i, int j) {
        if(i == j-1) return false;
        Map<Character, Integer> counts = new HashMap<>();
        while(i < j) {
            char c  = s.charAt(i);
            counts.put(c, counts.getOrDefault(c,0)+1);
            
            if(counts.get(c) > 1) {
                return true;
            }
          i++;
        }
        return false;
    }
}
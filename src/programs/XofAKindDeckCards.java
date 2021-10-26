package programs;

import java.util.HashMap;
import java.util.Map;

public class XofAKindDeckCards {
	 public boolean hasGroupsSizeX(int[] deck) {
	        if(deck.length < 2) return false;
	        Map<Integer, Integer> map = new HashMap<>();
	        int min = 0;
	        for(int i : deck) {
	            map.put(i, map.getOrDefault(i,0)+1);
	            min = Math.min(min, map.get(i));
	        }
	        
	        for(Integer i : map.keySet()) {
	           int val = map.get(i);
	            if(val == 1) return false;
	           min = gcd(min, map.get(i));
	           if(min == 1) return false;
	        }
	        return true;
	    }
	    
	    
	    int gcd(int x, int y) {
	        return y == 0 ? x : gcd(y, x%y);
	    }
	    
//	    Input: deck = [1,2,3,4,4,3,2,1]
//	    		Output: true
//	    		Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
//	    		Example 2:
//
//	    		Input: deck = [1,1,1,2,2,2,3,3]
//	    		Output: false
//	    		Explanation: No possible partition.
//	    		Example 3:
//
//	    		Input: deck = [1]
//	    		Output: false
//	    		Explanation: No possible partition.
//	    		Example 4:
//
//	    		Input: deck = [1,1]
//	    		Output: true
//	    		Explanation: Possible partition [1,1].
//	    		Example 5:
//
//	    		Input: deck = [1,1,2,2,2,2]
//	    		Output: true
//	    		Explanation: Possible partition [1,1],[2,2],[2,2].

//				Input: deck = [1,1,1,1,2,2,2,2,2,2]
//				Output: true
//				Explanation: Possible partition [1,1],[2,2],[2,2].

}

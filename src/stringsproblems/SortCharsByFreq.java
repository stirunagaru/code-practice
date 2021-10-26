package stringsproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharsByFreq {
	public String frequencySort(String s) {
	    if (s == null || s.isEmpty()) return s;
	        Map<Character, Integer> freq =  new HashMap<>();
	        for(char c : s.toCharArray())
	            freq.put(c, freq.getOrDefault(c, 0)+1);
	        
	        StringBuilder sb = new StringBuilder(); 
	        
//	         Queue<Map.Entry<Character, Integer>> pq  = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
//	         pq.addAll(freq.entrySet());
	        
//	         while(!pq.isEmpty()) {
//	             Map.Entry<Character, Integer> temp = pq.poll();
//	             int feq = temp.getValue();
//	             while(feq-- >0) {
//	                 sb.append(temp.getKey());
//	             }
//	         }
	        
	        
	        Queue<Character> pq  = new PriorityQueue<>((a,b) -> freq.get(b)-freq.get(a));
	        pq.addAll(freq.keySet());
	        
	        while(!pq.isEmpty()) {
	            char c = pq.poll();
	            int feq = freq.get(c);
	            while(feq-- >0) sb.append(c);
	        }

	    
//	         bucket sort
	             
//	         List<Character> [] bucket = new List[s.length() + 1];
//	         for (char key : freq.keySet()) {
//	             int frequency = freq.get(key);
//	             if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
//	             bucket[frequency].add(key);
//	         }
	        
	        
//	         for(int bs = bucket.length-1; bs > 0; bs--) {
//	             if (bucket[bs] != null) {
//	                 for (Character k : bucket[bs]) {
//	                     int co = bs;
//	                     while(co-- > 0) sb.append(k);
//	                 }
//	             }
//	         }
	        return sb.toString();
	    }
}

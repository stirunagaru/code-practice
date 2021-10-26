package stringsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagrams {
	  public List<Integer> findAnagrams(String s, String p) {
	         int ns = s.length(), np = p.length();
	         if (ns < np) return new ArrayList<Integer>();
	        
	        List<Integer> anagramsIndx = new ArrayList<Integer>();

	        int[] pArr = new int[26];
	        int[] sArr = new int[26];
	        
	        for(char pChar : p.toCharArray()) pArr[pChar - 'a']++;

	        for(int i = 0; i < ns ; i++) {
	            sArr[s.charAt(i)-'a']++;
	            if(i >= np) sArr[s.charAt(i-np)-'a']--;
	            if(Arrays.equals(pArr, sArr)) anagramsIndx.add(i - np + 1);
	        }
	        // Map<Character, Integer> pc = new HashMap<>();
	        // Map<Character, Integer> swc = new HashMap<>();
	        // for(char pChar : p.toCharArray()) pc.put(pChar, pc.getOrDefault(pChar, 0) + 1);
//	         for(int i =0; i < ns ; i++) {
//	             char temp = s.charAt(i);
	            
//	             swc.put(temp, swc.getOrDefault(temp, 0) + 1);
//	             if(i >= np) {
//	                 char remove = s.charAt(i-np);
//	                 if(swc.get(remove) == 1) swc.remove(remove);
//	                 else swc.put(remove, swc.get(remove)-1);
//	             }

//	             if (pc.equals(swc)) anagramsIndx.add(i - np + 1);
	            
//	         }
	                
	        return anagramsIndx;
	        
	    }
}

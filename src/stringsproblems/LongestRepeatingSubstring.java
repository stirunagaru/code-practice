package stringsproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {

	int usinSuffixes (String s) { //O(n^2)        
        int n = s.length();
        int size = 0;
        String[] suffixes = new String[n];
	
        for(int i = 0; i < n; i++)
            suffixes[i] = s.substring(i);
        
        Arrays.sort(suffixes);
        
        for(int j = 0; j < suffixes.length-1; j++) {
            String a = suffixes[j];
            String b = suffixes[j+1];
            int min = Math.min(a.length(), b.length());
            int k;
            for(k = 0; k < min; k++) {
                if(a.charAt(k) != b.charAt(k))
                    break;
            }
            size= Math.max(size, k);      
        }
         return size;   
	}
     
	int usingHashSet(String s) { //O(n^2 log n)
         Set<String> set = new HashSet<>();
         int i = 0;
         int n = s.length();
         int size = 0;
         while(i < n) {
             int j = i + size + 1;
             if(j > n) return size;
             String temp = s.substring(i, j);
             if(set.contains(temp)) {
                 size++;
                 set.clear();
                 i = 0;
                 continue;
             } else {
                 set.add(temp);
                 i++;
             }
         }
         return size;
	}
}

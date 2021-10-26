package stringsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        if(words == null || words.length == 0)
            return pairs;
        
        Map<String, Integer> wordSet = new HashMap<>();
        
        for(int i = 0; i < words.length; i++) 
        	wordSet.put(words[i], i);
        
        for(String word : wordSet.keySet()) {
            //case 1:
            String rWord =  reverse(word);
            int wIndex = wordSet.get(word);
            if(wordSet.containsKey(rWord) && wIndex != wordSet.get(rWord)) 
                pairs.add(Arrays.asList(wIndex, wordSet.get(rWord)));
            
            //case 2: find Suffixes for Palindrome Prefixes - current word referred as word 2 
            for(String suffix : suffixForPalindromePrefix(word)) {
                 String rSuffix =  reverse(suffix);
                 if(wordSet.containsKey(rSuffix)) 
                    pairs.add(Arrays.asList(wordSet.get(rSuffix), wIndex));
            }
            
            //case 3: find prefixes for Palindrome Suffixes - current word referred as word 1
            for(String prefix : prefixForPalindromeSuffixes(word)) {
                String rPrefix =  reverse(prefix);
                if(wordSet.containsKey(rPrefix))
                    pairs.add(Arrays.asList(wIndex, wordSet.get(rPrefix)));
             }
        }
        return pairs;
    }
    
    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    List<String> suffixForPalindromePrefix(String s) {
        List<String> sfs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, 0, i)) {
                sfs.add(s.substring(i+1, s.length()));
            }
        }
        return sfs;
    }
    
    List<String> prefixForPalindromeSuffixes(String s) {
        List<String> pfs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, i, s.length()-1)) {
                pfs.add(s.substring(0, i));
            }
        }
        return pfs;
    }
    
    boolean isPalindrome(String s, int l, int h) {
        while(l < h) {
            if(s.charAt(l++) != s.charAt(h--))
                return false;
        }
        return true;
    }
	
    public List<List<Integer>> palindromePairsBF(String[] words) {
        //BF
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i == j) continue;
                String comb = words[i] + words[j];
                String reverse = new StringBuilder(comb).reverse().toString();
                if(comb.equals(reverse))
                    pairs.add(Arrays.asList(i,j));
            }
        }
        return pairs;
    }
}

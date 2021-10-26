package stringsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairsTrie {
	    private static class TrieNode {
	        TrieNode[] next;
	        int index;
	        List<Integer> list;

	        TrieNode() {
	            next = new TrieNode[26];
	            index = -1;
	            list = new ArrayList<>();
	        }
	    }
	    
	    public List<List<Integer>> palindromePairs(String[] words) {

	        TrieNode root = new TrieNode();

	        for (int i = 0; i < words.length; i++) {
	            addWord(root, words[i], i);
	        }
	        
	        List<List<Integer>> res = new ArrayList<>();
	        for (int i = 0; i < words.length; i++) {
	            search(words[i], i, root, res);
	        }
	        return res;
	    }
	    
	    private void addWord(TrieNode root, String word, int index) {      
	        for (int i = word.length() - 1; i >= 0; i--) { // adding in reverse
	            int j = word.charAt(i) - 'a';
	            if(root.next[j] == null) 
	                root.next[j] = new TrieNode();
	            if(isPalindrome(word, 0, i))
	                root.list.add(index);
	            
	            root = root.next[j];
	        }
	        root.list.add(index); // the single letter is palindrome.
	        root.index = index; // reached end;
	    }
	    
	     private void search(String word, int i, TrieNode root, List<List<Integer>> res) {
	         for (int j = 0; j < word.length(); j++) {
	             // case 3: reached ending but current word still has letter check for palindrome.
	            if(root.index  != -1 && root.index != i && isPalindrome(word, j, word.length()-1)) {
	                res.add(Arrays.asList(i, root.index));
	            }
	            
	            root = root.next[word.charAt(j) - 'a'];
	            if(root == null) return;
	         }
	         
	         for (int j : root.list) { // for case 2:
	    	    if (i == j) continue;
	    	    res.add(Arrays.asList(i, j));
	         }
	     }
	    
	    
	    
	    
	    boolean isPalindrome(String s, int l, int h) {
	        while(l < h) {
	            if(s.charAt(l++) != s.charAt(h--))
	                return false;
	        }
	        return true;
	    }
	}
package stringsproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumDailLetterCombo {
	
	Map<Character, String> dail; // = Map.of( '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"); 
    List<String> results =  new ArrayList<String>();
    
    public List<String> letterCombinationsBctrk(String digits) {
        if(digits.length() == 0) return results;
        dail  = new HashMap<>();
        dail.put('2', "abc");
        dail.put('3', "def");
        dail.put('4', "ghi");
        dail.put('5', "jkl");
        dail.put('6', "mno");
        dail.put('7', "pqrs");
        dail.put('8', "tuv");
        dail.put('9', "wxyz");
        backtrack(0, new StringBuilder(), digits, digits.length());
        return results;
    }
    
    void backtrack(int idx, StringBuilder curr, String digits, int m) {
        if(curr.length() == m) {
            results.add(curr.toString()); return;
        }
        String letters = dail.get(digits.charAt(idx));
        for(char letter : letters.toCharArray()) {
            curr.append(letter);
            backtrack(idx+1, curr, digits, m);
            curr.deleteCharAt(curr.length()-1);
        }
    }
	
	
	
	 public List<String> letterCombinations(String digits) {
	        List<String> result =  new ArrayList<String>();
	        if(digits.length() == 0) return result;
	         
	        Map<Character, List<String>> dail  = new HashMap<>();
	        dail.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
	        dail.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
	        dail.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
	        dail.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
	        dail.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
	        dail.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
	        dail.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
	        dail.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
	        
	        result.add("");
	        for(int i = 0; i < digits.length(); i++) {
	            char c = digits.charAt(i);
	            List<String> temp = dail.get(c);
	            List<String> currResult = new ArrayList<>();
	            for(String numS : temp) {
	                for( String resS : result) {
	                    currResult.add(resS+numS);
	                }
	            }
	            result = new ArrayList<>(currResult);
	        }
	        return result;
	    }
	 
	 
	    public List<String> letterCombinations2(String digits) {
	    	    List<String> result =  new ArrayList<String>();
	 	        if(digits.length() == 0) return result;
	 	         
	 	        Map<Character, String> dail  = new HashMap<>();
	 	        dail.put('2', "abc");
	 	        dail.put('3', "def");
	 	        dail.put('4', "ghi");
	 	        dail.put('5', "jkl");
	 	        dail.put('6', "mno");
	 	        dail.put('7', "pqrs");
	 	        dail.put('8', "tuv");
	 	        dail.put('9', "wxyz");
	 	        
	 	        result.add("");

	 	        for(int i = 0; i < digits.length(); i++) {
	 	            List<String> currResult = new ArrayList<>();
	 	            for(char numCH : dail.get(digits.charAt(i)).toCharArray()) {
	 	                for( String resS : result) {
	 	                    currResult.add(resS+String.valueOf(numCH));
	 	                }
	 	            }
	 	            result = currResult;
	 	        }
	 	        return result;
	 	    }
}

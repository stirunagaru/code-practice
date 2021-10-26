package stringsproblems;

public class ShortestPalindrome {
	 public String shortestPalindromeBruteForce(String s) {
	        if (s == null || s.length() == 0) 
	            return s;
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i = s.length() - 1; i >= 0; i--) {
	            sb.append(s.charAt(i));
	        }
	        String t = sb.toString();
	        for (int i = 0; i <= t.length(); i++) {
	            String temp = t.substring(i);
	            if (s.startsWith(temp)) {
	                return t.substring(0, i) + s;
	            }
	        }
	        return t + s;
	    }
	    
	    public String shortestPalindrome(String s) {
	        if (s == null || s.length() == 0) {
	            return s;
	        }
	        String r = new StringBuilder(s).reverse().toString();
	        String kmp = s + "$" + r;
	        int length = kmp.length();
	        int[] lps = new int[length];
	        // KMP get longest prefix and suffix count
	        int i = 1;
	        int j = 0;
	        
	        while(i < length) {
	            if(kmp.charAt(i) == kmp.charAt(j)) {
	                lps[i++] = ++j;
	            } else if(j != 0) {
	                j = lps[j-1];
	            } else {
	                lps[i++] = 0;
	            }
	        }
	        return r.substring(0, r.length() - lps[length - 1]) + s;
	        
	    }
}

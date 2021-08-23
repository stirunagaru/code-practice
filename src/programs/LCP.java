package programs;

import java.util.Arrays;

public class LCP {
    public String longestCommonPrefix(String[] strs) {
        //vertical approach
         String prefix = "";
         int size = strs[0].length();
         for(int i=1; i< strs.length; i++) {
            int tempSize = strs[i].length();
            if(size > tempSize){ size = tempSize;} 
         }
         for(int i=0;i<size;i++) {
             char c = strs[0].charAt(i); // f
             for(int j=1; j<strs.length;j++) {
              if(strs[j].charAt(i) != c) {
                 return prefix; 
              } 
            }
            prefix += c; 
         }
         return prefix;
    }
    

    public String lcpHorizontal(String[] strs) {
         if(strs == null || strs.length == 0) return "";
         String prefix = strs[0];
         for(int i=1;i<strs.length;i++) {
             while(strs[i].indexOf(prefix) != 0) {
                 prefix = prefix.substring(0, prefix.length()-1);
                 if(prefix.length() == 0) return "";
             }
         }
         return prefix;
    }
        
    public String lcpWithSorting(String[] strs) {
        //with sorting:
        if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        StringBuilder prefix = new StringBuilder();
        String small = strs[0];
        String big = strs[strs.length-1];
        for(int i = 0; i < small.length(); i++) {
            if(small.charAt(i) == big.charAt(i)) {
                prefix.append(small.charAt(i));
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
}

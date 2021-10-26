package stringsproblems;

public class IndexOf {
public int strStr(String haystack, String needle) {
        
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        
        if (needle.length() == 0) return 0;
        int ns = needle.length();
        int[] lps = new int[ns];
        lps[0] = 0;
        int j = 0; int i = 1;
        //Knutt-morris - pratt  - longest prefix that is also suffix;
        while(i < ns) {
            if(needle.charAt(j) == needle.charAt(i)) // lps[i] = j+1; i++; j++;
                lps[i++] = ++j;
            else if(j != 0) 
                j = lps[j-1];
            else
              lps[i++] = 0;//lps[i] = 0;i++;
        }   
     
        int hp = 0; int np = 0;
        while (hp < haystack.length()) {
            if(haystack.charAt(hp) == needle.charAt(np)) {
                hp++; np++;
            } else if(np != 0)
                np = lps[np-1];
            else
                hp++;
            
            if(np == ns) return hp-np;
        }
        
        return -1;
    }
}

package stringsproblems;

import java.util.Arrays;

public class AddBoldTag {
	public String addBoldTagWithArraysFill(String s, String[] words) {
        boolean[] b = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++) 
            for(String w : words) 
                if(s.startsWith(w, i))
                    Arrays.fill(b, i, i + w.length(), true);
        StringBuilder r = new StringBuilder();
        for(int i = 0; i < s.length(); i++)  {
            if(b[i] && (i==0 || !b[i-1])) r.append("<b>");
            r.append(s.charAt(i));
            if(b[i] && (i == s.length()-1 || !b[i+1])) r.append("</b>");
        }
        
        return r.toString();
    }
	
	public String addBoldTagTwoPointers(String s, String[] words) {
        boolean[] b = new boolean[s.length()];
        
        for(String w : words) {
            int index = s.indexOf(w);
            while(index != -1) {
                int strt = index; int end = index + w.length();
                while(strt < end) b[strt++] = true;
                index = s.indexOf(w, index+1);
            }
        }
            
        StringBuilder r = new StringBuilder();
        for(int i = 0; i < s.length(); i++)  {
            if(b[i]) {
                r.append("<b>");
                while(i < s.length() && b[i]) r.append(s.charAt(i)); i++;
                r.append("</b>");
                i--;
            } else {            
                r.append(s.charAt(i));
            }
        }
        
        return r.toString();
    }
}

package stringsproblems;

import java.util.Arrays;

public class BoldWordsInString {
	public String boldWords(String[] words, String s) {
        boolean[] isBold = new boolean[s.length()+1];
        
        for( String w : words) {
            int index = s.indexOf(w);
            int end = w.length();
            while(index != -1) {
                Arrays.fill(isBold, index, index + end, true);
                index = s.indexOf(w, index+1);
            }
        }
                
        StringBuilder st =  new StringBuilder();
        if(isBold[0]) st.append("<b>");
        for(int i = 0; i < isBold.length-1 ; i++) {
            st.append(s.charAt(i));
            if(!isBold[i] && isBold[i+1])
                st.append("<b>");
            else if(isBold[i] && !isBold[i+1])
                st.append("</b>"); 
        }
        
        return st.toString();
    }
}

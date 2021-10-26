package stringsproblems;

import java.util.Comparator;

//Example 1:
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
	//using a custom comparator
    Comparator<String> compareStrings = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            int asize = a.length();
            int bsize = b.length();
            
            int i = 0;
            for(; i < asize && i < bsize; i++) {
                int orderIndexOfA = order.indexOf(a.charAt(i));
                int orderIndexOfB = order.indexOf(b.charAt(i));
                if(orderIndexOfA < orderIndexOfB) return -1;
                else if(orderIndexOfA > orderIndexOfB) return 1;
            }
            return asize == bsize ? 0 : (i == asize ? -1: 1);
        }
    };
    
    
    for(int j = 1 ; j < words.length; j++ ) {
        if (compareStrings.compare(words[j-1], words[j]) > 0) return false;
    }
    return true;
}
}

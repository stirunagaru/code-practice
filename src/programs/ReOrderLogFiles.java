package programs;

import java.util.Arrays;
import java.util.Comparator;

public class ReOrderLogFiles {
	
//	Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
//			Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
//			Explanation:
//			The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
//			The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
    public String[] reorderLogFiles(String[] logs) {
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare (String a, String b) {
//                String[] s1 = a.split(" ", 2);
//                String[] s2 = b.split(" ", 2);
//                
//                boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
//                boolean isDigit2 = Character.isDigit(s2[1].charAt(0));
//                //if both are  digits
//                if(isDigit1 && isDigit2) { //both are digitslogs maintain relative ordering
//                    return 0;
//                } 
//                if(!isDigit1 && isDigit2) { // if a is string
//                    return -1;
//                }
//                if(isDigit1 && !isDigit2) { // if b is string
//                    return 1;
//                }
//                
//                //both are strings
//                //first compare the values
//
//                int strComp = s1[1].compareTo(s2[1]);
//                //strComp == 0 content is equal, compare identifiers;
//                if(strComp == 0) { 
//                    return s1[0].compareTo(s2[0]);
//                }
//                return strComp;
//            }
//        };
//        
//        Arrays.sort(logs, comparator);
//        return logs;   
        
        
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare (String a, String b) {
                int s1 = a.indexOf(" ");
                int s2 = b.indexOf(" ");
                
                String content1 = a.substring(s1 + 1);
                String content2 = b.substring(s2 + 1);
                
              
                //if both are  digits
                if(content1.charAt(0) <= '9') {
                    return content2.charAt(0) <= '9' ? 0: 1;
                } else {
                    if(content2.charAt(0) <= '9') { // if a is string
                        return -1;
                    }
                    else {
                       int strComp = content1.compareTo(content2);
                       return strComp == 0 ? a.substring(0, s1).compareTo(b.substring(0, s2)) : strComp; 
                    }
                }
            }
        });
        return logs; 
    }
}

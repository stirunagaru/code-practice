package stringsproblems;

import java.util.*;

class WordBreakII {
    
	String str;
    List<String> results;
    List<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        results = new ArrayList<>();
        dict = wordDict;
        str = s;
        traverseString(0, "");
        return results;
    }
    
    void traverseString(int start, String temp) {
        if(start == str.length()) {
            results.add(temp);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start ; i < str.length() ; i++) {
            sb.append(str.charAt(i));
            if(dict.contains(sb.toString())){
            String t = temp.length() > 0 ? temp + " " + sb.toString() : sb.toString();
            traverseString(i+1, t);}
        }
    }
	
	
//    
//    List<String> res = new ArrayList();
//    Set<String> dict = new HashSet();
//    int n = 0;
//    String str;
//    
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        for (String word: wordDict)
//            dict.add(word);
//        n = s.length();
//        str = s;
//        helper(0, new StringBuilder());
//        return res;
//    }
//    
//    private void helper(int idx, StringBuilder sb) {
//        int len = sb.length();
//        if (idx == n) {
//            sb.deleteCharAt(len-1);
//            res.add(sb.toString());
//            sb.append(" ");
//            return;
//        }
//        for (int i = idx; i < n; i++) {
//            String cur = str.substring(idx, i+1);
//            if (!dict.contains(cur)) continue;
//            sb.append(cur).append(" ");
//            helper(i+1, sb);
//            sb.setLength(len);            
//        }
//    }
    
    
//     protected Set<String> wordSet;
//     protected HashMap<String, List<List<String>>> memo;
    
//     public List<String> wordBreak(String s, List<String> wordDict) {
//         wordSet = new HashSet<>();
//         for(String d : wordDict) {
//             wordSet.add(d);
//         }
        
//         memo = new HashMap<>();
//         _wordBreak_topdown(s);
        
//         List<String> ret = new ArrayList<String>();
//         for (List<String> words : memo.get(s)) {
//             StringBuffer sentence = new StringBuffer();
//             for (String word : words) {
//                 sentence.insert(0, word);
//                 sentence.insert(0, " ");
//             }
//               ret.add(sentence.toString().strip());
//         }
//         return ret;
    
//     }
    
//     protected List<List<String>> _wordBreak_topdown(String s) {
//         if(s.equals("")) {
//            List<List<String>> solutions = new ArrayList<List<String>>();
//            solutions.add(new ArrayList<String>());
//            return solutions; 
//         }
        
//          if (memo.containsKey(s)) {
//             return memo.get(s);
//         } else {
//             List<List<String>> solutions = new ArrayList<List<String>>();
//             memo.put(s, solutions);
//         }
        
//         for (int endIndex = 1; endIndex <= s.length(); ++endIndex) {
//             String word = s.substring(0, endIndex);
//             if (wordSet.contains(word)) {
//                 List<List<String>> subsentences = _wordBreak_topdown(s.substring(endIndex));
//                 for (List<String> subsentence : subsentences) {
//                     List<String> newSentence = new ArrayList<String>(subsentence);
//                     newSentence.add(word);
//                     memo.get(s).add(newSentence);
//                 }
//             }
//         }
//         return memo.get(s);

        
//     }
    
}
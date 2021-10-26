package stringsproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReplaceWords {
	
	//iterative normal method
    public String replaceWords(List<String> dictionary, String sentence) {
        int minLen = dictionary.get(0).length();
        Set<String> dict = new HashSet<>(dictionary);
        for(String s  : dictionary) {
            minLen = Math.min(minLen, s.length());
        }
        
        StringBuilder result = new StringBuilder();
        
        for(String word: sentence.split(" ")) {
            if(word.length() < minLen) {
                result.append( word + " ");
                continue;
            }
            String temp = "";
            // boolean found = false;
            for(int i = 1; i <= word.length(); i++) {
                temp = word.substring(0, i);
                if(dict.contains(temp)) {
                    // found = true;
                    break;
                }
            }
            result.append(temp + " "); 
        }
        
        String res = result.toString();
        return res.trim();
    }
}

//using Trie
class Solution {
    Trie root = new Trie('$');
    int minLen;
    public String replaceWords(List<String> dictionary, String sentence) {
        
        if(sentence == null || sentence.isEmpty()) return "";
        if(dictionary == null || dictionary.size() == 0) return sentence;
        
        minLen = dictionary.get(0).length();
        buildTrie(dictionary);
        StringBuilder result = new StringBuilder();
        for(String word : sentence.split("\\s+")) {
            if(word.length() < minLen) {
                result.append(word + " "); continue;
            }
            result.append(prefix(word) + " ");
        }
        return result.toString().trim();
    }
    
    String prefix (String word) {
        Trie trie = this.root;
        for(char c : word.toCharArray()) {
            if(trie.child.get(c) == null) return word;
            trie = trie.child.get(c);
            if(trie.isWord) return trie.word;
        }
        return word;
    }
    

    class Trie {
        char c;
        Map<Character, Trie> child;
        boolean isWord;
        String word;
        Trie(char c) {
            this.c = c;
            this.child = new HashMap<>();
            isWord = false;
            word = "";
        }
    }

    void buildTrie(List<String> dict) {
        for(String s : dict) {
            minLen = Math.min(minLen, s.length());
            Trie current = root;
            for(char c: s.toCharArray()) {
                current = current.child.computeIfAbsent(c, k -> new Trie(k));    
            }
            current.word = s;
            current.isWord = true;
        }
    }
}
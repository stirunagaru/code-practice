package intresting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToAddPranthasis {
	 Map<String, List<Integer>> map = new HashMap<>();
	    public List<Integer> diffWaysToCompute(String ex) {
	    
	        
	        if(map.containsKey(ex)) return map.get(ex);
	        List<Integer> ret = new ArrayList<>();
	        
	        for(int i = 0; i < ex.length(); i++) {
	            char sym = ex.charAt(i); 
	            if(sym == '*' || sym == '+' || sym == '-') {
	                String left = ex.substring(0, i);
	                String right = ex.substring(i+1);
	                List<Integer> leftValues = diffWaysToCompute(left);
	                List<Integer> rightValues = diffWaysToCompute(right);
	                for(Integer l : leftValues) {
	                    for(Integer r : rightValues) {
	                        int c = 0;
	                        if(sym == '+')  c = l+r;
	                        else if (sym == '-') c = l-r;
	                        else  c = l*r;
	                        ret.add(c);
	                    }
	                }
	                
	            }
	        }
	        
	        if (ret.size() == 0) {
	            ret.add(Integer.valueOf(ex));
	        }
	        map.put(ex, ret);
	        return ret;
	    }
}

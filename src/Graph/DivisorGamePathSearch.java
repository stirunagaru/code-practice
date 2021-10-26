package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DivisorGamePathSearch {
	 public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	        Map<String, Map<String, Double>> graph  =  new HashMap<>();
	        for(int i = 0; i < equations.size(); i++) { // graph
	            List<String> equation = equations.get(i);
	            String dividend = equation.get(0); String divisor = equation.get(1);
	            graph.putIfAbsent(dividend, new HashMap<>()); graph.get(dividend).put(divisor, values[i]);
	            graph.putIfAbsent(divisor, new HashMap<>()); graph.get(divisor).put(dividend, 1 / values[i]);
	        }

	        double[] res = new double[queries.size()];

	        for(int j = 0; j < queries.size(); j++) {
	            List<String> q = queries.get(j);
	            String dividend = q.get(0); String divisor = q.get(1);
	            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
	                res[j] = -1.0; continue;
	            }
	            res[j] = findWeight(dividend, divisor, new HashSet<>(), graph);
	        }
	        return res;
	    }
	    
	    double findWeight(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph) {
	        
	        if(graph.get(src).containsKey(dest)) return graph.get(src).get(dest);
	        
	        visited.add(src);
	        for(Map.Entry<String,Double> next : graph.get(src).entrySet()) {
	            if(!visited.contains(next.getKey())) {
	                double total = findWeight(next.getKey(), dest, visited, graph);
	                if(total != -1.0) return next.getValue() * total;
	            }
	        }
	        return -1.0;
	    }
}

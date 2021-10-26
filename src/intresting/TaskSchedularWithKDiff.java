package intresting;

public class TaskSchedularWithKDiff {
	 public int leastInterval(char[] tasks, int n) {
	        if(n==0) return tasks.length;
	        
	        int[] fq = new int[26];
	        
	        for(char c : tasks)  fq[c-'A']++;
	        
	        int maxFq = 0;
	        for(int f : fq) maxFq = Math.max(maxFq, f);
	        
	        int sameMax = 0;
	        for(int f : fq) 
	            if(maxFq == f) sameMax++;
	        
	        return Math.max(tasks.length, (maxFq-1) * (n+1) + sameMax);
	        
	        
//	         Map<Character, Integer> taskCount = new HashMap<>();
//	         for (char c : tasks) {
//	             taskCount.put(c, taskCount.getOrDefault(c, 0) + 1);
//	         }
	        
//	         PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(
//	             (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

	        
//	         q.addAll(taskCount.entrySet());
//	         int count = 0;
	        
	        
//	         while (!q.isEmpty()) {
//	             int k = n+1;
//	             List<Map.Entry> tempList = new ArrayList<>();
//	             while(k > 0 && !q.isEmpty()) {
//	                 Map.Entry<Character, Integer> top =  q.poll();
//	                 top.setValue(top.getValue()-1);
//	                 tempList.add(top);
//	                 k--;
//	                 count++;
//	             }
//	             for (Map.Entry<Character, Integer> e : tempList) {
//	                 if (e.getValue() > 0) q.add(e); 
//	             }
//	             if(q.isEmpty()) break;
//	             count += k; //idle

//	         }
//	         return count;
	    }
}

package intresting;

public class UnableToEatLunch {
	 public int countStudents(int[] students, int[] sandwiches) {
	        int[] type = new int[2];
	        for(int i : students)
	            type[i]++;
	        int k = 0;
	        int n = students.length;
	        for(int s : sandwiches){
	            if(type[s]==0)
	                return n-k;
	            else
	                type[s]--;
	            k++;
	        }
	        
	        return n-k;
	        
	// 1 - 3
	// 0 - 0
	        
	// 1 0 0 0 1 1
	         // ^
	        // k= 3
	        //my idea
	        // List<Integer> hungries = new ArrayList<>();
	        // List<Integer> food = new ArrayList<>();
	        // int count = 0;
	        // for(int i : students) hungries.add(i);
	        // for(int i : sandwiches) food.add(i);
	        // while(!food.isEmpty()) {
	        //     if(hungries.get(0) == food.get(0)) {
	        //         hungries.remove(0);
	        //         food.remove(0);
	        //         count = 0;
	        //     } else {
	        //         count++;
	        //         hungries.add(hungries.remove(0));
	        //         if(count==hungries.size()) return count;
	        //     }
	        // }
	        // return 0;
	    }
}

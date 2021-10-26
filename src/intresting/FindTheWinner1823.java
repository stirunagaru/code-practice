package intresting;

public class FindTheWinner1823 {
	 public int findTheWinner(int n, int k) {
	        return n == 1 ? 1 : (findTheWinner(n - 1, k) + k-1) % n + 1;
	                
	        // if(n == 1|| k == 1) return n;
	        // List<Integer> l = new ArrayList<>();
	        // for(int i = 1; i <=n ; i++)
	        //     l.add(i);
	        // int i = 0;
	        // while(l.size() > 1) {
	        //     i = (i + k - 1) % l.size();
	        //     l.remove(i);
	        // }
	        // return l.get(0).intValue();
	        
	        // Queue<Integer> q = new LinkedList<>();
	        // for(int i = 1; i <=n ; i++)
	            // q.offer(i);
	        // while(q.size() > 1) {
	        //     int counter = (k-1) % q.size();
	        //     while(counter > 0) {
	        //         q.offer(q.remove());
	        //         counter--;
	        //     }
	        //     q.remove();
	        // }
	        // return q.peek();
	    }
}

//f(1, k) = 0 -> base case;           
//f(n,k) = (f(n-1, k) + k) % n;    
//f(7,3) = (f(6, 3) + 3) % 7; = 0+3 % 7 = 3
//f(6,3) = (f(5, 3) + 3) % 6; = 3+3 % 6 = 0 
//f(5,3) = (f(4, 3) + 3) % 5; = 0+3 % 5 = 3
//f(4,3) = (f(3, 3) + 3) % 4; = 1+3 % 4 = 0
//f(3,3) = (f(2, 3) + 3) % 3; = 1+3 % 3 = 1
//f(2,3) = (f(1, 3) + 3) % 2; = 0+3 % 2 = 1
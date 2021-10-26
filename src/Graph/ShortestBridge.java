package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
	class Solution {
		 //first mark the first island to another number to differentiate
		    public int shortestBridge(int[][] A) {
		    
		        if (A.length == 0) return 0;
		        int m = A.length;
		        
		        Queue<int[]> q = new LinkedList<>();
		        boolean marked = false;
		        
		        for(int i = 0; i < m; i++) {
		            for(int j = 0; j < m; j++) {
		                if(!marked && A[i][j] == 1) {
		                    dfs(A, i , j);
		                    marked = true;
		                }                
		                
		                if(marked && A[i][j] == 1) {
		                    q.add(new int[]{i, j});
		                }
		            }    
		        }
		        
		        
		        
		        
		        int bridge = 0;
		        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		        
		        while (!q.isEmpty()) {
		            int size = q.size();
		            for(int k = 0; k < size; k++) {
		                int[] pair = q.poll();
		                 
		                for(int[] dir : dirs) {
		                    int x = pair[0] + dir[0];
		                    int y = pair[1] + dir[1];
		                    
		                    if (x >= 0 && x < m && y >= 0 && y < m) {
		                        if(A[x][y] == 2)
		                            return bridge;
		                        else if(A[x][y] == 0){
		                            A[x][y] = 1;
		                            q.offer(new int[]{x, y});
		                        }
		                    }
		                }
		            }
		            bridge++;
		        }
		        return bridge; 
		    }
		    
		    
		    void dfs(int[][] A, int i, int j) {
		        if( i < 0 || j < 0 || i >= A.length || j >= A.length ||A[i][j] == 0 || A[i][j] == 2)
		            return;
		        A[i][j] = 2;
		        dfs(A, i+1, j);
		        dfs(A, i-1, j);
		        dfs(A, i, j+1);
		        dfs(A, i, j-1);
		    }
		    
		    
		}

}

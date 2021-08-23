package programs;

import java.util.LinkedList;

public class NumberOfIslands {
	class Solution {
	    public int numIslands(char[][] grid) {
	        int islandCount = 0;
	        for(int i=0; i< grid.length; i++) {
	            for(int j=0; j< grid[i].length; j++) {
	                if(grid[i][j] == '1') {
	                    searchParty(grid, i, j);
	                    islandCount++;                
	                }
	            }
	        }
	        return islandCount;
	    }
	    
	    
	    private void searchParty(char[][] grid, int x, int y) {
	        grid[x][y] = '0'; // mark it with 0 so that we dont visit it twice.
	        LinkedList<String> q = new LinkedList<>();
	        String value = String.valueOf(x) + String.valueOf(y);
	        System.out.println(value);
	        q.offer(value);
	        
	        while(!q.isEmpty()) {
	            String code = q.poll();
	            int i = Integer.parseInt(code.substring(0,1));
	            int j = Integer.parseInt(code.substring(1,2));
	            // System.out.println(i); System.out.println(j);

	            //up
	            if(i>0 && grid[i-1][j] == '1') {
	                q.offer(String.valueOf(i-1) + String.valueOf(j));
	                grid[i-1][j] ='0';
	            }
	            //down
	            if(i<x && grid[i+1][j] == '1') {
	                q.offer(String.valueOf(i+1) + String.valueOf(j));
	                grid[i+1][j] ='0';
	            }

	            //right
	            if(j<y && grid[i][j+1] == '1') {
	                q.offer(String.valueOf(i) + String.valueOf(j+1));
	                grid[i][j+1] ='0';
	            }
	            
	            //left
	            if(j>0 && grid[i][j-1] == '1') {
	                q.offer(String.valueOf(i) + String.valueOf(j-1));
	                grid[i][j-1] ='0';
	            }
	            
	        }
	        
	    }
	    
	}

}

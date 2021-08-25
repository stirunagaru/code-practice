package programs;

import java.util.LinkedList;

public class NumberOfIslands {
	    class Coordinate {
	        int i; int j;
	        public Coordinate(int a, int b) { i = a;j = b; }
	    }

	    public int numIslands(char[][] grid) {
	        int islandCount = 0;
	        for(int i=0; i< grid.length; i++) {
	            for(int j=0; j< grid[i].length; j++) {
	                if(grid[i][j] == '1') {
	                    // searchParty(grid, i, j);
	                    recursiveSearchParty(grid, i, j);
	                    islandCount++;                
	                }
	            }
	        }
	        return islandCount;
	    }
	    
	    
	    private void searchParty(char[][] grid, int x, int y) {
	        grid[x][y] = '0'; // mark it with 0 so that we dont visit it twice.
	        LinkedList<Coordinate> q = new LinkedList<>();
	        q.offer(new Coordinate(x, y));
	        
	        while(!q.isEmpty()) {
	            Coordinate co = q.poll();
	            int i = co.i;
	            int j = co.j;
	            
	            //up
	            if(i>0 && grid[i-1][j] == '1') {
	                q.offer(new Coordinate(i-1, j));
	                grid[i-1][j] ='0';
	            }
	            //down
	            if(i<grid.length-1 && grid[i+1][j] == '1') {
	                q.offer(new Coordinate(i+1, j));
	                grid[i+1][j] ='0';
	            }

	            //right
	            if(j<grid[0].length-1 && grid[i][j+1] == '1') {
	                q.offer(new Coordinate(i, j+1));
	                grid[i][j+1] ='0';
	            }
	            
	            //left
	            if(j>0 && grid[i][j-1] == '1') {
	                q.offer(new Coordinate(i, j-1));
	                grid[i][j-1] ='0';
	            }
	            
	        }
	        
	    }
	    
	    private void recursiveSearchParty(char[][] grid, int i, int j) {
	        if( i >= 0 && j >=0 && i <= grid.length-1 && j<=grid[0].length-1 && grid[i][j] == '1') {
	                grid[i][j]='0';
	                recursiveSearchParty(grid, i-1, j); //up
	                recursiveSearchParty(grid, i+1, j); //down
	                recursiveSearchParty(grid, i, j-1); //left
	                recursiveSearchParty(grid, i, j+1); //right
	        }
	    }
}

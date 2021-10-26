package intresting;

public class PerimeterIsland {
	 public int islandPerimeter(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;
	        // int perimeter = 0;
	        int land = 0;int adj = 0;
	        for(int i = 0; i < m; i++) {
	            for(int j =0; j <n ;j++) {
	                if(grid[i][j] == 1) {
	                    // perimeter = findPerimeter(grid, i, j, m, n);
	                    // perimeter += 4 - findPerimeterForCell(grid, i, j, m, n);
	                    land++;
	                    if (i < m - 1 && grid[i + 1][j] == 1) adj++; // count down neighbours
	                    if (j < n - 1 && grid[i][j + 1] == 1) adj++; // count right neighbours
	                }
	            }
	        }
//	      return perimeter;
	        return land*4 -adj*2;
	    }
	    int findPerimeterForCell(int[][] grid,int i, int j, int m, int n) {
	        int walls = 0;
	        // walls += i == 0 ? 0 : grid[i-1][j]+1;
	        // walls += j == 0 ? 0 : grid[i][j-1];
	        // walls += i == m-1 ? 0 : grid[i+1][j];
	        // walls += j == n-1 ? 0 : grid[i][j+1];
	        
	        walls +=  i > 0 && grid[i-1][j] == 1 ? 2 : 0; //up
	        walls +=  j > 0 && grid[i][j-1] == 1 ? 2 : 0; //lft
	        return walls;
	    }
	    
	    // int findPerimeterDFS(int[][] grid,int i, int j, int m, int n) {
	    //     if( i < 0 || i >= m || j < 0 || j >=n) return 1 ;
	    //     if(grid[i][j] == 0) return 1;
	    //     if(grid[i][j] == 2) return 0;
	    //     int count = 0;
	    //     grid[i][j] = 2;
	    //     count += findPerimeter(grid, i+1, j, m, n);
	    //     count += findPerimeter(grid, i-1, j, m, n);
	    //     count += findPerimeter(grid, i, j+1, m, n);
	    //     count += findPerimeter(grid, i, j-1, m, n);
	    //     return count;
	    // }
}

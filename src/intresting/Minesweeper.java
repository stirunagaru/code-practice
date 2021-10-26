package intresting;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {
	class Solution {
	    
//	     0 1 2 3 4                  
	//   0                             
	//   1   *   *
	//   2     *
	//   3   *   *
	//   4
	 
	// (2,2)
//	         (1,1) - (i-1, j-1)
//	         (1,3) - (i-1, j+1)
//	         (3,3) - (i+1, j+1)
//	         (3,1) - (i+1, j-1)
	        
//	         1,2     (i-1,j) //up 
//	         2,3     (i,j+1) //right
//	         3,2     (i+1, j) //down
//	         2,1     (i,j-1) //left
	    int[] dx = new int[]{0, -1, 0, 1, 1, -1, 1, -1};
	    int[] dy = new int[]{1, 0, -1, 0, 1, -1, -1, 1};
	    
	    public char[][] updateBoard(char[][] board, int[] click) {
	        int i = click[0];
	        int j = click[1];
	        if(board[i][j] == 'M') { board[i][j] = 'X'; return board; }
	        // bfs(board, i, j);   
	        dfs(board, i, j);   
	        return board;
	    }
	    
	    
	    void dfs(char[][] b, int i, int j) {
	        if(i < 0 || i > b.length || j < 0 || j > b[0].length || b[i][j] != 'E') return;
	        int bombs = getNumsOfMines(b, i, j);            
	        if(bombs == 0) { //if bombs are not found mark it with B and search along furthur
	            b[i][j] = 'B';
	            for(int z = 0; z < this.dx.length; z++) {
	                int nx = i+dx[z];
	                int ny = j+dy[z];
	                dfs(b, nx, ny);
	            }  
	        } else {
	            b[i][j] = (char)(bombs + '0'); // put the number if there are bombs
	        }
	    }
	    
	    void bfs(char[][] board, int i , int j) {
	        int m = board.length;
	        int n = board[0].length;

	        Queue<int[]> q = new LinkedList<>();
	        boolean[][] visited = new boolean[m][n];
	        
	        q.offer(new int[] {i, j});
	        visited[i][j] = true;
	        
	        while(!q.isEmpty()) {
	            int[] cur = q.poll();
	            int x = cur[0], y = cur[1];
	            int bombs = getNumsOfMines(board, x,y);
	            
	            if(bombs == 0) { //if bombs are not found mark it with B and search along furthur
	                board[x][y] = 'B';
	                for(int z = 0; z < this.dx.length; z++) {
	                    int nx = x+dx[z];
	                    int ny = y+dy[z];
	                    
	                    if(nx >= 0 && nx < m && ny >=0 && ny < n && !visited[nx][ny] && board[nx][ny] == 'E'){
	                        q.offer(new int[]{nx, ny});
	                        visited[nx][ny] = true;
	                    }  
	                }
	            } else {
	                board[x][y] = (char)(bombs + '0'); // put the number if there are bombs
	            }
	        }
	    }
	    
	    
	    int getNumsOfMines(char[][] b, int x, int y) {
	        int num = 0;
	        for(int z = 0; z < this.dx.length; z++) {
	            int nx = x+dx[z];
	            int ny = y+dy[z];
	            
	            if(nx ==x && y== ny) continue;
	            
	            if(nx >= 0 && nx < b.length && ny >=0 && ny < b[0].length) {
	                if(b[nx][ny] == 'M') num++;
	            }
	        }
	        return num;
	    }
	}

}

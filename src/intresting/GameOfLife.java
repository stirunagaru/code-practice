package intresting;

public class GameOfLife {
//  is 1 and 1s < 2  - 0
//is 1 and 1s == 2 || 3 - 1
//is 1 and 1s > 3 - 0
//is 0 and 1s == 3 - 1
 
//-1 0 1  0
//0 1 0 -1
 
//-1 1  1 -1    
//1 1 -1 -1
	public void gameOfLifeWithoutExtraSpace(int[][] board) {
	       int m = board.length;
	       int n = board[0].length;
	       int[] nb = {0, 1, -1};

	       for(int r = 0; r < m ; r++) {
	          for(int c = 0; c < n ; c++) {
	              int lives = 0;
	              for(int i = 0; i < 3 ; i++) {
	                for(int j = 0; j < 3 ; j++) {
	                     if(! (nb[i] == 0 && nb[j] ==0)) {
	                        int rnb = r + nb[i];
	                        int cnb = c + nb[j];
	                        if((rnb < m && rnb >= 0) && (cnb < n && cnb >= 0)
	                            && (board[rnb][cnb] == 1 || board[rnb][cnb] == -1))
	                               lives++; 
	                            }
	                        }
	                    } //for neighbors
	                if(board[r][c] == 1 && (lives < 2 || lives > 3)) board[r][c] = -1;
	                if(board[r][c] == 0 && lives == 3)  board[r][c] = 2;
	    
	            }
	        }
	        
	         for (int row = 0; row < m; row++) {
	            for (int col = 0; col < n; col++) {
	                if (board[row][col] > 0) board[row][col] = 1;
	                else board[row][col] = 0;
	                }
	            }
	        
	    }
	
	 public void gameOfLife(int[][] board) {
	       int m = board.length;
	       int n = board[0].length;
	       int[][] copy = new int[m][n];
	         for (int row = 0; row < m; row++) {
	            for (int col = 0; col < n; col++) {
	                copy[row][col] = board[row][col];
	            }
	        }
	        
	        
	       int[] nb = {0, 1, -1};

	        for(int r = 0; r < m ; r++) {
	            for(int c = 0; c < n ; c++) {
	                int lives = 0;
	                    for(int i = 0; i < 3 ; i++) {
	                        for(int j = 0; j < 3 ; j++) {
	                            if(! (nb[i] == 0 && nb[j] ==0)) {
	                                int rnb = r + nb[i];
	                                int cnb = c + nb[j];
	                                
	                                if((rnb < m && rnb >= 0) && (cnb < n && cnb >= 0)
	                                  && (copy[rnb][cnb] == 1))
	                                    lives++;
	                                
	                            }
	                        }
	                    } //for neighbors
	                if(copy[r][c] == 1 && (lives < 2 || lives > 3)) board[r][c] = 0;
	                if(copy[r][c] == 0 && lives == 3)  board[r][c] = 1;
	    
	            }
	        }
	    }
}

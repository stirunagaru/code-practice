package matrixproblems;

public class WordSearchInMatrix {
	 private int rows;
	    private int cols;
	    public boolean exist(char[][] board, String word) {
	        this.rows = board.length;
	        this.cols = board[0].length;
	        
	        for(int r =0 ; r < rows ; r++)
	            for(int c =0 ; c < cols ; c++)
	                if(board[r][c] == word.charAt(0) && backtrack(board, r, c, word, 0)) return true;
	        return false;
	    }
	    
	    boolean backtrack(char[][] board, int row, int col, String word, int index) {
	        if(index >= word.length()) return true;
	        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) return false;
	        
	        // mark the path before the next exploration
	        char temp = board[row][col];
	        board[row][col] = '#';
	        
	        if(backtrack(board, row-1, col, word, index+1) || 
	           backtrack(board, row+1, col, word, index+1) ||
	           backtrack(board, row, col-1, word, index+1) || 
	           backtrack(board, row, col+1, word, index+1)) {
	            return true;
	        }
	        
	        board[row][col] = temp;
	        return false;
	    }
}

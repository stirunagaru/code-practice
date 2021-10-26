package intresting;

public class ValidSudukoTraditional {
	
	//iterative
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9 ; row++) {
            for(int col = 0; col < 9 ; col++) {
                if(board[row][col] == '.') continue;
                if(!validGrid(board, 3*(row/3), 3*(col/3), board[row][col], row, col)) return false;
                if(!validRowCol(board, row, col, board[row][col])) return false;
            }
        }
        return true;
    }
   
    boolean validGrid(char[][] board, int rowStart, int colStart, char c, int i, int j) {
        for(int row = rowStart; row < rowStart+3 ; row++) {
            for(int col = colStart; col < colStart+3 ; col++) {
                if(row == i && col == j) continue;
                if(board[row][col] == c) return false;
          }
        }
        return true;
    }

    boolean validRowCol(char[][] board, int row, int col, char c) {
        for(int j = 0; j < 9; j++) {
            if(col != j  && board[row][j] == c) return false;
            if(row != j  && board[j][col] == c) return false;
        }
        return true;
    }
}
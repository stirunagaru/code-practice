package matrixproblems;

public class SearchMatri2DOII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
         int row = 0;
         int col = matrix[0].length-1;
        
         while(row < matrix.length && col >= 0) {
             if(target > matrix[row][col])
                 row++;
             else if(target < matrix[row][col])
                 col--;
             else 
                 return true;
         }
         return false;
    }
    }

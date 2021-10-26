package intresting;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrux {
	  public List<Integer> spiralOrder(int[][] m) {
	        
	        //initialize corner/boundaries
	        int top = 0;
	        int down = m.length-1;
	        int left = 0;
	        int right = m[0].length-1;
	        List<Integer> result = new ArrayList<>();
	        while(top <= down && left <= right) {
	            for(int col = left; col <= right; col++) { //forward
	                result.add(m[top][col]);
	            }
	            
	            for(int row = top+1; row <= down; row++) { //downward
	                result.add(m[row][right]);
	            }
	            
	            if(top != down) {
	                for(int col = right-1; col >= left; col--) { //backward
	                    result.add(m[down][col]);
	                }
	            }
	            
	            if(left != right) {
	                for(int row = down-1; row > top; row--) { //upward
	                    result.add(m[row][left]);
	                }       
	            }
	            top++; left++; down--; right--;
	        }
	        
	        
	        
//	        while(top <= down && left <= right) {
//	            for(int col = left; col <= right; col++) result.add(m[top][col]); //forward
//	            top++;
//	            
//	            if(top > down) break;
//	            
//	            for(int row = top; row <= down; row++) result.add(m[row][right]);  //downward
//	            right--;
//	            
//	            if(right < left) break;
//	            
//	            for(int col = right; col >= left; col--) result.add(m[down][col]); //backward
//	            down--;
//	            
//	            if(top > down) break;
//	            
//	            for(int row = down; row >= top; row--) result.add(m[row][left]); //upward
//	            left++;
//	            
//	            if(left > right) break;
//	            
//	        }
	        
	        return result;
	    }
}

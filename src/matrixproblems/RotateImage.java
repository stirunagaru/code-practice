package matrixproblems;

public class RotateImage {
	 public void rotate(int[][] m) {
	       if(m.length == 1) return;
	       int n = m.length;
	       for(int i = 0; i < n; i++) { //tranpose
	            for(int j = i; j < n; j++) {
	                if(i==j) continue;
	                m[i][j] = m[i][j]+m[j][i];
	                m[j][i] = m[i][j]-m[j][i];
	                m[i][j] = m[i][j]-m[j][i];
	            } 
	        }
	        for(int i = 0; i < n; i++) { //reverse element in every row 
	            for(int j = 0; j < n/2; j++) {                
	                m[i][j] = m[i][j] + m[i][n-1-j]; 
	                m[i][n-1-j] = m[i][j] - m[i][n-1-j];
	                m[i][j] = m[i][j] - m[i][n-1-j];
	            }
	        }
	    }
}

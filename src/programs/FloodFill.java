package programs;

import java.util.LinkedList;

//https://leetcode.com/problems/flood-fill/submissions/
public class FloodFill {
    class Point {
        int x; int y;
        public Point(int i, int j) {x=i;y=j;} 
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image; 
        int color = image[sr][sc];
        for(int i = sr; i < image.length; i++) {
            for (int j = sc; j < image[i].length; j++) {
                fillColorRecursive(image, i, j, newColor, color);
                // fillColor(image, i, j, newColor, color);
                        return image;
            }
        }
        return image;
    }
    
    private void fillColorRecursive(int[][] image, int i, int j, int newColor, int color) {
        if(i>=0 && j>=0 && i<=image.length-1 && j<=image[0].length-1 && image[i][j] == color) {
            image[i][j] = newColor;
            fillColorRecursive(image, i-1, j, newColor, color); //up
            fillColorRecursive(image, i+1, j, newColor, color); //down
            fillColorRecursive(image, i, j+1, newColor, color); //right
            fillColorRecursive(image, i, j-1, newColor, color); //left
        }
    }
    
    private void fillColor(int[][] image, int i, int j, int newColor, int color) {
        image[i][j] = newColor;
        LinkedList<Point> q = new LinkedList<>();
        q.offer(new Point(i,j));
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x; int y = p.y;
            if(x>0 && image[x-1][y] == color) {
                image[x-1][y] = newColor;
                q.offer(new Point(x-1,y));
            }
            
            if(x<image.length-1 && image[x+1][y] == color) {
                image[x+1][y] = newColor;
                q.offer(new Point(x+1,y));
            }
            
            if(y>0 && image[x][y-1] == color) {
                image[x][y-1] = newColor;
                q.offer(new Point(x,y-1));
            }
            if(y<image[0].length-1 && image[x][y+1] == color) {
                image[x][y+1] = newColor;
                q.offer(new Point(x,y+1));
            }
        }
    }
}

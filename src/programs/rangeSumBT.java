package programs;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/range-sum-of-bst/submissions/
public class rangeSumBT {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> inorder = new ArrayList<>();
        traverseTree(root, inorder);
         int sum = 0;
         for(int i=0; i< inorder.size(); i++) {
             // System.out.print(inorder.get(i)+ ",");
             if(inorder.get(i) >= low && inorder.get(i) <= high) sum += inorder.get(i);
         }
         return sum;
     }
     
     private void traverseTree(TreeNode root, List<Integer> inorder) {
         if(root != null) {
             traverseTree(root.left, inorder);
             inorder.add(root.val);
             traverseTree(root.right, inorder);
         }
     }
     
     public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
}

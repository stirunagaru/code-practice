package BinarySearchTrees;

import java.util.Stack;

public class ValidateBST {
	 class TreeNode {
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
	 private TreeNode prev = null;
	   
	    public boolean isValidBST(TreeNode root) {
	   if (root == null) return true;
	        // recursion
	        boolean left = isValidBST(root.left);
	        if (prev != null && root.val <= prev.val) return false;
	        prev = root;
	        boolean right = isValidBST(root.right);
	        return left && right;
	    }
	    Boolean  DFSInorder(TreeNode root) {
	         Stack<TreeNode> st = new Stack<>();
	         while(root != null || !st.isEmpty()) {
	             while(root != null) { //do deep the  left tree for inorder
	                 st.push(root);
	                 root = root.left;
	             }
	             root = st.pop();
	             if(prev != null && prev.val >= root.val) return false;
	             prev = root;
	             root = root.right;
	         }
	         return true;
	    }
}

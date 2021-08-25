package programs;

import java.util.LinkedList;
import java.util.Stack;

public class invertBSTree {
	
	public TreeNode invertTree(TreeNode root) {
        // return iterative(root);
        // return recursive(root);
        return dfs(root);
    }
    
    private TreeNode iterative(TreeNode actualRoot) { //BFS
        if(actualRoot == null) return null;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(actualRoot);
        while(!q.isEmpty()) {
            TreeNode root = q.poll();
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            if(root.left != null) q.offer(root.left);
            if(root.right != null) q.offer(root.right);
        }
        return actualRoot;
    }
    
    private TreeNode recursive(TreeNode root) {
        if(root == null) return null;
        TreeNode right = recursive(root.right);
        TreeNode left = recursive(root.left);
        root.right = left;
        root.left = right;
        return root;
    }
    
    
    private TreeNode dfs(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode current = st.pop();
            TreeNode left = current.left;
            current.left = current.right; current.right = left;
            if(current.left != null) st.push(current.left);
            if(current.right != null) st.push(current.right);
        }
        return root;
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

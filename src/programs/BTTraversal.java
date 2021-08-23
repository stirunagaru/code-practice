package programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                TreeNode current = st.pop();
                inorder.add(current.val);
                root = current.right;
            }
        }
        return inorder;        
    }

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
     List<Integer> inorder = new ArrayList<>();
     inorder(root, inorder);
     preorder(root, inorder);
     postorder(root, inorder);
     return inorder;
 }
 
    private void inorder(TreeNode root, List<Integer> order) {
        if(root == null) return;
        
        inorder(root.left, order);
        order.add(root.val);
        inorder(root.right, order);
    } 

    private void preorder(TreeNode root, List<Integer> order) {
        if(root == null) return;
        
        order.add(root.val);
        preorder(root.left, order);
        preorder(root.right, order);
    } 

    private void postorder(TreeNode root, List<Integer> order) {
        if(root == null) return;
        
        postorder(root.left, order);
        postorder(root.right, order);
        order.add(root.val);
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

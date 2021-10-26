package BinarySearchTrees;

import java.util.Stack;

public class BSTIterator {
//	    List<Integer> list  = new ArrayList<>();
//	    int pointer;
//
//	    public BSTIterator(TreeNode root) {
//	        inorder(root);
//	        pointer = 0;
//	    }
//	    
//	    void inorder(TreeNode root) {
//	        if(root == null) return;
//	        inorder(root.left);
//	        list.add(root.val);
//	        inorder(root.right);
//	    }
//	     
//	    public int next() {
//	        int val = list.get(pointer);
//	        pointer++;
//	        return val;
//	    }
//	    
//	    public boolean hasNext() {
//	        return pointer != list.size();
//	    }
//	    
	    Stack<TreeNode> s;

	    public BSTIterator(TreeNode root) {
	        s = new Stack<>();
	        leftElements(root);
	    }
	    
	    void leftElements(TreeNode root) {
	        while(root != null){
	            this.s.push(root);
	            root = root.left;
	        }
	    }
	     
	    public int next() {
	        TreeNode top = this.s.pop();
	        if(top.right != null) {
	            this.leftElements(top.right);
	        }
	        return top.val;
	    }
	    
	    public boolean hasNext() {
	        return !s.isEmpty();
	    }
}
package BinarySearchTrees;

import java.util.Stack;

public class BSTToDLL {
//	 	Node head;
	    Node head = null;
	    Node prev = null;
	    public Node treeToDoublyList(Node root) {
	        if(root == null ) return root;
	        recursive(root);
	        
	        head.left = prev;
	        prev.right = head;
	       return head;
	    }
	    
	    void recursive(Node link) {
	        if(link != null) {
	            recursive(link.left);
	            
	            if(prev == null) {
	                head = link;
	            } else {
	                prev.right = link; 
	                link.left =  prev;
	            }

	            prev = link;
	            
	            recursive(link.right);
	        }
	    }
//	    public Node treeToDoublyList(Node root) {
//	        if(root == null ) return root;
//	        head = new Node();
//	        Node prev = head;
//	       
//	       
//	        Stack<Node> st =  new Stack<>();
//	        
//	       
//	        
//	        while(root != null || !st.isEmpty()) {
//	             while(root != null){
//	                st.push(root);
//	                root = root.left;
//	            }
//
//	            root = st.pop();
//	            
//	            prev.right = root;
//	            root.left = prev;
//	            
//	            prev = root;
//	            root = root.right;
//	         }
//	        
//	        
//	        head.right.left = prev;
//	        prev.right = head.right;
//	        return head.right;
//	    }
	    

	 // Definition for a Node.
	 class Node {
	     public int val;
	     public Node left;
	     public Node right;

	     public Node() {}

	     public Node(int _val) {
	         val = _val;
	     }

	     public Node(int _val,Node _left,Node _right) {
	         val = _val;
	         left = _left;
	         right = _right;
	     }
	 };

}

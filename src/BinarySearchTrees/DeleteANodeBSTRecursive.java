package BinarySearchTrees;

public class DeleteANodeBSTRecursive {
	 public TreeNode deleteNode(TreeNode root, int key) {
	        if(root == null) return root;
	        if(key < root.val) root.left = deleteNode(root.left, key);  //inorder
	        else if( key > root.val) root.right = deleteNode(root.right, key);
	        else //found the key
	        {
	            if(root.left == null) { //only right child is present
	                return root.right;
	            } else if(root.right == null) { //only left child is present
	                return root.left;
	            } else { //both children present, find min value in inorder successor minVal
	            	
	            	//successor of the node(minVal of rightSubTree)
	            	
	                // root.val = getMinFromRightSubtree(root.right);
	                // root.right = deleteNode(root.right, root.val);
	            	
	            	//find predecessor of the node(maxVal of leftSubTree)
	                root.val = getMaxFromLeftSubtree(root.left);
	                root.left = deleteNode(root.left, root.val);

	            }
	        }
	        return root;
	    }
	 
	    
	    int getMinFromRightSubtree(TreeNode root) {
	        while(root.left != null) root = root.left;
	        return root.val;
	    }
	    
	     int getMaxFromLeftSubtree(TreeNode root) {
	        while(root.right != null) root = root.right;
	        return root.val;
	    }
	     
}

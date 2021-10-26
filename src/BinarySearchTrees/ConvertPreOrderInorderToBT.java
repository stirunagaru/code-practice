package BinarySearchTrees;

import java.util.HashMap;
import java.util.Map;

public class ConvertPreOrderInorderToBT {
	  int preorderIndex;
	    Map<Integer, Integer> iomap;

	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        preorderIndex = 0;
	        iomap = new HashMap<>();
	        for(int i = 0; i < inorder.length; i++) {
	            iomap.put(inorder[i], i);
	        }
	        return arrToTree(preorder, 0, preorder.length -1);
	    }
	    
	    TreeNode arrToTree(int[] pre, int l, int r) {
	        if(l > r)
	            return null;
	        int rootVal = pre[preorderIndex++];
	        TreeNode root = new TreeNode(rootVal);
	        
	        root.left  = arrToTree(pre, l, iomap.get(rootVal) - 1);
	        root.right = arrToTree(pre, iomap.get(rootVal) + 1, r);
	        return root;
	    }
}

package codec;

import BinarySearchTrees.TreeNode;
//https://leetcode.com/problems/serialize-and-deserialize-bst/
public class BST {
	 void preorder(TreeNode root, StringBuilder sb) { // preOrder
	        if(root == null) return;
	        sb.append(",");
	        sb.append(root.val);
	        preorder(root.left, sb);
	        preorder(root.right, sb);
	    }

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        StringBuilder serialize =  new StringBuilder();
	        preorder(root, serialize);
	        return serialize.length()> 0 ? serialize.deleteCharAt(0).toString(): serialize.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        if (data == null || data.length() == 0) {
	            return null;
	        }
	        String[] arr = data.split(",");
	        TreeNode root = null;
	        for (String s : arr) {
	            if (s.length() > 0) root = buildBST(root, Integer.parseInt(s));
	        }
	        return root;
	    }

	    public TreeNode buildBST(TreeNode root, int v) {
	        if (root == null) return new TreeNode(v);
	        if (v < root.val) root.left = buildBST(root.left, v);
	        else root.right = buildBST(root.right, v);
	        return root;
	    }
}

package treeproblems;

import java.util.ArrayList;
import java.util.List;

import BinarySearchTrees.TreeNode;

//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]

public class ZigZagTraversal {
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        if(root == null) return new ArrayList<>();
	        List<List<Integer>> results = new ArrayList<>();

	        List<TreeNode> q = new ArrayList<>();
	        q.add(root);
	        // int level = 0;
	        boolean even = true;        
	        while(!q.isEmpty()) {
	            int n = q.size();
	            List<Integer> l = new ArrayList<>();
	            while(n-- > 0) {
	                TreeNode node = q.remove(0); 
	                // if(level % 2 == 0) {
	                if(even) {
	                    l.add(node.val);
	                } else {
	                    l.add(0, node.val);
	                }
	                
	                if(node.left !=null) q.add(node.left);
	                if(node.right !=null) q.add(node.right);
	                // n--;
	            }
	            results.add(l);
	            // level++;
	            even = !even;
	        }
	        return results;

	        //TwoStacks
//	         Stack<TreeNode> lToR = new Stack<>();
//	         Stack<TreeNode> rToL = new Stack<>();
	        
//	         lToR.push(root);
//	         while(!lToR.isEmpty() || !rToL.isEmpty()) {
//	             List<Integer> level = new ArrayList<>();
//	             while(!lToR.isEmpty()) {
//	                 TreeNode node = lToR.pop();
//	                 level.add(node.val);
//	                 if(node.left != null) rToL.push(node.left);
//	                 if(node.right != null) rToL.push(node.right);
//	             }
//	             results.add(level);
//	             level = new ArrayList<>();
//	             while(!rToL.isEmpty()) {
//	                 TreeNode node = rToL.pop();
//	                 level.add(node.val);
//	                 if(node.right != null) lToR.push(node.right);
//	                 if(node.left != null) lToR.push(node.left);
//	             }
//	             if(!level.isEmpty()) results.add(level);
//	         }
//	         return results;
	        


	        
	    }
}

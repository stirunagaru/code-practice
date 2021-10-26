package treeproblems;

import java.util.Stack;

import BinarySearchTrees.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.right, root.left);
        // return isMirrorIterative(root);

     }
     
     boolean isMirror(TreeNode r, TreeNode l) {
         if(r== null && l == null) return true;
         if(r == null || l == null) return false;
         return r.val == l.val &&
             isMirror(r.right, l.left) &&
             isMirror(r.left, l.right);
     }
     
     boolean isMirrorIterative(TreeNode root) {
         if(root==null)  return true;
         Stack<TreeNode> s = new Stack<TreeNode>();
         s.push(root.left);
         s.push(root.right);
         while(!s.isEmpty()) {
             TreeNode t1 = s.pop();
             TreeNode t2 = s.pop();
             if(t1 == null && t2 == null) continue;
             if(t1 == null || t2 == null || t1.val != t2.val) return false;
             s.push(t1.left);
             s.push(t2.right);
             s.push(t1.right);
             s.push(t2.left);
         }
         return true;
     }
}

package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    List<Integer> nodes = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return nodes;
        nodes.add(root.val);
        if (isLeaf(root))  return nodes;
        leftBound(root.left); //left Boundary
        leaves(root);
        rightBound(root.right); //right Boundary in reverse  
        return nodes;
    }

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }
    
    private void leftBound(TreeNode root) {
        if(root ==  null || isLeaf(root)) return;
        nodes.add(root.val);
        if(root.left == null) leftBound(root.right);
        else leftBound(root.left);
    }
        
    private void rightBound(TreeNode root) {
        if(root ==  null || isLeaf(root)) return;
        if(root.right == null) rightBound(root.left);
        else rightBound(root.right);
        nodes.add(root.val);
    }
    
    private void leaves(TreeNode root) {
        if(root == null) return;
        if(isLeaf(root)) {
            nodes.add(root.val); return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}

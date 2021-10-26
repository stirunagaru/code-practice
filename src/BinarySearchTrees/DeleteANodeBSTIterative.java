package BinarySearchTrees;

public class DeleteANodeBSTIterative {
	public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = root, parent = null;
        while(target != null && target.val != key) {
            parent = target;
            if(target.val > key) target = target.left;
            else target = target.right;
        }
        
        //not found
        if(target == null) return root;
        
        //case 1 no children:
        if(target.left == null && target.right == null) {
            if(parent == null) return null;
            if(target == parent.right) parent.right = null;
            else parent.left = null;
            return root;
        }
        
        //case 2: one child
        //case 2.1 no right child
        
        if(target.right == null) {
            if(parent == null) return target.left; //target node is root itself
            if(target == parent.left) parent.left = target.left;
            else parent.right = target.left;
            return root;
        }
        
        
        //case 2.1 no right child
        
        if(target.left == null) {
            if(parent == null) return target.right; //target node is root itself
            if(target == parent.left) parent.left = target.right;
            else parent.right = target.right;
            return root;
        }
        
        
        //case 3: target has both childs
        
        // if it has both childs, we can replace the leftmost element from its right subtree or righmost element from its left subtree
        
        TreeNode prev = target;
        TreeNode replace = target.right;
        while(replace.left != null) {
            prev = replace;
            replace = replace.left;
        }
        
        target.val = replace.val;
        
        if(prev.right == replace) prev.right = replace.right;
        else prev.left = replace.right;
        return root;
    }
}

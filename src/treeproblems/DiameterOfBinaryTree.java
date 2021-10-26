package treeproblems;

import BinarySearchTrees.TreeNode;

public class DiameterOfBinaryTree {
int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        // findLongestPath(root);
        traverse(root);
        return diameter;
    }
    
//     private void findLongestPath(TreeNode root) {
//         st.push(root);
//         while(!st.isEmpty()) {
//             TreeNode current = st.peek();
//             if(current.left != null && !nodePath.containsKey(current.left)) {
//                 st.push(current.left);
//             } else if(current.right != null && !nodePath.containsKey(current.right)) {
//                 st.push(current.right);
//             } else {
//                 TreeNode nodeToProcess = st.pop();
//                 int left = nodePath.getOrDefault(nodeToProcess.left, 0);
//                 int right = nodePath.getOrDefault(nodeToProcess.right, 0);
//                 int maxNodeDepth = 1 + Math.max(left, right);
//                 nodePath.put(nodeToProcess, maxNodeDepth);
//                 diameter = Math.max(diameter, left + right);
//             }  
//         }
        
//     }
    
    
    private int traverse(TreeNode root) {
        if(root == null) return 0;
        
//         int left  = traverse(root.left);
//         int right = traverse(root.right);

        int left = root.left == null ? 0 : traverse(root.left) + 1;
        int right = root.right == null ? 0 : traverse(root.right) + 1;
        
        diameter = Math.max(diameter, left + right);
        
        return Math.max(left, right);
        
        // return Math.max(left, right) + 1;
    }
}

package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

import programs.ListNode;

public class ConvertSortedListToBST {
    ListNode head= null;
    
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return build(list, 0, list.size() - 1);
    }
    
    TreeNode build(List<Integer> list, int l, int h) {
        if (l > h) {
            return null;
        }
        int m = l + (h-l) / 2;
        TreeNode root = new TreeNode(list.get(m));
        root.left = build(list, l, m - 1);
        root.right = build(list, m + 1, h);
        return root;
    }
    
    int findLength(ListNode node) {
        int c = 0;
        ListNode ptr = node;
        while(ptr != null) {
            ptr = ptr.next;
            c++;
        }
        return c;
    }
    
    public TreeNode sortedListToBSTInorderWay(ListNode head) {
        if(head == null)
            return null;
        int val = findLength(head);
        this.head = head;
        return formBST(0, val-1);
    }
    
    TreeNode formBST(int l, int h) {
        if(l > h)
            return null;
        int mid = (l+h)/2;
        
        TreeNode left = formBST(l, mid-1);
        
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        
        head = head.next;
    
        node.right = formBST(mid+1, h);
        
        return node;
    }
    
    public TreeNode sortedListToBSTLLWAY(ListNode head) {
        if(head == null)
            return null;
        
        ListNode mid = middleNode(head);
        TreeNode node = new TreeNode(mid.val);
        
        if(head == mid)
            return node;
        
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }
    
    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(prev != null) //disocnnect left side
            prev.next = null;
        return slow;
    }
}

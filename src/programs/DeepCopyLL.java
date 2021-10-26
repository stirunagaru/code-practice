package programs;

public class DeepCopyLL {
    // HashMap<Node, Node> visited = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node dups = head;
        while(dups != null) {
            Node next = dups.next;
            dups.next = new Node(dups.val);
            dups.next.next = next;
            dups = next;
        }
        
        dups = head;
        while(dups != null) {
            if(dups.random != null) dups.next.random = dups.random.next;
            dups = dups.next.next;
        }
        
        dups = head;
        Node copyHead = dups.next;
        Node tempNode = copyHead;
        while(tempNode.next != null) {
            dups.next = dups.next.next;
            dups = dups.next;
            
            tempNode.next = tempNode.next.next;
            tempNode = tempNode.next;
        }
            dups.next = dups.next.next;
        return copyHead;
        
        
        
        
        
        
        
        
//         Node cur = head;
//         while(cur != null) {
//             visited.put(cur, new Node(cur.val));
//             cur=cur.next;
//         }
        
//         for(Map.Entry<Node, Node> entry : visited.entrySet()) {
//             Node node = entry.getValue();
//             node.next =   visited.get(entry.getKey().next);
//             node.random = visited.get(entry.getKey().random);
//         }
//         return visited.get(head);
        
        
//         Node old = head;
//         Node newNode = new Node(old.val);
//         this.visited.put(old, newNode);
        
//         while( old != null) {
//             newNode.random = this.getClonedNode(old.random);
//             newNode.next = this.getClonedNode(old.next);
            
//             old = old.next;
//             newNode = newNode.next;
//         }
//        return this.visited.get(head); 
    }
    
    
//     Node getClonedNode(Node n) {
//         if(n == null) return null;
        
//         if(this.visited.containsKey(n)) return this.visited.get(n);
//         this.visited.put(n, new Node(n.val));
//         return this.visited.get(n);
//     }
    
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

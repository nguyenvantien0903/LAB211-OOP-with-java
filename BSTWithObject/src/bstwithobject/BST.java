
package bstwithobject;

/**
 *
 * @author NVT
 */
public class BST {
    private Node root;
    //// BST sap xep theo Id
    public BST(){
        root = null;
    }

    public void insert(SomeObject data){
        root = insert(root, data);
    }

    public Node insert(Node node, SomeObject data){
        if (node == null)
            node = new Node(data);
        else
        {
            if (data.getId() <= node.data.getId())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public void inorder(){
        inorder(root);
    }

    public void inorder(Node r){
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data.getId() +" ");
            inorder(r.right);
        }
    }

    public void preorder(){
        preorder(root);
    }
    
    public void preorder(Node r){
        if (r != null)
        {
            System.out.print(r.data.getId() +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    
    public void postorder(){
        postorder(root);
    }
    
    public void postorder(Node r){
        if (r != null)
        {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data.getId() +" ");
        }
    }     
 
    public boolean search(SomeObject data)  { 
        root = search_Recursive(root, data); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    public Node search_Recursive(Node node, SomeObject data)  { 
        if (node==null || node.data.getId()==data.getId()) 
            return node; 
        if (node.data.getId() > data.getId()) 
            return search_Recursive(node.left, data); 
        return search_Recursive(node.right, data); 
    } 
    
    public void delete(SomeObject data) { 
        root = delete_Recursive(root, data); 
    } 
   
    public Node delete_Recursive(Node node, SomeObject data)  { 
        if (node == null)  return node; 
   
        if (data.getId() < node.data.getId())     //traverse left subtree 
            node.left = delete_Recursive(node.left, data); 
        else if (data.getId() > node.data.getId())  //traverse right subtree
            node.right = delete_Recursive(node.right, data); 
        else  { 
            if (node.left == null) 
                return node.right; 
            else if (node.right == null) 
                return node.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            node.data.setId(minValue(node.right)); 
   
            // Delete the inorder successor 
            node.right = delete_Recursive(node.right, node.data); 
        } 
        return node; 
    } 
    
    int minValue(Node node)  { 
        //initially minval = root
        int minval = node.data.getId(); 
        //find minval
        while (node.left != null)  { 
            minval = node.left.data.getId(); 
            node = node.left; 
        } 
        return minval; 
    } 
    
    int maxValue(Node node)  { 
        //initially minval = root
        int maxval = node.data.getId(); 
        //find minval
        while (node.right != null)  { 
            maxval = node.right.data.getId(); 
            node = node.right; 
        } 
        return maxval; 
    }
    
    public Node deleteByMerging(Node node, SomeObject data) {
        // if this node is null, we have reached the end of the tree
        // so the node is not in the tree.
        if (node == null) {
            return node; // or handle as required
        }
        // if this is not the node to delete;
        // recursively call this on the node's correct child
        if (data.getId() < node.data.getId()) {
            node.left = deleteByMerging(node.left, data);
            return node;
        }
        if(data.getId() > node.data.getId()){
            node.right = deleteByMerging(node.right, data);
            return node;
        }
        // if this is the node to delete:
        if (data.getId() == node.data.getId()){
            // to delete it, we must return a sub-tree without it.
            if (node.left == null) 
                // this node is a leaf node, or
                // node.right contains only child.
                // either way, return node.right
                return node.right;
            if (node.right == null) 
                // node.left contains only child
                return node.left;

            // else node has 2 children, so delete by merging:
            // first, find its direct predecessor:
            Node tmp = node.left;
            while (tmp.right != null)
                tmp = tmp.right;
            // then append the node's right sub-tree
            // to its direct predecessor:
            tmp.right = node.right;
            // lastly, replace the node by its left sub-tree:
            return node.left;
        }
        return null;
    }
    
    public void BFS(){
//        if (root == null) {
//            return;
//        }
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node node = q.remove();
//            System.out.print(" " + node.data);
//
//            if (node.left != null) {
//                q.add(node.left);
//            }
//            if (node.right != null) {
//                q.add(node.right);
//            }
//        }
        if (root == null) {
            return;
        }
        QueueUsingLinkedlist q = new QueueUsingLinkedlist();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node node = q.dequeue();
            System.out.print(" " + node.data.getId());
            if (node.left != null) {
//                System.out.println(node.left.data);
                q.enqueue(node.left);
            }
            if (node.right != null) {
//                System.out.println(node.right.data);
                q.enqueue(node.right);
            }
        }
    }
}
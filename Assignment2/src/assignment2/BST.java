
package assignment2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author NVT
 */
public class BST {
    private Node root;
    int supercheck=0;
    //// BST sap xep theo Id
    public BST(){
        root = null;
    }

    public void insert(Person data){
        root = insert(root, data);
    }

    public Node insert(Node node, Person data){
        if (node == null)
            node = new Node(data);
        else
        {
            if (data.getName().compareToIgnoreCase(node.data.getName())<0)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
//
//    public void inorder(){
//        inorder(root);
//    }
//
//    public void inorder(Node r){
//        if (r != null)
//        {
//            inorder(r.left);
//            System.out.print(r.data.getId() +" ");
//            inorder(r.right);
//        }
//    }
//
    public void preorder(){
        preorder(root,null);
    }
    
    public void preorder(Node r,Node father){
        if (r != null)
        {
            if(r!=root&&r.right!=null&&supercheck==0){
                Node y=r.right;
                Node T2=y.left;
                father.left=y;
                y.left=r;
                r.right=T2;
                r=y;
                supercheck=1;
            }
            System.out.print("("+r.data.getName() +","+r.data.getAge()+") ");
            preorder(r.left,r);             
            preorder(r.right,r);
        }
    }
    
    public void postorder(FileWriter file) throws IOException{
        postorder(root,file);
    }
    
    public void postorder(Node r,FileWriter file) throws IOException{
        if (r != null)
        {
            postorder(r.left,file);             
            postorder(r.right,file);
            String res="("+r.data.getName() +","+r.data.getAge()+") ";
            file.append(res);
//            System.out.println(r.data.getName() +" "+r.data.getAge());
        }
    }     
// 
//    public boolean search(Person data)  { 
//        root = search_Recursive(root, data); 
//        if (root!= null)
//            return true;
//        else
//            return false;
//    } 
//   
//    public Node search_Recursive(Node node, Person data)  { 
//        if (node==null || node.data.getId()==data.getId()) 
//            return node; 
//        if (node.data.getId() > data.getId()) 
//            return search_Recursive(node.left, data); 
//        return search_Recursive(node.right, data); 
//    } 
//    
    public void delete(Person data) { 
        root = delete_Recursive(root, data); 
    } 
   
    public Node delete_Recursive(Node node, Person data)  { 
        if (node == null)  return node; 
   
        if (data.getName().compareToIgnoreCase(node.data.getName())<0)     //traverse left subtree 
            node.left = delete_Recursive(node.left, data); 
        else if (data.getName().compareToIgnoreCase(node.data.getName())>0)  //traverse right subtree
            node.right = delete_Recursive(node.right, data); 
        else  { 
            if (node.left == null) 
                return node.right; 
            else if (node.right == null) 
                return node.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            node.data.setName(minValue(node.right)); 
   
            // Delete the inorder successor 
            node.right = delete_Recursive(node.right, node.data); 
        } 
        return node; 
    } 
    
    String minValue(Node node)  { 
        //initially minval = root
        String minval = node.data.getName(); 
        //find minval
        while (node.left != null)  { 
            minval = node.left.data.getName(); 
            node = node.left; 
        } 
        return minval; 
    } 

    public void BFS(FileWriter file,double avgAge) throws IOException{
        QueueUsingLinkedlist q = new QueueUsingLinkedlist();
        q.enqueue(root);
        int check=0;
        while (!q.isEmpty()) {
            Node node = q.dequeue();
            if(node.left!=null&&node.right!=null&&node.data.getAge()>=avgAge&&check==0){
                delete(node.data);
                check=1;
            }
            String res="("+node.data.getName()+","+node.data.getAge()+") ";
            file.write(res);
            if (node.left != null) {
                q.enqueue(node.left);
            }
            if (node.right != null) {
                q.enqueue(node.right);
            }
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

/**
 *
 * @author NVT
 */
public class main {
    public static void main(String[] args) {
        AVL tree = new AVL();
 
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder(tree.root);
        System.out.println("");
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.inorder(tree.root);
        System.out.println("");
        System.out.println("Postorder traversal of constructed tree is : ");
        tree.postorder(tree.root);
        System.out.println("");
        tree.root = tree.deleteNode(tree.root, 20);
        
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder(tree.root);
        System.out.println("");
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.inorder(tree.root);
        System.out.println("");
        System.out.println("Postorder traversal of constructed tree is : ");
        tree.postorder(tree.root);
        System.out.println("");

    }
}


package bstwithobject;

import java.util.Scanner;

/**
 *
 * @author NVT
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST bst = new BST(); 
        System.out.println("Linked List Binary Search Tree Test\n");          
        String ch;
        do    
        {
            System.out.println("Enter integer element to insert");
            System.out.println("ID:");
            int id=Integer.parseInt(scan.nextLine());
            System.out.println("Name:");
            String name=scan.nextLine();
            System.out.println("Magic:");
            String magic=scan.nextLine();
            bst.insert(new SomeObject(id,name,magic));                     
            /*  Display tree  */ 
            System.out.print("\nPost order : ");
            bst.postorder();
            System.out.print("\nPre order : "); 
            bst.preorder();
            System.out.print("\nIn order : ");
            bst.inorder();
            System.out.print("\nBFS : ");
            bst.BFS();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.nextLine();                        
        } while (ch.equals("Y")|| ch.equals("y"));    
    }
}

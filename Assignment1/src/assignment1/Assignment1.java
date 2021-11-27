
package assignment1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author NVT
 */
public class Assignment1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        LinkedList list = new LinkedList();
        //task1
        list.readFromFile("src/assignment1/product.txt");
        //task2
        list.traverse();
        //task3
        list.sort();
        list.traverse();
        //task4
        list.addProduct();
        //task5
        list.saveToFile("src/assignment1/output.txt");
        //task6
        list.remodeDuplicateProduct();
        list.traverse();
    }
    
}

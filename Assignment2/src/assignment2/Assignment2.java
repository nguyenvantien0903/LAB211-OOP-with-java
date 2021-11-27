
package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author NVT
 */
public class Assignment2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ////Q1
        Scanner fileScan = new Scanner(new File("person.txt"));
        BST tree= new BST();
        int sumAge=0,num=0;
        while(fileScan.hasNextLine()){
            String[] temp=fileScan.nextLine().split("[\\| ]+");
            if(temp[0].toUpperCase().contains("B"))continue;
            tree.insert(new Person(temp[0],Integer.parseInt(temp[1])));
            sumAge+=Integer.parseInt(temp[1]);
            num++;
        }
        fileScan.close();
        /////Q2
        FileWriter fileWriter = new FileWriter("q2.out");
        tree.postorder(fileWriter);
        fileWriter.close();
        /////Q3 em copy bang phan tu nho nhat cay con ben phai nen dap an khac vi du 
        double avgAge=sumAge*1.0/num;
        System.out.println("avgAge="+avgAge);
        FileWriter fileWriter2 = new FileWriter("q3.txt");
        tree.BFS(fileWriter2,avgAge);
        fileWriter2.close();
        /////Q4
        tree.preorder();
    }
    
}

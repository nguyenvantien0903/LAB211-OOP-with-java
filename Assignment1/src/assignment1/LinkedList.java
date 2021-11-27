package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class LinkedList {    
    public Node head = null;    
    public Node tail = null;   
    
    void readFromFile(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String temp[]=sc.nextLine().split("\\|");
            Product newPerson=new Product(temp[0],Double.parseDouble(temp[1]),Integer.parseInt(temp[2].trim()));
            addToTail(newPerson);
        }
    }
    
    void saveToFile(String filename) throws FileNotFoundException, IOException{
        FileWriter myWriter = new FileWriter(filename);
        Node current = head;    
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }       
        while(current != null) {    
            myWriter.write(current.data.toString());
            myWriter.write("\n");
            current = current.next;    
        }    
        myWriter.close();
    }
        
    public void addToHead(Product x) {    
        Node newNode = new Node(x);    
        if(head == null) {    
            head = newNode;    
            tail = newNode;    
        }    
        else {
            newNode.next=head;
            head=newNode;
        }    
    }  
    
    public void addToTail(Product x) {    
        Node newNode = new Node(x);    
        if(tail == null) {    
            head = newNode;    
            tail = newNode;    
        }    
        else {
            tail.next = newNode;    
            tail = newNode;  
        }    
    }
   
    public void remodeDuplicateProduct(){
        Node current = head;    
        Node previous = null;
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }   
        sort();
        while(current != null) {    
            Node next=current.next;
            if(next==null)return;
            if(next.data.getName().equals(current.data.getName())){
                if(next.data.getTotalValue().compareTo(current.data.getTotalValue())>=1){
                    previous.next=next;
                    current=next;
                }else{
                    current.next=next.next;
                }
            }
            previous=current;
            current=current.next;
        }
    }
    
    public void traverse() {    
        Node current = head;    
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("**Nodes of singly linked list: ");    
        while(current != null) {    
            System.out.println(current.data.toString());    
            current = current.next;    
        }    
        System.out.println();    
    }    
    
    public void addProduct(){
        Scanner sc = new Scanner(System.in);
        String name;
        double price;
        int quantity;
        System.out.println("Input name:");
        name=sc.nextLine().trim();
        System.out.println("Input price:");
        price=Double.parseDouble(sc.nextLine().trim());
        System.out.println("Input quantity:");
        quantity=Integer.parseInt(sc.nextLine().trim());
        Product temp=new Product(name,price,quantity);
        addToTail(temp);
        sort();        
    }

    public void sort(){
        Node current = head, index = null;
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.data.compare(index.data)>=1) {
                        current.data.swap(index.data);
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}

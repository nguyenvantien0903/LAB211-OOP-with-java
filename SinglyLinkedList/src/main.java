
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NVT
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        newLinkedList list = new newLinkedList();
        list.readFromFile("src/temp.txt");
        list.traverse();
        list.dele(20);
        list.traverse();
        ////////////// first 5 person with age >22
        Node current = list.head;  
        int cnt=5;
        if(list.head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("**first 5 person with age >22: ");    
        while(current != null&&cnt!=0) {
            if(current.data.getAge()>22){
                System.out.print(current.data.toString());        
                cnt--;
            }
            current = current.next;
        }    
        System.out.println();
        /////////////// second max age and display first person
        current = list.head;  
        if(list.head == null) {    
            System.out.println("List is empty");    
            return;    
        }   
        int maxAge=current.data.getAge();
        int secondAge=0;
        while(current != null) {
            if(current.data.getAge()>maxAge){
                secondAge=maxAge;
                maxAge=current.data.getAge();
            }
            current = current.next;
        } 
        System.out.println("Second Age: "+secondAge);
        current = list.head;
        while(current != null) {
            if(current.data.getAge()==secondAge){
                System.out.println(current.data);
                break;
            }
            current = current.next;
        } 
        //////////////
//        list.sort();
        list.traverse();
        //////////////last 5 person with age >22 
        newLinkedList temp = new newLinkedList();
        current = list.head;  
        cnt=0;
        if(list.head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("**last 5 person with age >22: ");    
        while(current != null) {
            if(current.data.getAge()>22){
                temp.addToTail(current.data);
                cnt++;
                if(cnt==6){
                    temp.deleteFromHead();
                    cnt--;
                }
            }
            current = current.next;
        }    
        System.out.println();
        temp.traverse();
        ///////////third age
//        list.sort();
////        list.traverse();
//        current = list.head;  
//        cnt=0;
//        if(list.head == null) {    
//            System.out.println("List is empty");    
//            return;    
//        }    
//        System.out.println("**Third Age ");    
//        while(current != null) {
//            if(cnt==2){
//                System.out.println(current.data.getAge());
//                break;
//            }
//            cnt++;
//            current = current.next;
//        }    
        //////////// delete last node =20   
    }
}

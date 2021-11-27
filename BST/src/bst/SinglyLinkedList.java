package bst;

import static java.lang.System.exit;

public class SinglyLinkedList {    
    public NodeList head = null;    
    public NodeList tail = null;    
        
    public void addToHead(Node data) {    
        NodeList newNode = new NodeList(data);    
        if(head == null) {    
            head = newNode;    
            tail = newNode;    
        }    
        else {
            newNode.next=head;
            head=newNode;
        }    
    }  
    
    public void addToTail(Node data) {    
        NodeList newNode = new NodeList(data);    
        if(tail == null) {    
            head = newNode;    
            tail = newNode;    
        }    
        else {
            tail.next = newNode;    
            tail = newNode;  
        }    
    }
    
    public int deleteFromHead(){
        int temp;
        if (head == null){
            System.out.println("no head 4 u");
            return -1;
        }else{
            temp=head.data.data;
            if (head == tail) {
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
        }
        return temp;
    }

    public int count(){
        NodeList current = head;
        int res=0;
        if(head == null) {    
//            System.out.println("List is empty");    
            return 0;    
        }    
        while(current != null) {    
            res++;
            current=current.next;
        }
        return res;
    }
}

class QueueUsingLinkedlist {
    SinglyLinkedList sList = new SinglyLinkedList();  

    public void enqueue(Node x){
        sList.addToTail(x);
    }
    
    public void clear(){
        sList.head=null;
        sList.tail=null;
    }
 
    public boolean isEmpty(){
        return sList.count() == 0;
    }
 
    public Node first(){
        if (sList.count() == 0) {
            System.out.print("\nQueue Underflow");
        }
        NodeList temp=sList.head;
        return temp.data;
    }
 
    public Node dequeue(){
        if (sList.count() == 0) {
            System.out.print("\nQueue Underflow");
        }
        NodeList temp=sList.head;
        sList.deleteFromHead();
        return temp.data;
    }
 
}
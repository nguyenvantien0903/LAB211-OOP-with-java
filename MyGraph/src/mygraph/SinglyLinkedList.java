
package mygraph;

import static java.lang.System.exit;


public class SinglyLinkedList {    
    public Node head = null;    
    public Node tail = null;    
        
    public void addToHead(int data) {    
        Node newNode = new Node(data);    
        if(head == null) {    
            head = newNode;    
            tail = newNode;    
        }    
        else {
            newNode.next=head;
            head=newNode;
        }    
    }  
    
    public void addToTail(int data) {    
        Node newNode = new Node(data);    
        if(tail == null) {    
            head = newNode;    
            tail = newNode;    
        }    
        else {
            tail.next = newNode;    
            tail = newNode;  
        }    
    }
    
    public void addAfter(Node p, int x){
        if(p==null){
            System.out.println("node is not exist");
            return;
        }
        Node newNode = new Node(x);
        newNode.next=p.next;
        p.next=newNode;
//        Node current = head;
//        Node newNode = new Node(x);
//        if(head == null) {    
//            System.out.println("List is empty");    
//            return;    
//        }    
//        while(current != null) {    
//            if(current.data==p.data){
//                newNode.next=current.next;
//                current.next=newNode;
//            }
//            current=current.next;
//        }
//        return ;
    }
    
    public void traverse() {    
        Node current = head;    
            
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("**Nodes of singly linked list: ");    
        while(current != null) {    
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }    
    
    public int deleteFromHead(){
        int temp;
        if (head == null){
            System.out.println("no head 4 u");
            return -1;
        }else{
            temp=head.data;
            if (head == tail) {
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
        }
        return temp;
    }
    
    public int deleteFromTail(){
        int temp;
        if (tail == null){
            System.out.println("no tail 4 u");
            return -1;
        }else{
            temp=tail.data;
            if (head == tail) {
                head = null;
                tail = null;
            }else{
                Node previousToTail = head;
                while(previousToTail.next != tail)
                       previousToTail = previousToTail.next;
                tail = previousToTail;
                tail.next = null;
            }
        }
        return temp;
    }
    
    public int deleteAter(Node p){
        int temp;
        if (p == null){
            temp=head.next.data;
            deleteFromHead();
        }
        else if(p.next == tail){
            temp=tail.data;
            tail = p;
            tail.next = null;
        }else if(p == tail)
            return -1;
        else{
            temp=p.next.data;
            p.next = p.next.next;
        }
        return temp;
    }
    
    public void dele(int x){
        Node current = head;
        Node previous = null;
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        while(current != null) {    
            if(current.data==x){
                previous.next=current.next;
            }
            previous=current;
            current=current.next;
        }
        return ;
    }
    
    public Node search(int x){
        Node current = head;
        Node newNode = new Node();
        if(head == null) {    
            System.out.println("List is empty");    
            return newNode;    
        }    
        while(current != null) {    
            if(current.data==x){
                return current;
            }
            current=current.next;
        }
        return newNode;
    }
    
    public int count(){
        Node current = head;
        int res=0;
        if(head == null) {    
            System.out.println("List is empty");    
            return 0;    
        }    
        while(current != null) {    
            res++;
            current=current.next;
        }
        return res;
    }
    
    public void delete(int i){
        Node current = head;
        Node previous = null;
        int res=1;
        if(head == null) {    
            System.out.println("List is empty");    
        }    
        while(current != null){    
            if(res==i){
                previous.next=current.next;
                return;
            }
            res++;
            previous=current;
            current=current.next;
        }
        System.out.println("i th item don't exist");
    }    
    
    public void sort(){
  
        // Node current will point to head
        Node current = head, index = null;
  
        int temp;
  
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;
  
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
  
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    
    public void dele(Node p){
        Node current = head;
        Node previous = null;
        if(head == null) {    
            System.out.println("List is empty");    
        }    
        while(current != null){    
            if(current==p){
                previous.next=current.next;
                return;
            }
            previous=current;
            current=current.next;
        }
    }
    
    public int [] toArray(){
        int size=count();
        int [] temp = new int[size+10];
        int i=0;
        Node current = head;   
        while(current != null){    
            temp[i]=current.data;
            i++;
            current=current.next;
        }
        return temp;
    }
    
    public Node getHead(){
        return head;
    }
    
    public Node getTail(){
        return tail;
    }
    
    public void addBefore(Node p, int x){
//        if(p==null){
//            System.out.println("node is not exist");
//            return;
//        }
//        Node newNode = new Node(x);
//        newNode.next=p.next;
//        p.next=newNode;
        Node current = head;
        Node newNode = new Node(x);
        if(head == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        while(current != null) {    
            if(current.data==p.data){
                newNode.next=current.next;
                current.next=newNode;
            }
            current=current.next;
        }
        return ;
    }
    
    public int max(){
        int res=-1;
        Node current = head;    
        while(current != null){    
            if(res<current.data){
                res=current.data;
            }
            current=current.next;
        }
        return res;
    }
    
    public int min(){
        int res=Integer.MAX_VALUE;
        Node current = head;    
        while(current != null){    
            if(res>current.data){
                res=current.data;
            }
            current=current.next;
        }
        return res;
    }
    
    public int sum(){
        int res=0;
        Node current = head;    
        while(current != null){    
            res+=current.data;
            current=current.next;
        }
        return res;
    }
    
    public double avg(){
        double res=0;
        Node current = head;    
        while(current != null){    
            res+=current.data;
            current=current.next;
        }
        return res/count();
    }
    
    public boolean sorted(){
        boolean res=true;
        Node current = head;    
        while(current != tail){    
            if(current.data>current.next.data){
                res=false;
            }
            current=current.next;
        }
        return res;
    }
    
    public void reverse(){
        Node current=head,prev=null,next=null;
        while(current!=null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        Node temp=head;
        head=tail;
        tail=temp;
    }
    
    boolean areIdentical(Node headA,Node headB){
        Node a = headA, b = headB;
        while (a != null && b != null)
        {
            if (a.data != b.data)
                return false;
            a = a.next;
            b = b.next;
        }
 
        // If linked lists are identical, then 'a' and 'b' must
        // be null at this point.
        return (a == null && b == null);
    }
}    

class Merge{
    public Pair<Node,Node> sortedMerge(Node headA, Node headB){
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        while(true){
            if(headA == null){
                tail.next = headB;
                break;
            }
            if(headB == null){
                tail.next = headA;
                break;
            }
            if(headA.data <= headB.data){
                tail.next = headA;
                headA = headA.next;
            }
            else{
                tail.next = headB;
                headB = headB.next;
            }
            tail = tail.next;
        }
//        System.out.println(tail.next.data);
        return new Pair(dummyNode.next,tail.next);
    }
}

class Pair<U, V> {
    private U first;
    private V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
    public U getFirst(){
        return this.first;
    }
    public V getSecond(){
        return this.second;
    }
    
}

class MyStack {
    SinglyLinkedList sList = new SinglyLinkedList();  

    public void push(int x){
        sList.addToHead(x);
    }
    
    public void clear(){
        sList.head=null;
        sList.tail=null;
    }
 
    public boolean isEmpty(){
        return sList.count() == 0;
    }
 
    public int top(){
        if (sList.count() == 0) {
            System.out.print("\nStack Underflow");
        }
        Node temp=sList.head;
        return temp.data;
    }
 
    public int pop(){
        if (sList.count() == 0) {
            System.out.print("\nStack Underflow");
        }
        Node temp=sList.head;
        sList.deleteFromHead();
        return temp.data;
    }
 
    public void traverse(){
        sList.traverse();
    }
}

class MyQueue {
    SinglyLinkedList sList = new SinglyLinkedList();  

    public void enqueue(int x){
        sList.addToTail(x);
    }
    
    public void clear(){
        sList.head=null;
        sList.tail=null;
    }
 
    public boolean isEmpty(){
        return sList.count() == 0;
    }
 
    public int first(){
        if (sList.count() == 0) {
            System.out.print("\nStack Underflow");
        }
        Node temp=sList.head;
        return temp.data;
    }
 
    public int dequeue(){
        if (sList.count() == 0) {
            System.out.print("\nStack Underflow");
        }
        Node temp=sList.head;
        sList.deleteFromHead();
        return temp.data;
    }
 
    public void traverse(){
        sList.traverse();
    }
}
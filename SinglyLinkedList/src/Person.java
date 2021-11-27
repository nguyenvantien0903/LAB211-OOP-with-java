/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NVT
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return name+" | "+age+"\n";
    }
    
    public int compare( Person b) {
        int c;
        c = this.name.compareTo(b.name);
        if (c == 0)
           c = Integer.compare(this.age, b.age);
        return c;
    }
    
    public void swap(Person b){
        
    }
}


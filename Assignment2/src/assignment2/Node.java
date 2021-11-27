/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author NVT
 */
public class Node {
    Node left;
    Node right;
    Person data;

     public Node(Person n)
     {
         left = null;
         right = null;
         data = n;
     }       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstwithobject;

/**
 *
 * @author NVT
 */
public class Node {
    Node left;
    Node right;
    SomeObject data;

     public Node(SomeObject n)
     {
         left = null;
         right = null;
         data = n;
     }       
}

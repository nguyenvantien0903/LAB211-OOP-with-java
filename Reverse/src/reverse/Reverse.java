package reverse;

import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1BBj0tB_fLFXqPk7zw7Ubf1wiUQq8nV-S/edit
 * @author NVT 70 H203
 */
public class Reverse {
    public static String Reverse(String temp) {
        String[] pre = temp.split("\\s+");
        String res="";
        for(int i=pre.length-1;i>=0;i--){
            String aft=pre[i];
            if(i==pre.length-1){
                res+=aft.substring(0,1).toUpperCase()+aft.substring(1)+" ";
            }
            else{
                res+=aft+" ";
            }
        }
        return res.trim();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input="";
        while(input.trim().equals("")){
            System.out.print("PLS input:");
            input = sc.nextLine();
        }
        System.out.println(Reverse(input.trim()));
    }
    
}

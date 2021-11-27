package printreverse;

import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1LIsONbd24sCOzKsCoLq8kzjZoNx34Inj/edit
 * @author NVT 30 H202
 */
public class PrintReverse { 
    public static void Reverse(String temp) {
        String res="";
        for(int i=temp.length()-1;i>=0;i--){
            res+=temp.charAt(i);
        }
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("PLS input:");
        String input = sc.nextLine();
        if(input.trim().equals("")){
            return;
        }
        Reverse(input.trim());
    }
    
}

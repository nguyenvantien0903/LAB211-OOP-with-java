package secondhalfletters;

import java.util.Scanner;


/**
 * https://docs.google.com/document/d/1s4Snq53V6zwDwR02dW5mlAVzPi4jECNm/edit
 * @author NVT H207
 */
public class SecondHalfLetters {
    public static int secondHalfLetters(String temp) {
        int res=0;
        char[] chars = temp.toLowerCase().toCharArray();
        for (char ch: chars) {
            if('n'<=ch&&ch<='z'){
                System.out.println(ch);
                res++;
            }
//            System.out.println(ch);
        }
        return res;
    }
    
    public static void main(String[] args) {
        String s="";
        while(s.equals("")){
            System.out.println("Input the string:");
            Scanner sc = new Scanner(System.in);
            s=sc.nextLine();
        }
        System.out.println(secondHalfLetters(s));
    }
    
}

package printsquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1EM4nf6i6lSKc9n9pWKoV_C8L2CxGPRJK/edit
 * @author NVT 40
 */
public class PrintSquare {
    static Scanner sc = new Scanner(System.in);
    
    public static boolean isNumeric(String string) {
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    
    public static Integer inputInteger(String mess,int min,int max){
        while(true){
            if(!"".equals(mess))System.out.println(mess);
            String input=sc.nextLine().trim();
            if(isNumeric(input)==true){
                Integer res=Integer.parseInt(input);
                if(res<min||res>max){
                    System.out.println("Out of intervel! ");
                    continue;
                }
                return res;
            }
        }
    }
    
    public static void printSquare(int min,int max) {
        for(int i=min;i<=max;i++){
            for(int j=i;j<=max;j++){
                System.out.print(j);
            }
            for(int j=min;j<=i-1;j++){
                System.out.print(j);
            }
            System.out.println();
        }
//        3 6
//        3456
//        4563
//        5634
//        6345
    }
    
    public static void main(String[] args) {
        int min=inputInteger("lower:",Integer.MIN_VALUE,Integer.MAX_VALUE);
        int max=inputInteger("upper:",min,Integer.MAX_VALUE);
        printSquare(min,max);
    }
    
}

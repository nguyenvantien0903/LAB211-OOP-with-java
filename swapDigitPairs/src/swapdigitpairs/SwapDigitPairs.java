package swapdigitpairs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://docs.google.com/document/d/1nYlaEk_66CLataI2nH6nylNBvsNJaNuW/edit
 * @author NVT
 */
public class SwapDigitPairs {
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
    
    public static void swapDigitPairs(int n){
        List<Integer> num = new ArrayList<Integer>();
        while(n>0){
            num.add(n%10);
            n/=10;
        }
        
        int res=0;
        for(int i=0;i<num.size();i+=2){
            if(i+1<num.size()){
                res+=num.get(i+1)*Math.pow(10, i);
                res+=num.get(i)*Math.pow(10, i+1);
            }else{
                res+=num.get(i)*Math.pow(10, i);
            }
        }
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while(true){
            System.out.println("Input a number:");
            input=sc.nextLine();
            if(isNumeric(input)==true)
                break;
        }
        swapDigitPairs(Integer.parseInt(input));
    }
    
}

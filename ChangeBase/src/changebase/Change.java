/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebase;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author NVT
 */
public class Change {
    Scanner sc = new Scanner(System.in);
    
    public String inputRegex(String mess,String regex){
        while(true){
            System.out.println(mess);
            String input=sc.nextLine().trim();
            if("".equals(input))continue;
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("Wrong number format!");
            }
        }
    }
    
    public boolean isInteger(String string) {
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            Integer res = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    
    public Integer inputInteger(String mess,int min,int max){
        while(true){
            if(!"".equals(mess))System.out.println(mess);
            String input=sc.nextLine().trim();
            if(isInteger(input)==true){
                Integer res=Integer.parseInt(input);
                if(res<min||res>max){
                    System.out.println("Out of intervel! ");
                    continue;
                }
                return res;
            }
        }
    }
    
    public String baseConversion(String number, int inBase, int outBase){
        if(inBase==outBase){
            return number;
        }
        if(inBase==10){
            return DecToOther(number,outBase);
        }else{
            return DecToOther(OtherToDec(number,inBase),outBase);
        }
    }
    
    public String OtherToDec(String Other, int base) {
        BigInteger result = new BigInteger("0");
        String HEX = "0123456789ABCDEF";
        
        for (int i = 0; i < Other.length(); i++) {
            int value = (int) (HEX.indexOf(Other.charAt(i)) * Math.pow(base, Other.length() - 1 - i));
            result = result.add(new BigInteger(""+value));
        }
        return result.toString();
        
    }

    public String DecToOther(String input, int base) {
        BigInteger Dec=new BigInteger(input);
        String result = "";
        String HEX = "0123456789ABCDEF";
        //18347598437 2
        while (Dec.compareTo(new BigInteger("0")) > 0) {
            int remain = Dec.mod(new BigInteger(""+base)).intValue();
            result = HEX.charAt(remain) + result;
            Dec = Dec.divide(new BigInteger(""+base));
        }
        1 0 0 1
        1001
        if("".equals(result))return "0";
        return result;
    }

}

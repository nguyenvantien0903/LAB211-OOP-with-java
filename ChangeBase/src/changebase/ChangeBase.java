
package changebase;

/**
 * P0011
 * @author NVT
 */
// https://docs.google.com/document/d/1jWVEczXEzXovTRWKZcYFtz0iwr5bVBTg/edit

public class ChangeBase {
    public static void main(String[] args) {
        Change change=new Change();
        while(true){
            System.out.println("CHANGE BASE SYSTEM");
            System.out.println("FROM");
            System.out.println("    1.Binary");
            System.out.println("    2.Octal");
            System.out.println("    3.Decimal");
            System.out.println("    4.Hexadecimal");
            System.out.println("    5.Exit");
            int choice1=change.inputInteger("PLS enter your choice(1-5):",1,5);
            if(choice1==5)return;
            System.out.println("TO");
            System.out.println("    1.Binary");
            System.out.println("    2.Octal");
            System.out.println("    3.Decimal");
            System.out.println("    4.Hexadecimal");
            System.out.println("    5.Exit");
            int choice2=change.inputInteger("PLS enter your choice(1-5):",1,5);
            if(choice2==5)return;
            
            String regex[]={"","[0-1]+","[0-7]+","[0-9]+","[0-9a-fA-F]+"};
            int base[]={0,2,8,10,16};
            String num1=change.inputRegex("Enter the number to convert:",regex[choice1]).toUpperCase();
            
            System.out.println("THE ANSWER IS:" + change.baseConversion(num1, base[choice1], base[choice2]));
            
        }
    }
    
}

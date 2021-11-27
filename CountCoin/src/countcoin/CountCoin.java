package countcoin;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://docs.google.com/document/d/16MRzvswwUQOYcW0WwAdYe7idlxGkP02D/edit
 * @author NVT H209
 */
public class CountCoin {
    public static void countCoins(Scanner fileScan){
        List<Integer> num = new ArrayList<>();
        List<String> type = new ArrayList<>();
        while (fileScan.hasNext()) {
            try{
                num.add(fileScan.nextInt());
            }
            catch(Exception e){
                System.out.println("Wrong format!");
                return;
            }
            try{
                type.add(fileScan.next().toLowerCase());
            }
            catch(Exception e){
                System.out.println("Wrong format!");
                return;
            }
        }
        fileScan.close();
        
        Float res=0F;
        for(int i=0;i<num.size();i++){
            int value=0;
            switch(type.get(i)){
                case "pennies":{
                    value=1;
                    break;
                }
                case "quarters":{
                    value=25;
                    break;
                }
                case "nickels":{
                    value=5;
                    break;
                }
                case "dimes":{
                    value=10;
                    break;
                }
                default:{
                    System.out.println("Wrong format!");
                    return;
                }
            }
            res+=num.get(i)*value;
        }
        res/=100;
        System.out.print("$");
        System.out.println(String.format("%.02f",res));
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("coins.txt");
        if(!file.exists()){
            System.out.println("File not exist!");
            return;
        }
        countCoins(new Scanner(file));
    }
    
}

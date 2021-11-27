package fruitshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author NVT
 */
public class ManageFruit {
    Scanner sc = new Scanner(System.in);
    public boolean isNumeric(String string) {
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
    
    public Integer inputInteger(String mess,int min,int max){
        while(true){
            System.out.println(mess);
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
    
    public boolean isDouble(String string) {
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            Double res = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer or Double.");
        }
        return false;
    }
    
    public Double inputDouble(String mess,double min,double max){
        while(true){
            System.out.println(mess);
            String input=sc.nextLine().trim();
            if(isDouble(input)==true){
                Double res=Double.parseDouble(input);
                if(res<min||res>max){
                    System.out.println("Out of intervel! ");
                    continue;
                }
                return res;
            }
        }
    }
    
    public String inputString(String mess,int yes_no_question){
        while(true){
            System.out.println(mess);
            String input=sc.nextLine().trim();
            if(yes_no_question==1){
                if(input.equalsIgnoreCase("N")||input.equalsIgnoreCase("Y")){
                    return input.toUpperCase();
                }else{
                    continue;
                }
            }
            return input;
        }
    }
    
    ArrayList<Fruit> allFruit = new ArrayList<>();
    HashMap<String, ArrayList<Fruit>> allOrders = new HashMap<>();
    
    public ManageFruit(){
        allFruit.add(new Fruit(1, "Coconut", 5, 10,  "VN"));
        allFruit.add(new Fruit(3, "Apple", 2, 1,  "USA"));
        allFruit.add(new Fruit(6, "Banana", 6, 120,  "Wakanda"));
        allFruit.add(new Fruit(9, "Mango", 10, 30,  "VietNam"));
        allFruit.add(new Fruit(10, "Tao meo", 10, 12,  "VietNam"));
        allFruit.add(new Fruit(100, "Sagami", 7, 9,  "Japan"));
    }
    
    public void display(int for_buyer){
        System.out.println("===========================================");
        System.out.println("List of Fruit:");
        System.out.printf("%-10s%-20s%-10s%-10s%-10s\n", "Item", "Fruit name", "Orgin", "Price","Quantity");
        if(for_buyer==1){
            int cnt=1;
            for(Fruit x:allFruit){
                System.out.printf("%-10d%-20s%-10s%-10.2f%-10d\n",cnt++,x.getName(),x.getOrigin(),x.getPrice(),x.getQuantity());
            }
        }else{
            for(Fruit x:allFruit){
                System.out.printf("%-10d%-20s%-10s%-10.2f%-10d\n",x.getId(),x.getName(),x.getOrigin(),x.getPrice(),x.getQuantity());
            }
        }
    }
    
    public Fruit checkFruitID(ArrayList<Fruit> fruit,int id) {
        for (int i = 0; i < fruit.size(); i++) {
            if (fruit.get(i).getId() == id) {
                return fruit.get(i);
            }
        }
        return null;
    }
    
    public Fruit CreateFuit(int id){
        String name=inputString("PLS input fruit name:",0);
        Double price=inputDouble("PLS input fruit price:",0,Double.MAX_VALUE);
        int quantity=inputInteger("PLS input fruit quantity:",0,Integer.MAX_VALUE);
        String origin=inputString("PLS input fruit origin:",0);
        return new Fruit(id,name,price,quantity,origin);
    }
    
    public void CreateFruit(){
        while(true){
            int id=inputInteger("PLS input fruit id:",0,Integer.MAX_VALUE);
            Fruit foundFruit=checkFruitID(allFruit,id);
            if(foundFruit!=null){
                System.out.println("This fruit exists!");
            }else{
                allFruit.add(CreateFuit(id));
            }
            String choice=inputString("Do you want to continue (Y/N)?",1);
            if(choice.equals("N"))
                break;
        }
        display(0);
    }
    
    public void UpdateFruit(){
        int id=inputInteger("PLS input fruit id:",0,Integer.MAX_VALUE);
        Fruit foundFruit=checkFruitID(allFruit,id);
        if(foundFruit!=null){
            int newQuantity=inputInteger("PLS enter new fruit quantity:",0,Integer.MAX_VALUE);
            foundFruit.setQuantity(foundFruit.getQuantity()+newQuantity);
            display(0);
        }else{
            String choice=inputString("Fruit not exist! Do you want to create the fruit(Y/N)?",1);
            if(choice.equals("Y")){
                allFruit.add(CreateFuit(id));
                display(0);
            }
        }
    }
    
    public void displayOrder(ArrayList<Fruit> order){
        double total = 0;
        System.out.printf("%-16s%-16s%-16s%-16s\n", "Product", "Quantity", "Orgin", "Price","Amount");
        for(Fruit x:order){
            double amount = x.getPrice()*x.getQuantity();
            System.out.printf("%-16s%-16d%-16.2f$%-16.2f\n", x.getName(), x.getQuantity(), x.getPrice(), amount);
            total += amount;
        }
        System.out.printf("Total: %.02f$\n",total);
//        System.out.println("Total: " + total + "$");
        
    }
    
    public void shopping(){
        ArrayList<Fruit> order = new ArrayList<>();
        if(allFruit.isEmpty()){
            System.out.println("We don't have fruit now!");
            return;
        }
        while(true){
            display(1);
            int index=inputInteger("PLS select item id:",1,allFruit.size());
            Fruit f=allFruit.get(index-1);
          
            System.out.println("You selected: "+f.getName());
            int buy_quantity=inputInteger("PLS input quantity:",1,f.getQuantity());
            int left_quantity=f.getQuantity()-buy_quantity;
            
            Fruit foundFruit=checkFruitID(order,f.getId());
            if(foundFruit==null){// chua co fruit trong order
                order.add(new Fruit(f.getId(),f.getName(),f.getPrice(),buy_quantity,f.getOrigin()));
            }else{
                foundFruit.setQuantity(foundFruit.getQuantity()+buy_quantity);
            }
            
            if(left_quantity==0){
                allFruit.remove(f);
            }else{
                f.setQuantity(left_quantity);
            }
            
            String choice=inputString("Do you want to order now(Y/N)?",1);
            if(choice.equals("Y"))
                break;
        }
        displayOrder(order);
        String customer=inputString("PLS input your name:",0);
        System.out.println("Tks for buying =))");
        allOrders.put(customer+"@"+allOrders.size(),order);
    }

    public void viewOrder(){
        if(allOrders.isEmpty()){
            System.out.println("There is no order here!");
            return;
        }
        allOrders.forEach((customerName, order) -> {
            System.out.println("===========================================");
            System.out.println("Customer: " + customerName.substring(0,customerName.indexOf("@")));
            displayOrder(order);
            System.out.println();
        });
    }
}

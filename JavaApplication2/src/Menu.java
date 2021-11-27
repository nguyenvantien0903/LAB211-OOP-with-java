
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Collections;

// Task 
// Menu interface + PetDog.java + Dog.java - Thành Đạt
// Menu from 1-5 - Trung Hiếu
// Menu from 6-10 - Minh Dũng 
// Menu from 11-15 - Văn Tiến
//StringBuilder output = new StringBuilder(input).reverse();

class SortbyName implements Comparator<Dog>
{
    public int compare(Dog a, Dog b)
    {
        return a.getDogName().compareTo(b.getDogName());
    }
}

class SortbyPrice implements Comparator<Dog>
{
    public int compare(Dog a, Dog b)
    {
        return Double.compare(a.getPrice(),b.getPrice());
    }
}

public class Menu {
    public static void main(String[] args) throws IOException {
        List<Dog> listDog = new ArrayList<Dog>();
        List<PetDog> listPetDog = new ArrayList<PetDog>();
        List<Dog> temp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------- WELCOME TO DOGGO 1.0 -------");
        System.out.println("\n------- PLEASE SELECT AN OPTION ------");
        boolean flag = true;
        int id,petID;
        String name,color,gender,describe;
        double price;
        BufferedReader br;
        BufferedWriter brr;
        do {
            System.out.println("\n------- MENU -------------");
            System.out.println("1. List all PetDogs");
            System.out.println("2. Add a new PetDog");
            System.out.println("3. Remove a PetDog by ID");
            System.out.println("4. Save PetDogs to petdog.txt file");
            System.out.println("5. List all Dogs");
            System.out.println("6. Add a new Dog");
            System.out.println("7. Remove a dog by ID");
            System.out.println("8. Update a dog based on its ID");
            System.out.println("9. Save Dogs to dog.txt file");
            System.out.println("10. List all dogs in ascending order of dog names");
            System.out.println("11. List all dogs in ascending order of dog prices");
            System.out.println("12. Search dogs based on its color");
            System.out.println("13. Search dogs based on its prices");
            System.out.println("14. Load Dogs from dog.txt");
            System.out.println("15. Load PetDogs from petdog.txt");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("OUTPUT:");
                    for(int i=0;i<listPetDog.size();i++){
                        System.out.println(listPetDog.get(i).toString());
                    }
                    break;
                case 2:
                    System.out.println("INPUT ID:");
                    id=Integer.parseInt(scanner.nextLine());
                    System.out.println("INPUT PET NAME:");
                    name=scanner.nextLine();
                    listPetDog.add(new PetDog(id,name));
                    break;
                case 3:
                    System.out.println("INPUT ID:");
                    id=Integer.parseInt(scanner.nextLine());
                    for(int i=0;i<listPetDog.size();i++){
                        if(listPetDog.get(i).getID()==id){
                            listPetDog.remove(i);
                            break;
                        }
                    }
                    break;
                case 4:
                    try {
                        brr = new BufferedWriter(new FileWriter("src/petdog.txt"));
                        String line = "";
                        for (PetDog i : listPetDog) {
                            line = i.getID()+";"+i.getPetName();
                            brr.write(line + "\n");
                            }
                        brr.close();
                    } catch (FileNotFoundException e) {
                            System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("OUTPUT:");
                    for(int i=0;i<listDog.size();i++){
                        System.out.println(listDog.get(i).toString());
                    }
                    break;
                case 6:
                    System.out.println("INPUT ID:");
                    id=Integer.parseInt(scanner.nextLine());
                    System.out.println("INPUT PET ID:");
                    petID=Integer.parseInt(scanner.nextLine());
                    System.out.println("INPUT COLOR:");
                    color=scanner.nextLine();
                    System.out.println("INPUT GENDER:");
                    gender=scanner.nextLine();
                    System.out.println("INPUT DESCRIBE:");
                    describe=scanner.nextLine();
                    System.out.println("INPUT DOG NAME:");
                    name=scanner.nextLine();
                    System.out.println("INPUT PRICE:");
                    price=Double.parseDouble(scanner.nextLine());
                    listDog.add(new Dog(id,petID,name,color,gender,price,describe));
                    break;
                case 7:
                    System.out.println("INPUT ID:");
                    id=Integer.parseInt(scanner.nextLine());
                    for(int i=0;i<listDog.size();i++){
                        if(listDog.get(i).getID()==id){
                            listDog.remove(i);
                            break;
                        }
                    }
                    break;
                case 8:
                    System.out.println("INPUT ID:");
                    id=Integer.parseInt(scanner.nextLine());
                    for(int i=0;i<listDog.size();i++){
                        if(listDog.get(i).getID()==id){
                            System.out.println("INPUT PET ID:");
                            petID=Integer.parseInt(scanner.nextLine());
                            System.out.println("INPUT COLOR:");
                            color=scanner.nextLine();
                            System.out.println("INPUT GENDER:");
                            gender=scanner.nextLine();
                            System.out.println("INPUT DESCRIBE:");
                            describe=scanner.nextLine();
                            System.out.println("INPUT DOG NAME:");
                            name=scanner.nextLine();
                            System.out.println("INPUT PRICE:");
                            price=Double.parseDouble(scanner.nextLine());
                            listDog.get(i).setPetID(petID);
                            listDog.get(i).setDogColor(color);
                            listDog.get(i).setDogGender(gender);
                            listDog.get(i).setDescribe(describe);
                            listDog.get(i).setDogName(name);
                            listDog.get(i).setPrice(price);
                            
                        }
                    }
                    break;
                case 9:
                    try {
                        brr = new BufferedWriter(new FileWriter("src/dog.txt"));
                        String line = "";
                        for (Dog i : listDog) {
                            line = i.getID()+";"+i.getPetID()+";"+i.getDogName()+";"+i.getDogColor()+";"+i.getDogGender()+";"+i.getPrice()+";"+i.getDescribe();
                            brr.write(line + "\n");
                            }
                        brr.close();
                    } catch (FileNotFoundException e) {
                            System.out.println(e);
                    }
                    break;
                case 10:
                    System.out.println("OUTPUT:");
                    temp = listDog;
                    Collections.sort(temp, new SortbyName());
                    for(Dog i: temp){
                        System.out.println(i.toString());
                    }
                    break;
                case 11:
                    System.out.println("OUTPUT:");
                    temp = listDog;
                    Collections.sort(temp, new SortbyPrice());
                    for(Dog i: temp){
                        System.out.println(i.toString());
                    }
                    break;
                case 12:
                    System.out.println("INPUT COLOR:");
                    color=scanner.nextLine();
                    System.out.println("OUTPUT:");
                    for(Dog i: listDog){
                        if(i.getDogColor().equals(color)){
                            System.out.println(i.toString());
                        }
                    }
                    break;
                case 13:
                    System.out.println("INPUT PRICE:");
                    price=Double.parseDouble(scanner.nextLine());
                    System.out.println("OUTPUT:");
                    for(Dog i: listDog){
                        if(i.getPrice()<=price){
                            System.out.println(i.toString());
                        }
                    }
                    break;
                case 14:
                    try {
                        br = new BufferedReader(new FileReader("src/dog.txt"));
                        String line = "";
                        while ((line = br.readLine()) != null) {
                            String[] s = line.split(";");
                            id = Integer.parseInt(s[0]);
                            petID = Integer.parseInt(s[1]);
                            name = s[2];
                            color = s[3];
                            gender = s[4];
                            price = Double.parseDouble(s[5]);
                            describe = s[6];
                            Dog d = new Dog(id,petID,name,color,gender,price,describe);
                            listDog.add(d);
                        }
                    }catch (FileNotFoundException e) {
                        System.out.println(e);
                    }catch(IOException e){
                        System.out.println(e);
                    }
                    break;
                case 15:
                    try {
                        br = new BufferedReader(new FileReader("src/petdog.txt"));
                        String line = "";
                        while ((line = br.readLine()) != null) {
                            String[] s = line.split("; ");
                            id = Integer.parseInt(s[0]);
                            name = s[1];
                            PetDog d = new PetDog(id, name);
                            listPetDog.add(d);
                        }
                    }catch (FileNotFoundException e) {
                        System.out.println(e);
                    }catch(IOException e){
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("Only choose 1 - 15. enter again: ");
            }
        } while (flag);
    }
}
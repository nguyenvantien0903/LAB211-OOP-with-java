import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Dog {
    private int ID;
    private int petID;
    private String dogName;
    private String dogColor;
    private String dogGender;
    private double price;
    private String describe;

    public Dog() {
    }

    public Dog(int ID, int petID, String dogName, String dogColor, String dogGender, double price, String describe) {
        this.ID = ID;
        this.petID = petID;
        this.dogName = dogName;
        this.dogColor = dogColor;
        this.dogGender = dogGender;
        this.price = price;
        this.describe = describe;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    public String getDogGender() {
        return dogGender;
    }

    public void setDogGender(String dogGender) {
        this.dogGender = dogGender;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String toString(){
        return ID+"\t"+petID+"\t"+dogName+"\t"+dogColor+"\t"+dogGender+"\t"+price+"\t"+describe;
    }
}
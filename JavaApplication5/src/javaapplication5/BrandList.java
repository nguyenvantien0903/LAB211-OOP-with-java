/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NVT
 */
public class BrandList {
    List<Brand> listBrand = new ArrayList<Brand>();
    String brandID,brandName,soundBrand;
    double price;
    public BrandList(){};
    public boolean loadFromFile(){
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader("src/brands.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",: ");
                brandID=s[0];
                brandName=s[1];
                soundBrand=s[2];
                price=Double.parseDouble(s[3]);
                Brand d = new Brand(brandID,brandName,soundBrand,price);
                listBrand.add(d);
            }
        }catch (FileNotFoundException e) {
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        return true;
    }
    public boolean saveToFile() throws IOException{
        try {
            BufferedWriter brr;
            brr = new BufferedWriter(new FileWriter("src/brands.txt"));
            String line = "";
            for (Brand i : listBrand) {
                line = i.getBrandID()+", "+i.getBrandName()+", "+i.getSoundBrand()+": "+i.getPrice();
                brr.write(line + "\n");
                }
            brr.close();
        } catch (FileNotFoundException e) {
                System.out.println(e);
        }
        return true;
    }
}

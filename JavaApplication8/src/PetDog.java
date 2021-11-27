/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NVT
 */
public class PetDog {
    private int ID;
    private String petName;

    public PetDog() {
    }
    
    public PetDog(int id,String petname){
        this.ID=id;
        this.petName=petname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
    
    public String toString(){
        return ID + "\t" + petName;
    }
}
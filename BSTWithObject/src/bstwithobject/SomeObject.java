/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstwithobject;

/**
 *
 * @author NVT
 */
public class SomeObject {
    private int id;
    private String name;
    private String magic;

    public SomeObject() {
    }

    public SomeObject(int id) {
        this.id = id;
    }
    
    public SomeObject(int id, String name, String magic) {
        this.id = id;
        this.name = name;
        this.magic = magic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }
    
}

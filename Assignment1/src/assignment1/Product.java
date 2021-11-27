
package assignment1;

/**
 *
 * @author NVT
 */
public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return name+"\t|\t"+price+"\t|\t"+quantity;
    }
    
    public int compare(Product a) {
        return this.getName().compareTo(a.getName());
    }
    
    public void swap(Product a){
        String temp=this.getName();
        double temp1=this.getPrice();
        int temp2=this.getQuantity();
        this.setName(a.getName());
        this.setPrice(a.getPrice());
        this.setQuantity(a.getQuantity());
        a.setName(temp);
        a.setPrice(temp1);
        a.setQuantity(temp2);
    }
    
    public Double getTotalValue(){
        return this.getPrice()*this.getQuantity();
    }
}

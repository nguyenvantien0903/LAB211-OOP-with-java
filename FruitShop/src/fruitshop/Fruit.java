package fruitshop;

/**
 *
 * @author NVT
 */
public class Fruit {
    private int id,quantity;
    private double price;
    private String name,origin;

    public Fruit() {
    }
    
    public Fruit(Fruit x){
        this.id = x.id;
        this.name = x.name;
        this.price = x.price;
        this.quantity = x.quantity;
        this.origin = x.origin;
    }
    
    public Fruit(int id, String name, double price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}

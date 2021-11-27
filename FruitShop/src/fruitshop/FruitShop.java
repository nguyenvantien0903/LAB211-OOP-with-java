package fruitshop;

/**
 * https://docs.google.com/document/d/1q73gFPAxrzgfr0o7nhoki8cD_bRfQ0vr/edit
 * @author NVT
 */
public class FruitShop {
    public static void main(String[] args) {
        ManageFruit Manage = new ManageFruit();
        while(true){
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("    1.Creat Fruit");
            System.out.println("    2.Update Fruit");
            System.out.println("    3.View Orders");
            System.out.println("    4.Shopping (for buyer)");
            System.out.println("    5.Exit");
            int choice=Manage.inputInteger("PLS enter your choice:",1,5);
            switch(choice){
                case 1:{
                    Manage.CreateFruit();
                    break;
                }
                case 2:{
                    Manage.UpdateFruit();
                    break;
                }
                case 3:{
                    Manage.viewOrder();
                    break;
                }
                case 4:{
                    Manage.shopping();
                    break;
                }
                case 5:{
                    return;
                }
            }
        }
    }
    
}

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        //Singleton
        InventoryManager manager = InventoryManager.getInstance();

        InventoryManager manager2 = InventoryManager.getInstance();
        System.out.println("Same instance? " + (manager == manager2)); // true

        System.out.println("\n--- Adding Products to Inventory ---\n");

        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Wireless Mouse"));
        manager.addProduct(new NewProduct("USB Hub"));

        //Legacy Items
        LegacyItem item1 = new LegacyItem(101, "Old Keyboard Model X");
        LegacyItem item2 = new LegacyItem(102, "Vintage Monitor CRT");

        manager.addProduct(new ProductAdapter(item1)); 
        manager.addProduct(new ProductAdapter(item2)); 

        //Iterator
        System.out.println("========== INVENTORY LIST ==========");

        Iterator<Product> it = manager.returnInventory(); // get iterator

        while (it.hasNext()) {          
            Product p = it.next();      
            p.displayDetails();        
            System.out.println("------------------------------------");
        }
    }
}

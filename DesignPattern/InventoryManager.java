import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryManager {

    private static InventoryManager instance = null;

    private List<Product> inventory;

    private InventoryManager() {
        inventory = new ArrayList<Product>(); 
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public Iterator<Product> returnInventory() {
        return inventory.iterator();
    }
}

public class LegacyItem {

    // Private data members
    private int    itemId;
    private String description;

    // Parameterized constructor
    public LegacyItem(int itemId, String description) {
        this.itemId      = itemId;
        this.description = description;
    }
    public void print() {
        System.out.println("Legacy Item ID  : " + itemId);
        System.out.println("Description     : " + description);
    }
}

public class customer {

    public String customerID;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String address;
    protected String aadharID;
    protected String panID;

    public customer(String customerID, String firstName, String lastName,
                    String email, String phoneNumber, String address,
                    String aadharID, String panID) {

        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.aadharID = aadharID;
        this.panID = panID;
    }

    public void displayCustomer() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Aadhar ID: " + aadharID);
        System.out.println("PAN ID: " + panID);
    }
}
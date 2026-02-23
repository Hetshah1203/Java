// Book Class
class Book
{
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private double price;

    // Default Constructor
    public Book()
    {
    }

    // Parameterized Constructor
    public Book(int bookId, String title, String author,
                String genre, double price) throws InvalidPriceException
    {
        if(price < 0)
        {
            throw new InvalidPriceException("Price cannot be negative!");
        }

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    // Getters
    public double getPrice()
    {
        return price;
    }

    public String getGenre()
    {
        return genre;
    }

    // Display Method
    public void display()
    {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Genre   : " + genre);
        System.out.println("Price   : " + price);
        System.out.println("---------------------------");
    }
}
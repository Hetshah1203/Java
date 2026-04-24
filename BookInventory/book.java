public class book {
    public String title;
    public double price;
    public String ISBN;
    public String genre;
    public String author;

    public book(){
        title = "Ready Player One";
        price = 458;
        ISBN = "ABR4212";
        genre = "Fiction";
        author = "Ernest Cline";
    }

    public book(String title, double price, String genre ) throws InvalidPriceException, InvalidBookGenreException
    { 
        this.title = title;
        if (price<0)
            throw new InvalidPriceException("Price cannot be negative");
        this.price = price;
        if (!genre.equals("Fiction") && !genre.equals("Non-fiction") && !genre.equals("Auto-biography"))
            throw new InvalidBookGenreException("Invalid genre");
        this.genre = genre;
    }

    public book(String title, double price, String ISBN, String genre, String author) throws InvalidPriceException, InvalidBookGenreException
    {
        this.title = title;
        if (price<0)
            throw new InvalidPriceException("Price cannot be negative");
        this.price = price;
        this.ISBN = ISBN;
        if (!genre.equals("Fiction") && !genre.equals("Non-fiction") && !genre.equals("Auto-biography"))
            throw new InvalidBookGenreException("Invalid genre");
        this.genre = genre;
        this.author = author;
    }

    public book(book b){
        this.title = b.title;
        this.price = b.price;
        this.ISBN = b.ISBN;
        this.genre = b.genre;
        this.author = b.author;
    }   
    
}

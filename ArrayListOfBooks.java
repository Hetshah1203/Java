import java.util.ArrayList;

public class ArrayListOfBooks
{
    public static void main(String[] args)
    {
        ArrayList<Book> books = new ArrayList<>();

        try
        {
            // Creating Book objects
            books.add(new Book(1, "Harry Potter", "J.K Rowling", "Fiction", 500));
            books.add(new Book(2, "Data Structures", "Mark Allen", "Education", 650));
            books.add(new Book(3, "The Alchemist", "Paulo Coelho", "Fiction", 400));

            // Creating book with negative price (Exception Case)
            books.add(new Book(4, "Invalid Book", "Unknown", "Fiction", -100));
        }
        catch(InvalidPriceException e)
        {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // Display all books
        System.out.println("\n--- Book Details ---");
        double totalPrice = 0;

        for(Book b : books)
        {
            b.display();
            totalPrice += b.getPrice();
        }

        // Average price calculation
        if(books.size() > 0)
        {
            double avg = totalPrice / books.size();
            System.out.println("Average Price of Books = " + avg);
        }

        // Print Fiction books using forEach()
        System.out.println("\n--- Fiction Books ---");

        books.forEach(book -> {
            if(book.getGenre().equalsIgnoreCase("Fiction"))
            {
                book.display();
            }
        });
    }
}
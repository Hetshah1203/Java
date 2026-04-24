import java.util.ArrayList;

public class mainbook {
    public static void main(String[] args) {
        ArrayList<book> alb = new ArrayList<book>();
        try{
        book b1 = new book("Icon", 499, "Fiction");
        alb.add(b1);

        book b2 = new book();
        alb.add(b2);

        book b3 = new book(b2);
        b3.title = "Harry Potter";
        b3.author="JK Rowling";
        alb.add(b3);

        book b4 = new book("Outlive", 370, "ABDK223", "Non-fiction", "Peter Attia");
        alb.add(b4);
        book b5 = new book("My experients with truth", 549, "ABCD3101", "Fiction", "Mahatama Gandhi");
        alb.add(b5);
        book b6 = new book("Mein Kampf", 999, "NA67ZI", "Auto-biography", "Adolf Hitler");
        alb.add(b6);
        }
        catch(InvalidPriceException ip){
        System.out.println(ip.getMessage());
        }
        catch(InvalidBookGenreException ibg){
            System.out.println(ibg.getMessage());
        }
        
        int temp = 0;
        int[] len = {0};  
        alb.forEach(b -> {
            if(b.genre.equals("Fiction")){
                System.out.println("------------------");
                System.out.println(b.title);
                System.out.println(b.price);
                System.out.println(b.author);
                System.out.println(b.ISBN);
                System.out.println(b.genre);
                System.out.println("------------------");
                len[0] += 1;
            }
        });  

        System.out.println("Fiction books: " + len[0]);

        len[0] = 0;

        for(book b : alb){
            len[0] += 1;
            temp += b.price;
        }

        System.out.println("Average price: " + (temp / len[0]));
    


    }
}

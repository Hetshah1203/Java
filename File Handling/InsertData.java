import java.io.*;

public class InsertData {
    public static void insertData() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Data_Student.csv", true));

        writer.write("103,Krrish,AIML,87,77,92,89,88\n");
        writer.write("104,Parth,AIML,89,87,95,96,90\n");

        writer.close();
    }
}
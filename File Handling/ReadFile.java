import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            System.out.println("--- Original Data ---");
            readAndPrint();

            System.out.println("\n--- 1. Insert Data ---");
            InsertData.insertData();
            readAndPrint();

            System.out.println("\n--- 2. Update Data ---");
            UpdateData.updateData(103, "103,Krrish,AIML,90,90,90,90,90");
            readAndPrint();

            System.out.println("\n--- 3. Calculate Percentage ---");
            calcPercentage.calculate();
            readAndPrint();

            System.out.println("\n--- 4. Delete Data ---");
            DeleteData.deleteData(104);
            readAndPrint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readAndPrint() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Data_Student.csv"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
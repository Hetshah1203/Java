import java.io.*;
import java.nio.file.*;

public class UpdateData {
    public static void updateData(int id, String newData) throws IOException {
        File inputFile = new File("Data_Student.csv");
        File tempFile = new File("temp.csv");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        // Keep header
        if ((currentLine = reader.readLine()) != null) {
            writer.write(currentLine + "\n");
        }

        while ((currentLine = reader.readLine()) != null) {
            String[] parts = currentLine.split(",", -1);

            if (parts[0].equals(String.valueOf(id))) {
                writer.write(newData + "\n");
            } else {
                writer.write(currentLine + "\n");
            }
        }

        reader.close();
        writer.close();

        Files.move(tempFile.toPath(), inputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
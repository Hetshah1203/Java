import java.nio.file.*;
import java.util.*;

public class calcPercentage {
    public static void calculate() throws Exception {
        Path path = Paths.get("Data_Student.csv");

        if (!Files.exists(path)) {
            System.out.println("File not found!");
            return;
        }

        List<String> lines = Files.readAllLines(path);
        List<String> updated = new ArrayList<>();

        // Header
        if (!lines.isEmpty()) {
            updated.add(lines.get(0));
        }

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(",", -1);

            try {
                double sum = 0;
                int count = 0;

                // Marks columns (3 to 7)
                for (int j = 3; j <= 7; j++) {
                    if (!parts[j].isEmpty()) {
                        sum += Double.parseDouble(parts[j]);
                        count++;
                    }
                }

                double avg = sum / count;

                // Ensure column 9 exists
                if (parts.length < 9) {
                    parts = Arrays.copyOf(parts, 9);
                }

                parts[8] = String.format("%.2f", avg);

            } catch (Exception e) {
                System.out.println("Skipping invalid row: " + line);
            }

            updated.add(String.join(",", parts));
        }

        Files.write(path, updated);
        System.out.println("Percentage calculation completed!");
    }
}
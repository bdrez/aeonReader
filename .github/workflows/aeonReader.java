package Summer;
import java.util.*;
import java.io.*;

public class aeonReader {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Set to store unique genes
        Set<String> genes = new HashSet<>();
        // List to store gene relationships
        List<String[]> relationships = new ArrayList<>();

        // File paths
        File file = new File("C:\\Users\\blimy\\OneDrive\\Desktop\\modle3.txt");
        String newReinFilePath = "C:\\Users\\blimy\\OneDrive\\Desktop\\outputFile.rein";
        BufferedWriter reinWriter = new BufferedWriter(new FileWriter(newReinFilePath));

        // Scanner to read the file
        Scanner sc = new Scanner(file);

        // Read the file once and store gene relationships
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("$")) {
                break;
            }
            String modifiedLine = line.replace("v_", "");
            String[] parts = modifiedLine.split(" ");
            if (parts.length >= 3) {
                String one = parts[0];
                String two = parts[1];
                String three = parts[2];
                genes.add(one);
                genes.add(three);
                relationships.add(new String[]{one, two, three});
            }
        }
        sc.close();

        // Write unique genes to the output file
        for (String gene : genes) {
            reinWriter.write(gene + " (0..17); ");
        }
        reinWriter.newLine();

        // Write gene relationships to the output file
        for (String[] relationship : relationships) {
            String one = relationship[0];
            String two = relationship[1];
            String three = relationship[2];
            if (two.equals("->")) {
                reinWriter.write(one + " " + three + " positive;");
            } else if (two.equals("-|")) {
                reinWriter.write(one + " " + three + " negative;");
            } else if (two.equals("->?")) {
                reinWriter.write(one + " " + three + " positive optional;");
            } else if (two.equals("-|?")) {
                reinWriter.write(one + " " + three + " negative optional;");
            } else {
                reinWriter.write(one + " " + three + " positive;");
                reinWriter.write(one + " " + three + " negative;");
            }
            reinWriter.newLine();
        }
        reinWriter.close();
    }
}

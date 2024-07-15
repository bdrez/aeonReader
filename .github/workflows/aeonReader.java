package Summer;
import java.util.*;
import java.io.*;

public class aeonReader {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Set to store no duplicates
        Set<String> genes = new HashSet<>();
        List<String[]> relationships = new ArrayList<>();

        File file = new File("C:\\Users\\blimy\\OneDrive\\Desktop\\modle3.txt");
        String newReinFilePath = "C:\\Users\\blimy\\OneDrive\\Desktop\\outputFile.rein";
        BufferedWriter reinWriter = new BufferedWriter(new FileWriter(newReinFilePath));
        
        Scanner sc = new Scanner(file);
        
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

        // write the genes with defualt settings
        for (String gene : genes) {
            reinWriter.write(gene + " (0..17); ");
        }
        reinWriter.newLine();

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

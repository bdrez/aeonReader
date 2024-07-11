package Summer;
import java.util.*;
import java.io.*;

public class aeonReader {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //ask the user for a rein file - and then write into it?
        String one = "";
        String two = "";
        String three = "";
        File file = new File("C:\\Users\\blimy\\OneDrive\\Desktop\\modle3.txt");
        //File file = new File("C:\\Users\\blimy\\OneDrive\\Desktop\\model4.txt");
        //File file = new File ("C:\\Users\\blimy\\OneDrive\\Desktop\\model5.txt");
        String newReinFilePath = "C:\\Users\\blimy\\OneDrive\\Desktop\\outputFile.rein";
        BufferedWriter reinWriter = new BufferedWriter(new FileWriter(newReinFilePath));

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) { // and ir doesnt startb with $
            String line = sc.nextLine(); //
            String modifiedLine = line.replace("v_", "");
            if ((line.charAt(0) == '$')) {
                break;
            }else{
                String[] parts = modifiedLine.split(" ");
                one = parts[0];
                two = parts[1];
                three = parts[2];
            }
            if (two.equals("->")) {
                reinWriter.write(one + " " + three + " positive;");
                //System.out.println(one +  " "+ three+ " positve");
            } else if (two.equals("-|")) {
                reinWriter.write(one + " " + three + " negative;");
                //System.out.println(one+ " "+ three + " negative");
            } else if (two.equals("->?")) {
                reinWriter.write(one + " " + three + " positive optional;");
                //System.out.println(one+ " "+ three + " positive optional");
            } else if (two.equals("-|?")) {
                reinWriter.write(one + " " + three + " negative optional;");
                //System.out.println(one+ " "+ three + " negative optional");
            } else {
                reinWriter.write(one + " " + three + " ?;");
                //System.out.println(one+ " "+ three + " ?");
                //What should we do about the -?
            }
            reinWriter.newLine();
        }
        reinWriter.close();
    }
}


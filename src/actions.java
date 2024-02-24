import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class actions {



    public static void loadKb(String filename) throws FileNotFoundException {
        File text = new File(filename);
        Scanner scnr = new Scanner(text);

        ArrayList<String> lines = new ArrayList<>();
        int numLines = 1;

        while (scnr.hasNextLine()) {
            lines.add(scnr.nextLine());
            numLines++;
        }


        Record[] records = new Record[numLines];

        for (int i = 0; i < lines.size(); i++) {
            String term = lines.get(i).split("\t")[0];
            String statement = lines.get(i).split("\t")[1];
            Double confidence = Double.valueOf(lines.get(i).split("\t")[2]);
            Record record = new Record(term, statement, confidence);
            records[i] = record;

        }
        System.out.println("Loadeddddd");
    }

    public static void addStatement(String term, String statement, double confidence) {

        Record record = new Record(term, statement, confidence);
        //addToBST(record);

        System.out.println("added");
    }

    public static String searchByTerm(String term) {
        System.out.println("searched " + term);
        return "";
    }

    public static String termAndStatement(String term, String statement) {
        System.out.println("searched");
        return "";
    }
}

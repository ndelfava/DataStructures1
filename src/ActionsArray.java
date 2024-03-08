import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionsArray {

    static Record[] records;


    public static void loadKb(String filename) throws FileNotFoundException {
        File text = new File(filename);
        Scanner scnr = new Scanner(text);

        ArrayList<String> lines = new ArrayList<>();
        int numLines = 1;

        while (scnr.hasNextLine()) {
            lines.add(scnr.nextLine());
            numLines++;
        }

        if (records == null) {
            records = new Record[numLines-1];

            for (int i = 0; i < lines.size(); i++) {
                String term = lines.get(i).split("\t")[0];
                String statement = lines.get(i).split("\t")[1];
                Double confidence = Double.valueOf(lines.get(i).split("\t")[2]);
                Record record = new Record(term, statement, confidence);
                records[i] = record;
            }

            System.out.println("Loadeddddd");

        }
        else {

            for (int i = 0; i < lines.size(); i++) {
                String term = lines.get(i).split("\t")[0];
                String statement = lines.get(i).split("\t")[1];
                Double confidence = Double.valueOf(lines.get(i).split("\t")[2]);
                for (int j=0; j< records.length; j++) {
                    if ((term.equals(records[j].getTerm()) && (confidence >= records[j].getConfidence()))) {
                        Record r = new Record(term, statement, confidence);
                        records[j] = r;
                    }
                }
            }
            System.out.println("All items updated.");


        }




    }


    public static void searchByTerm(String t) {
        if (records == null) {
            System.out.println("No data loaded into the system. Please select a file in option (1) and try again...");
        }
        else {
            for (int i=0;i < records.length; i++) {
                if (records[i].getTerm().equals(t)) {
                    System.out.println("Statement found: " + records[i].getStatement() + " (Confidence score: " + records[i].getConfidence() + ")");
                    break;
                }
                if (i == records.length && !(records[i].getTerm().equals(t))) {
                    System.out.println("No record found with given term.");

                }

            }

        }
    }

    public static void termAndStatement(String t, String s) {
        if (records == null) {
            System.out.println("No data loaded into the system. Please select a file in option (1) and try again...");
        }
        else {
            for (int i=0;i < records.length; i++) {
                if (records[i].getTerm().toLowerCase().equals(t) && records[i].getStatement().toLowerCase().equals(s)) {
                    System.out.println("The statement was found and has a confidence score of " + records[i].getConfidence() + ".");
                    break;
                }

            }
            System.out.println("No record found with given term.");

        }

    }
}

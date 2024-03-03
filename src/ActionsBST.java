import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionsBST {

    static BinaryTree records;


    public static void loadKbBST(String filename) throws FileNotFoundException {
        File text = new File(filename);
        Scanner scnr = new Scanner(text);

        ArrayList<String> lines = new ArrayList<>();
        int numLines = 1;

        while (scnr.hasNextLine()) {
            lines.add(scnr.nextLine());
            numLines++;
        }

        if (records == null) {

            records = new BinaryTree();

            for (int i = 0; i < lines.size(); i++) {
                String term = lines.get(i).split("\t")[0];
                String statement = lines.get(i).split("\t")[1];
                Double confidence = Double.valueOf(lines.get(i).split("\t")[2]);
                records.addNode(term, statement, confidence);
            }
            System.out.println("Loadeddd");

        }
        else {
            for (int i = 0; i < lines.size(); i++) {
                String term = lines.get(i).split("\t")[0];
                String statement = lines.get(i).split("\t")[1];
                Double confidence = Double.valueOf(lines.get(i).split("\t")[2]);
                if ((records.search(records.root, term) != null)) {
                    records.search(records.root, term).statement = statement;
                    records.search(records.root, term).confidence = confidence;
                }
            }
            System.out.println("All items updated.");
        }


    }

    public static void addStatement(String term, String statement, double confidence) {
        if (records.search(records.root, term) != null) {
            System.out.println("Term already in database.");
        }
        else {
            records.addNode(term, statement, confidence);
            System.out.println("added");
        }


    }

    public static void searchByTerm(String t) {
        Node n = records.search(records.root, t);
        if (n == null) {
            System.out.println("Nothing found.");
        } else {
            System.out.println("Statement found: " + n.statement + " (Confidence level: " + n.confidence + ")");
        }
    }


    public static void termAndStatement(String term, String statement) {
        Node n = records.search(records.root, term);
        if (n == null) {
            System.out.println("Nothing found.");
        } else {
            if (n.statement.toLowerCase().equals(statement)) {
                System.out.println("The statement was found and has a confidence score of " + n.confidence + ".");
            }
        }
    }

}


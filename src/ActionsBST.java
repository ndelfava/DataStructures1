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

        records = new BinaryTree();

        for (int i = 0; i < lines.size(); i++) {
            String term = lines.get(i).split("\t")[0];
            String statement = lines.get(i).split("\t")[1];
            Double confidence = Double.valueOf(lines.get(i).split("\t")[2]);
            records.addNode(term, statement, confidence);

        }
        System.out.println("Loadeddd");
    }

    public static void addStatement(String term, String statement, double confidence) {

        records.addNode(term, statement, confidence);

        System.out.println("added");
    }

    public static void searchByTerm(String term) {

//        if (records.search(records.root, term) == null) {
//            System.out.println("Sorry, found nawt :(");
//        }
//        else {
//            System.out.println("Statement found: " + records.search(records.root, term).statement + " (Confidence Score: " + records.search(records.root, term).confidence + ")");
//        }
        records.inOrderTraverse(false, records.root, term);

    }

    public static String termAndStatement(String term, String statement) {
        System.out.println("searched");
        return "";
    }
}


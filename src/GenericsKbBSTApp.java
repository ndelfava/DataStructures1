
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;


public class GenericsKbBSTApp {

    static int action;


    public static void main(String[] args) throws FileNotFoundException {

        final Scanner keyboard = new Scanner(System.in);


        System.out.println("Choose an action from the menu:\n" +
                "1. Load a knowledge base from a file\n" +
                "2. Add a new statement to the knowledge base\n" +
                "3. Search for an item in the knowledge base by term\n" +
                "4. Search for a item in the knowledge base by term and sentence\n" +
                "5. Quit\n" +
                "Enter your choice: ");

        action = keyboard.nextInt();
        keyboard.nextLine();

        while (action != 5) {

            switch (action) {
                case 1:
                    System.out.println("Enter file name: ");
                    String filename = keyboard.nextLine();
                    ActionsBST.loadKbBST(filename);
                    break;
                case 2:
                    System.out.println("Enter the term: ");
                    String addTerm = keyboard.nextLine();
                    System.out.println("Enter the statement: ");
                    String addState = keyboard.nextLine();
                    System.out.println("Enter the confidence score: ");
                    double confidence = parseDouble(keyboard.nextLine());
                    ActionsBST.addStatement(addTerm, addState, confidence);
                    break;
                case 3:
                    System.out.println("Enter the term to search: ");
                    String term = keyboard.nextLine();
                    ActionsBST.searchByTerm(term);
                    break;
                case 4:
                    System.out.println("Enter the term: ");
                    String term4 = keyboard.nextLine();
                    System.out.println("Enter the statement to search for: ");
                    String state = keyboard.nextLine();
                    ActionsBST.termAndStatement(term4, state);
                    break;
                case 5:
                    System.exit(0);

                    break;
                default:
                    System.out.println("Please enter a number between 1-5 and try again: ");
                    action = keyboard.nextInt();
                    break;
            }
            System.out.println("Choose an action from the menu:\n" +
                    "1. Load a knowledge base from a file\n" +
                    "2. Add a new statement to the knowledge base\n" +
                    "3. Search for an item in the knowledge base by term\n" +
                    "4. Search for a item in the knowledge base by term and sentence\n" +
                    "5. Quit\n" +
                    "Enter your choice: ");
            action = keyboard.nextInt();
            keyboard.nextLine();
        }

    }


}


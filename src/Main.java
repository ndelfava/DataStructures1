import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;


public class Main {

    static int action;


    public static void main(String[] args) throws FileNotFoundException {

        final Scanner keyboard = new Scanner(System.in);


        System.out.println("Choose an action from the menu:\n" +
                "1. Load a knowledge base from a file\n" +
                "2. Search for an item in the knowledge base by term\n" +
                "3. Search for a item in the knowledge base by term and sentence\n" +
                "4. Quit\n" +
                "Enter your choice: ");

        action = keyboard.nextInt();
        keyboard.nextLine();

        while (action != 4) {

            switch (action) {
                case 1:
                    System.out.println("Enter file name: ");
                    String filename = keyboard.nextLine();
                    actions.loadKb(filename);
                    break;
//                case 2:
//                    System.out.println("Enter the term: ");
//                    String addTerm = keyboard.nextLine();
//                    System.out.println("Enter the statement: ");
//                    String addState = keyboard.nextLine();
//                    System.out.println("Enter the confidence score: ");
//                    double confidence = parseDouble(keyboard.nextLine());
//                    actions.addStatement(addTerm, addState, confidence);
//                    break;
                case 2:
                    System.out.println("Enter the term to search: ");
                    String term = keyboard.nextLine();
                    actions.searchByTerm(term);
                    break;
                case 3:
                    System.out.println("Enter the term: ");
                    String term4 = keyboard.nextLine().toLowerCase();
                    System.out.println("Enter the statement to search for: ");
                    String state = keyboard.nextLine().toLowerCase();
                    actions.termAndStatement(term4, state);
                    break;
                case 4:
                    System.exit(0);

                    break;
                default:
                    System.out.println("Please enter a number between 1-4 and try again: ");
                    action = keyboard.nextInt();
                    break;
                }
            System.out.println("Choose an action from the menu:\n" +
                    "1. Load a knowledge base from a file\n" +
                    "2. Search for an item in the knowledge base by term\n" +
                    "3. Search for a item in the knowledge base by term and sentence\n" +
                    "4. Quit\n" +
                    "Enter your choice: ");
            action = keyboard.nextInt();
            keyboard.nextLine();
            }

        }


    }

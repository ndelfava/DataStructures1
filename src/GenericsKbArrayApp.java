import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GenericsKbArrayApp {

    static String action;


    public static void main(String[] args) throws FileNotFoundException, InputMismatchException {

        final Scanner keyboard = new Scanner(System.in);


        System.out.println("Choose an action from the menu:\n" +
                "1. Load a knowledge base from a file\n" +
                "2. Search for an item in the knowledge base by term\n" +
                "3. Search for a item in the knowledge base by term and sentence\n" +
                "4. Quit\n" +
                "Enter your choice: ");


        action = keyboard.next();

        keyboard.nextLine();

        while (true) {
            try {
                Integer.parseInt(action);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                System.out.println("Choose an action from the menu:\n" +
                        "1. Load a knowledge base from a file\n" +
                        "2. Add a new statement to the knowledge base\n" +
                        "3. Search for an item in the knowledge base by term\n" +
                        "4. Search for a item in the knowledge base by term and sentence\n" +
                        "5. Quit\n" +
                        "Enter your choice: ");
                action = keyboard.next();
                keyboard.nextLine();
            }
        }

        while (Integer.parseInt(action) != 4) {

            switch (Integer.parseInt(action)) {
                case 1:
                    System.out.println("Enter file name: ");
                    String filename = keyboard.nextLine();
                    ActionsArray.loadKb(filename);
                    break;
                case 2:
                    System.out.println("Enter the term to search: ");
                    String term = keyboard.nextLine();
                    ActionsArray.searchByTerm(term);
                    break;
                case 3:
                    System.out.println("Enter the term: ");
                    String term4 = keyboard.nextLine().toLowerCase();
                    System.out.println("Enter the statement to search for: ");
                    String state = keyboard.nextLine().toLowerCase();
                    ActionsArray.termAndStatement(term4, state);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a number between 1-4 and try again: ");
                    break;
            }
            System.out.println("Choose an action from the menu:\n" +
                    "1. Load a knowledge base from a file\n" +
                    "2. Search for an item in the knowledge base by term\n" +
                    "3. Search for a item in the knowledge base by term and sentence\n" +
                    "4. Quit\n" +
                    "Enter your choice: ");
            action = keyboard.next();
            keyboard.nextLine();
        }


    }


}



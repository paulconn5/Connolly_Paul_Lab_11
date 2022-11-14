import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String option = "";
        boolean confirm = true;

        do {
            option = getRegExString(in, "\nAdd - A \nDelete - D\nPrint - P\nQuit - Q\n", "[AaDdPpQq]");
            if (option.equalsIgnoreCase("A")) {addItem(in, list);}
            else if (option.equalsIgnoreCase("D")) {removeItem(in, list); }
            else if (option.equalsIgnoreCase("P")) {printItems(list);}
            else if (option.equalsIgnoreCase("Q")) {confirm = getYNConfirm(in, "Are you sure?");
            }


        } while(confirm);



    }

    public static void addItem(Scanner in, ArrayList<String> list) {
        System.out.println("Enter the string to add: ");
        String item = in.nextLine();
        list.add(item);
    }

    public static void removeItem(Scanner in, ArrayList<String> list) {
        int pos = getRangedInt(in, "Enter the index to remove: ", 0, list.size()-1);
        list.remove(pos);
    }

    public static void printItems(ArrayList<String> list) {
        for (int i=0; i<list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean done = false;
        String retString;
        do {
            System.out.print("\n" + prompt +": "); // show prompt add space
            retString = pipe.nextLine();
            if (retString.matches(regEx)) {
                done = true;
            }
            else {System.out.println("You must follow the regex pattern!");}
        } while(!done);

        return retString;

    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean complete = false;
        boolean retBool = false;
        String retString;
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
            if (retString.equalsIgnoreCase("Y")) {
                complete = true;
            }
            else if (retString.equalsIgnoreCase("N")) {
                complete = true;
                retBool = true;
            }
            else {
                System.out.println("Enter [Y/N]");
            }
        }while(!complete);
        return retBool;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        boolean done = false;
        int retInt = 0;
        do {
            System.out.print("\n" + prompt + low + "-" + high + ": "); // show prompt add space
            if(pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                if (retInt >= low && retInt <= high) {
                    done = true;
                }
                else {
                    System.out.println("You must enter an integer between " + low + "-" + high);
                }
            } else {
                System.out.println("You must enter an integer.");
            }
            pipe.nextLine();
        }while(!done);
        return retInt;
    }
}
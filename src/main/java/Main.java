import java.util.Scanner;
public class Main {
    static Library lib = new Library();

    Librarian manager = new Librarian();

    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our library! Are you a regular user or a librarian? \n1. User \n2. Librarian \n0. Close program");
        int userOrLibrarian = input.nextInt();
        while (userOrLibrarian != 0) {
            if (userOrLibrarian == 1) {
                loggingInAsAUser();
            }
            else if (userOrLibrarian == 2) {
                //loggingInAsALibrarian();
            }
            else {
                System.out.println("Invalid input. Make sure you enter either 1 or 2.");
            }
        }
        return;
    }

    public static void loggingInAsAUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you already have an account? \n1. Yes \n2. No");
        int existingAccount = input.nextInt();
        if (existingAccount == 1) {
            userLogin();
        }
        if (existingAccount == 2) {
            userSignup();
        }
    }
    public static void userSignup() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please type in a username: ");
        String username = input.nextLine();
        if (lib.usernameTaken(username)) {
            do {
                System.out.println("This username is already taken. Please choose another one: ");
                username = input.nextLine();
            }
            while (lib.usernameTaken(username));
        }
        System.out.println("Now choose a password that you won't forget later on: ");
        String password = input.nextLine();
    }
    public static void userLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.next();
        System.out.println("Password: ");
        String password = input.next();
        while (!lib.doesUserExist(username, password)) {
                System.out.println("Password is incorrect or no such username exists. Are you sure you have an account? \n1. Yes \n2. No. Take me to the signup page.");
                int doubt = input.nextInt();
                if (doubt == 1){
                    System.out.println("Username: ");
                    username = input.next();
                    System.out.println("Password: ");
                    password = input.next();
                }
                else if (doubt == 2) {
                    userSignup();
                    break;
                }
                else {
                    System.out.println("Please choose either 1 if you're positive you have an account or 2 if you want to creat a new one.");
                }
        }
    }
}

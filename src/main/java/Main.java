import java.util.Scanner;
public class Main {
    static Library lib = new Library();
    static Librarian manager = new Librarian("manager", "IAmInCharge!");

    //I can't use lib.addLibrarian to add the first librarian.

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
        System.out.println("\nWelcome to our library! Are you a regular user or a librarian? \n1. User \n2. Librarian \n0. Close program");
        int userOrLibrarian = input.nextInt();
        while (userOrLibrarian != 0) {
            if (userOrLibrarian == 1) {
                loggingInAsAUser();
                userMainMenu();
            }
            else if (userOrLibrarian == 2) {
                loggingInAsALibrarian();
            }
            else {
                System.out.println("\nInvalid input. Make sure you enter either 1 or 2.");
            }
        }
        return;
    }

    //Login methods
    public static void loggingInAsAUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nDo you already have an account? \n1. Yes \n2. No");
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
        System.out.println("\nPlease type in a username: ");
        String username = input.nextLine();
        if (lib.usernameTaken(username)) {
            do {
                System.out.println("\nThis username is already taken. Please choose another one: ");
                username = input.nextLine();
            }
            while (lib.usernameTaken(username));
        }
        System.out.println("Now choose a password that you won't forget later on: ");
        String password = input.nextLine();
        lib.addUser(username, password);    //I get an error when I get to this part.
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

    public static void loggingInAsALibrarian() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nDo you already have an account? \n1. Yes \n2. No");
        int existingAccount = input.nextInt();
        if (existingAccount == 1) {
            librarianLogin();
        }
        if (existingAccount == 2) {
            librarianSignup();
        }
    }
    public static void librarianSignup() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease type in a username: ");
        String username = input.nextLine();
        if (lib.librarianUsernameTaken(username)) {
            do {
                System.out.println("This username is already taken. Please choose another one: ");
                username = input.nextLine();
            }
            while (lib.librarianUsernameTaken(username));
        }
        System.out.println("Now choose a password that you won't forget later on: ");
        String password = input.nextLine();
        lib.addLibrarian(username, password);
    }
    public static void librarianLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.next();
        System.out.println("Password: ");
        String password = input.next();
        while (!lib.doesLibrarianExist(username, password)) {
            System.out.println("\nPassword is incorrect or no such username exists. Are you sure you have an account? \n1. Yes \n2. No. Take me to the signup page.");
            int doubt = input.nextInt();
            if (doubt == 1){
                System.out.println("Username: ");
                username = input.next();
                System.out.println("Password: ");
                password = input.next();
            }
            else if (doubt == 2) {
                librarianSignup();
                break;
            }
            else {
                System.out.println("\nPlease choose either 1 if you're positive you have an account or 2 if you want to creat a new one.");
            }
        }
    }

    //Main menu methods
    public static void userMainMenu() {
        System.out.println("\nWelcome to your personal library page! What would you like to do? \n1. Borrow a book \n2. Return a book \n0. Exit");
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();
        if (userChoice == 1) {
            borrowBook();
        }
        else if (userChoice == 2) {
            returnBook();
        }
        else if (userChoice == 0) {
            return;
        }
    }

    public static void borrowBook() {
        lib.showAllBooks();
        System.out.println("\nEnter the title of the book you want to borrow: ");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
    }

    public static void returnBook() {

    }
}
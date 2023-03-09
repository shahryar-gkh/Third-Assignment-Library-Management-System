import java.util.Scanner;
public class Main {
    static Library lib = new Library();
    static String loggedInUsername = "";


    /*
    * make a functional library app using oop
    * run the main program in Main.java and code the oop part in other classes
    * don't forget to add at least 1 librarian to the library to make it functionable.
    * *  *** don't limit yourself to our template ***
     */

    public static void main(String[] args) {
        lib.addLibrarian("manager", "poop!");
        runMenu();
    }

    public static void runMenu(){
        Scanner input = new Scanner(System.in);
        int userOrLibrarian = 0;
        do {
            System.out.println("\nWelcome to our library! Are you a regular user or a librarian? \n1. User \n2. Librarian \n0. Close program");
            userOrLibrarian = input.nextInt();
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
        } while(userOrLibrarian != 0);
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
        loggedInUsername = username;
        System.out.println("Now choose a password: ");
        String password = input.nextLine();
        lib.addUser(loggedInUsername, password);    //I get an error when I get to this part.
    }
    public static void userLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nUsername: ");
        String username = input.next();
        System.out.println("Password: ");
        String password = input.next();
        while (!lib.doesUserExist(username, password)) {
                System.out.println("\nPassword is incorrect or no such username exists. Are you sure you have an account? \n1. Yes \n2. No. Take me to the signup page.");
                int doubt = input.nextInt();
                if (doubt == 1){
                    System.out.println("\nUsername: ");
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
        loggedInUsername = username;
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
                System.out.println("\nThis username is already taken. Please choose another one: ");
                username = input.nextLine();
            }
            while (lib.librarianUsernameTaken(username));
        }
        loggedInUsername = username;
        System.out.println("Now choose a password: ");
        String password = input.nextLine();
        lib.addLibrarian(loggedInUsername, password);
    }
    public static void librarianLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nUsername: ");
        String username = input.next();
        System.out.println("Password: ");
        String password = input.next();
        while (!lib.doesLibrarianExist(username, password)) {
            System.out.println("\nPassword is incorrect or no such username exists. Are you sure you have an account? \n1. Yes \n2. No. Take me to the signup page.");
            int doubt = input.nextInt();
            if (doubt == 1){
                System.out.println("\nUsername: ");
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
        loggedInUsername = username;
    }

    //Main menu methods
    public static void userMainMenu() {
        int userChoice;
        do {
            System.out.println("\nWelcome to your personal library page! What would you like to do?\n1. View a list of the books you've borrowed.\n2. Borrow a book\n3. Return a book\n4. Change password\n0. Log out");
            Scanner input = new Scanner(System.in);
            userChoice = input.nextInt();
            if (userChoice == 1) {
                lib.showBooksUserBorrowed(loggedInUsername);
            }
            else if (userChoice == 2) {
                rentBook();
            }
            else if (userChoice == 3) {
                returnBook();
            }
            else if (userChoice == 4) {
                changeUserPassword();
            }
        }
        while (userChoice != 0);
    }

    public static void rentBook() {
        lib.showAllBooks();
        System.out.println("\nEnter the title of the book you want to rent:");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        if (!lib.doesBookExist(title)) {
            do {
                System.out.println("\nNo book with this title exists. Make sure you're typing in the full title of the book: \n(Enter \"e\" if you want to return to the menu)");
                title = input.nextLine();
            }
            while (!lib.doesBookExist(title) && !title.equals("e"));
        }
        else {
            lib.searchBook(title);
            System.out.println("Is this the book you want to rent?\n1. Yes\n2. No");
            int borrowOrNot = input.nextInt();
            if (borrowOrNot == 1) {
                lib.decreaseBook(title);
                lib.updateUserBorrowingBook(loggedInUsername, title);
                System.out.println("\nYou've just rented \"" + title + "\"! Enjoy Reading!\nA list of the books you have rented and haven't returned:");
                lib.showBooksUserBorrowed(loggedInUsername);
            }
        }
    }

    public static void returnBook() {
        lib.showBooksUserBorrowed(loggedInUsername);
        System.out.println("Which one of these books are you returning?");
        Scanner input = new Scanner(System.in);
        String bookGettingReturned = input.nextLine();
        if (!lib.hasUserRentedBook(loggedInUsername, bookGettingReturned)) {
            do {
                System.out.println("\nYou haven't rented this book. Make sure you're typing in the full title of the book: \n(Enter \"e\" if you want to return to the menu)");
                bookGettingReturned = input.nextLine();
            }
            while (!lib.hasUserRentedBook(loggedInUsername, bookGettingReturned) && !bookGettingReturned.equals("e"));
        }
        else {
            lib.increaseBook(bookGettingReturned);
            lib.updateUserReturningBook(loggedInUsername, bookGettingReturned);
            System.out.println("\nThank you for returning \"" + bookGettingReturned + "\"! Hope you enjoyed reading!\nA list of the books you have rented and haven't returned:");
            lib.showBooksUserBorrowed(loggedInUsername);
        }
    }

    public static void changeUserPassword(){
        System.out.println("\nWhat would you like your new password to be?");
        Scanner input = new Scanner(System.in);
        String newPassword = input.nextLine();
        lib.updateUserPassword(loggedInUsername, newPassword);
        System.out.println("\nPassword was changed successfully!");
    }
}
import java.util.Scanner;
public class Main {
    static Library lib = new Library();
    static String loggedInUsername = "";

    public static void main(String[] args) {
        lib.addLibrarian("manager", "BO$$");
        runMenu();
    }

    public static void runMenu(){
        Scanner input = new Scanner(System.in);
        int userOrLibrarian ;
        do {
            System.out.println("\nWelcome to our library! Are you a regular user or a librarian? \n1. User \n2. Librarian \n0. Close program");
            userOrLibrarian = input.nextInt();
            if (userOrLibrarian == 1) {
                loggingInAsAUser();
                userMainMenu();
            }
            else if (userOrLibrarian == 2) {
                loggingInAsALibrarian();
                librarianMainMenu();
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
    public static String userSignupWithoutLogin() {
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
        System.out.println("Now choose a password: ");
        String password = input.nextLine();
        lib.addUser(username, password);
        return username;
    }
    public static void userSignup() {
        loggedInUsername = userSignupWithoutLogin();
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
    public static String librarianSignupWithoutLogin() {
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
        System.out.println("Now choose a password: ");
        String password = input.nextLine();
        lib.addLibrarian(username, password);
        return username;
    }
    public static void librarianSignup() {
        loggedInUsername = librarianSignupWithoutLogin();
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

    //User main menu methods
    public static void userMainMenu() {
        int userChoice;
        do {
            System.out.println("\nWelcome to your personal library page! What would you like to do?\n1. View a list of the books you've borrowed.\n2. Rent a book\n3. Return a book\n4. Change password\n0. Log out");
            Scanner input = new Scanner(System.in);
            userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    lib.showBooksUserBorrowed(loggedInUsername);
                    break;
                case 2:
                    rentBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    changeUserPassword();
                    break;
            }
        }
        while (userChoice != 0);
    }

    public static void rentBook() {
        lib.showAllBooks();
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the title of the book you want to rent (Enter \"e\" if you want to return to the menu):");
        String title;
        while(true) {
            title = input.nextLine();
            if (title.equals("e")) {
                return;
            }
            else if (!lib.doesBookExist(title)) {
                System.out.println("\nNo book with this title exists. Make sure you're typing in the full title of the book (Enter \"e\" if you want to return to the menu):");
            }
            else {
                break;
            }
        }
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

    public static void returnBook() {
        lib.showBooksUserBorrowed(loggedInUsername);
        System.out.println("Which one of these books are you returning? (Enter \"e\" if you want to return to the menu)");
        Scanner input = new Scanner(System.in);
        String title;
        while(true) {
            title = input.nextLine();
            if (title.equals("e")) {
                return;
            }
            else if (!lib.hasUserRentedBook(loggedInUsername, title)) {
                System.out.println("\nYou haven't rented this book. Make sure you're typing in the full title of the book (Enter \"e\" if you want to return to the menu):");
            }
            else {
                break;
            }
        }
        lib.increaseBook(title);
        lib.updateUserReturningBook(loggedInUsername, title);
        System.out.println("\nThank you for returning \"" + title + "\"! Hope you enjoyed reading!\nA list of the books you have rented and haven't returned:");
        lib.showBooksUserBorrowed(loggedInUsername);
    }

    public static void changeUserPassword(){
        System.out.println("\nWhat would you like your new password to be?");
        Scanner input = new Scanner(System.in);
        String newPassword = input.nextLine();
        lib.updateUserPassword(loggedInUsername, newPassword);
        System.out.println("\nPassword was changed successfully!");
    }

    //Librarian main menu methods
    public static void librarianMainMenu(){
        int librarianChoice;
        do {
            System.out.println("\nWelcome to your personal librarian page! What would you like to do?\n1. View a list of all available books\n2. Search for a book\n3. Add a new book\n4. Remove a book\n5. Search for a user\n6. Add a user\n7. Remove a user\n8. Search for a librarian\n9. Add a librarian\n10. Remove a librarian\n11. Change password\n0. Log out");
            Scanner input = new Scanner(System.in);
            librarianChoice = input.nextInt();
            boolean flag = true;
            while (flag) {
                flag = false;
                switch (librarianChoice) {
                    case 1: {
                        lib.showAllBooks();
                        break;
                    }
                    case 2: {
                        flag = searchBook() ;
                        break;
                    }
                    case 3: {
                        flag = addNewBook() ;
                        break;
                    }
                    case 4: {
                        removeBook();
                        break;
                    }
                    case 5: {
                        flag = searchUser() ;
                        break;
                    }
                    case 6: {
                        userSignupWithoutLogin();
                        break;
                    }
                    case 7: {
                        removeUser();
                        break;
                    }
                    case 8: {
                        flag = searchLibrarian();
                        break;
                    }
                    case 9: {
                        librarianSignupWithoutLogin();
                        break;
                    }
                    case 10: {
                        removeLibrarian();
                        break;
                    }
                    case 11: {
                        changeLibrarianPassword();
                        break;
                    }
                }
            }
        }
        while (librarianChoice != 0);
    }
    public static boolean searchBook() {
        System.out.println("\nEnter the name of the book you're searching for (Enter \"e\" to exit):");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        if (lib.doesBookExist(title)) {
            lib.searchBook(title);
            if (lib.numberOfBooksAvailable(title) == 0) {
                System.out.println("This book isn't available at the moment.");
            }
            else {
                System.out.println("There are " + lib.numberOfBooksAvailable(title) + " copies of this book left.");
            }
            return true;
        }
        else if (title.equals("e")) {
            return false;
        }
        else {
            System.out.println("Book doesn't exist.");
            return true;
        }
    }
    public static boolean addNewBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of this book:");
        String title = input.nextLine();
        System.out.println("Enter the author's full name:");
        String author = input.nextLine();
        System.out.println("Enter the book's year of publish:");
        int year = input.nextInt();
        System.out.println("Enter the book's ISBN (without the hyphens):");
        long isbn = input.nextLong();
        System.out.println("How many copies of this book are being added?");
        int numberOfCopies = input.nextInt();
        lib.addBook(title, author, year, isbn, numberOfCopies);
        System.out.println(numberOfCopies + " copies of this book were added.\nWould you like to add another book?\n1. Yes\n2. No");
        int addOrNot = input.nextInt();
        if (addOrNot == 1) {
            return true;
        }
        return false;
    }
    public static void removeBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the title of the book you want to remove:");
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
            System.out.println("Are you sure you want to remove this book from the library?\n1. Yes\n2. No");
            int removingChoice = input.nextInt();
            if (removingChoice == 1) {
                lib.removeBook(title);
                System.out.println(title + " was removed successfully.");
            }
        }
    }
    public static boolean searchUser() {
        System.out.println("\nEnter the username (Enter \"e\" to exit):");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        if (lib.usernameTaken(username)) {
            lib.searchUser(username);
            System.out.println("Books they've borrowed:");
            lib.showBooksUserBorrowed(username);
            return true;
        }
        else if (username.equals("e")) {
            return false;
        }
        else {
            System.out.println("User doesn't exist.");
            return true;
        }
    }
    public static void removeUser() {
        System.out.println("\nEnter the username of the user you want to remove:");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        if (lib.usernameTaken(username)) {
            System.out.println("Are you sure you want to remove this user from the library?\n1. Yes\n2. No");
            int choice = input.nextInt();
            if (choice == 1) {
                lib.removeUser(username);
                System.out.println(username + " was removed successfully.");
            }
        }
        else {
            System.out.println("User doesn't exist.");
        }
    }
    public static boolean searchLibrarian() {
        System.out.println("\nEnter the librarian's username (Enter \"e\" to exit):");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        if (lib.librarianUsernameTaken(username)) {
            lib.searchLibrarian(username);
            return true;
        }
        else if (username.equals("e")) {
            return false;
        }
        else {
            System.out.println("Librarian doesn't exist.");
            return true;
        }
    }
    public static void removeLibrarian() {
        System.out.println("\nEnter the username of the librarian you want to remove:");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        if (lib.librarianUsernameTaken(username)) {
            System.out.println("Are you sure you want to remove this librarian from the library?\n1. Yes\n2. No");
            int choice = input.nextInt();
            if (choice == 1) {
                lib.removeLibrarian(username);
                System.out.println(username + " was removed successfully.");
            }
        }
        else {
            System.out.println("Librarian doesn't exist.");
        }
    }
    public static void changeLibrarianPassword(){
        System.out.println("\nWhat would you like your new password to be?");
        Scanner input = new Scanner(System.in);
        String newPassword = input.nextLine();
        lib.updateLibrarianPassword(loggedInUsername, newPassword);
        System.out.println("\nPassword was changed successfully!");
    }
}
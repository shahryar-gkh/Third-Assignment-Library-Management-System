import java.util.ArrayList;
import java.util.HashMap;
public class Library {
    private ArrayList<Book> listOfBooks = new ArrayList<>();
    private ArrayList<Librarian> listOfLibrarians = new ArrayList<>();
    private ArrayList<User> listOfUsers = new ArrayList<>();
    private HashMap<Long, Integer> copiesLeft = new HashMap<>();

    /*
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    //book related functions

    public void addBook(String name, String author, int yearOfPublish, long isbn, int numberOfCopies){
        Book newBook = new Book(name, author, yearOfPublish, isbn);
        listOfBooks.add(newBook);
        copiesLeft.put(isbn, numberOfCopies);
    }

    public void removeBook(String name){
        long isbn = nameToISBN(name);
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (name.equals(listOfBooks.get(i).getName())) {
                listOfBooks.remove(i);
                copiesLeft.remove(isbn);
                break;
            }
        }
    }

    public void searchBook(String name){
        for (Book book : listOfBooks) {
            if (name.equals(book.getName())) {
                System.out.println(book);
                break;
            }
        }
    }

    public void showAllBooks(){
        for (Book book : listOfBooks) {
            if (copiesLeft.get(book.getIsbn()) != 0) {
                System.out.println(book);
            }
        }
    }

    public int numberOfBooksAvailable(String bookTitle) {
        for (Book book : listOfBooks) {
            if (book.getName().equals(bookTitle)) {
                return copiesLeft.get(book.getIsbn());
            }
        }
        return 0;
    }

    public boolean doesBookExist(String name){
        for (Book book : listOfBooks) {
            if (name.equals(book.getName()) && copiesLeft.get(nameToISBN(name)) != 0 ) {
                return true;
            }
        }
        return false;
    }

    public long nameToISBN(String name) {
        long isbn = 0;
        for (Book book : listOfBooks) {
            if (book.getName().equals(name)) {
                isbn = book.getIsbn();
                break;
            }
        }
        return isbn;
    }

    public void increaseBook(String name){
        long isbn = nameToISBN(name);
        int newCopies = (copiesLeft.get(isbn)) + 1;
        copiesLeft.replace(isbn, newCopies);
    }

    public void decreaseBook(String name){
        long isbn = nameToISBN(name);
        int newCopies = (copiesLeft.get(isbn)) - 1;
        copiesLeft.replace(isbn, newCopies);
    }

    //user related functions

    public void addUser(String username, String password){
        User newUser = new User(username, password);
        listOfUsers.add(newUser);
    }

    public void removeUser(String username){
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (username.equals(listOfUsers.get(i).getUsername())) {
                listOfUsers.remove(i);
                break;
            }
        }
    }

    public void searchUser(String username){
        for (User user : listOfUsers) {
            if (username.equals(user.getUsername())) {
                System.out.println(user);
                break;
            }
        }
    }

    public void showBooksUserBorrowed(String username){
        for (User user : listOfUsers) {
            if (username.equals(user.getUsername())) {
                System.out.println(user.getListOfBooksBorrowed());
                break;
            }
        }
    }

    public boolean hasUserRentedBook(String username, String bookTitle) {
        for (User user : listOfUsers) {
            if (user.getUsername().equals(username)) {
                for (String name : user.getListOfBooksBorrowed()) {
                    if (name.equals(bookTitle)) {
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    public void updateUserPassword(String username, String newPassword){
        for (User user : listOfUsers) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                break;
            }
        }
    }
    public void updateUserBorrowingBook(String username, String newBook){
        for (User user : listOfUsers) {
            if (username.equals(user.getUsername())) {
                user.rentBook(newBook);
                break;
            }
        }
    }

    public void updateUserReturningBook(String username, String book){
        for (User user : listOfUsers) {
            if (username.equals(user.getUsername())) {
                user.returnBook(book);
                break;
            }
        }
    }

    public boolean doesUserExist(String username, String password){
        for (User user: listOfUsers) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean usernameTaken(String username){
        for (User user : listOfUsers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //librarian related functions

    public void addLibrarian(String librarianUsername, String librarianPassword){
        Librarian newLibrarian = new Librarian(librarianUsername, librarianPassword);
        listOfLibrarians.add(newLibrarian);
    }

    public void removeLibrarian(String librarianUsername){
        for (int i = 0; i < listOfLibrarians.size(); i++) {
            if (librarianUsername.equals(listOfLibrarians.get(i).getLibrarianUsername())) {
                listOfLibrarians.remove(i);
                break;
            }
        }
    }

    public void searchLibrarian(String librarianUsername){
        for (Librarian librarian : listOfLibrarians) {
            if (librarianUsername.equals(librarian.getLibrarianUsername())) {
                System.out.println(librarian);
                break;
            }
        }
    }

    public void updateLibrarianPassword(String librarianUsername, String newPassword){
        for (Librarian librarian: listOfLibrarians) {
            if (librarian.getLibrarianUsername().equals(librarianUsername)) {
                librarian.setLibrarianPassword(newPassword);
                break;
            }
        }
    }

    public boolean doesLibrarianExist(String librarianUsername, String librarianPassword){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.getLibrarianUsername().equals(librarianUsername)) {
                if (librarian.getLibrarianPassword().equals(librarianPassword)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean librarianUsernameTaken(String librarianUsername){
        for (Librarian librarian : listOfLibrarians) {
            if (librarian.getLibrarianUsername().equals(librarianUsername)) {
                return true;
            }
        }
        return false;
    }
}
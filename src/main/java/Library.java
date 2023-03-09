import java.util.ArrayList;
import java.util.HashMap;
public class Library {
    private ArrayList<Book> listOfBooks = new ArrayList<>();
    private ArrayList<Librarian> listOfLibrarians = new ArrayList<>();
    private ArrayList<User> listOfUsers = new ArrayList<>();
    private HashMap<Integer, Integer> copiesLeft = new HashMap<>();

    /*
    * The library should have a map of books ISBNs which is linked to the amount of book
    -> (for example: harry potter -> 4 means there are currently 4 harry potter books)
    * The library should have a list of users and a list of librarians.
     */

    //book related functions

    public void addBook(String name, String author, int yearOfPublish, int isbn, int numberOfCopies){
        Book newBook = new Book(name, author, yearOfPublish, isbn);
        listOfBooks.set(listOfBooks.size()-1, newBook);
        copiesLeft.put(isbn, numberOfCopies);
    }

    public void removeBook(String name){
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (name.equals(listOfBooks.get(i).getName())) {
                listOfBooks.remove(i);
            }
        }
    }

    public boolean searchBook(String name){
        for (Book book : listOfBooks) {
            if (name.equals(book.getName())) {
                System.out.println(book);
                return true;
            }
        }
        return false;
    }

    public void showAllBooks(){
        for (Book book : listOfBooks) {
            System.out.println(book.toString());
        }
    }

    public void updateBook(){
        //TODO
    }

    public boolean doesBookExist(String name){
        for (Book book : listOfBooks) {
            if (name.equals(book.getName())) {
                return true;
            }
        }
        return false;
    }

    public int nameToISBN(String name) {
        int isbn = 0;
        for (Book book : listOfBooks) {
            if (book.getName().equals(name)) {
                isbn = book.getIsbn();
            }
        }
        return isbn;
    }

    public void increaseBook(String name, int numberOfCopiesReturned){
        int isbn = nameToISBN(name);
        int newCopies = (copiesLeft.get(isbn)) + numberOfCopiesReturned;
        copiesLeft.replace(isbn, newCopies);
    }

    public void decreaseBook(String name, int numberOfCopiesBorrowed){
        int isbn = nameToISBN(name);
        int newCopies = (copiesLeft.get(isbn)) - numberOfCopiesBorrowed;
        copiesLeft.replace(isbn, newCopies);
    }

    //user related functions

    public void addUser(String username, String password){
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        listOfUsers.add(newUser);
    }

    public void removeUser(String username){
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (username.equals(listOfUsers.get(i).getUsername())) {
                listOfUsers.remove(i);
            }
        }
    }

    public boolean searchUser(String username){
        for (User user : listOfUsers) {
            if (username.equals(user.getUsername())) {
                System.out.println(user);
                return true;
            }
        }
        return false;
    }

    public void updateUserBorrowingBook(String username, String newBook){
        for (User user : listOfUsers) {
            if (username.equals(user.getUsername())) {
                user.rentBook(newBook);
            }
        }
    }

    public void updateUserReturningBook(String username, String book){
        for (User user : listOfUsers) {
            if (username.equals(user.getUsername())) {
                user.returnBook(book);
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
            }
        }
    }

    public boolean searchLibrarian(String librarianUsername){
        for (Librarian librarian : listOfLibrarians) {
            if (librarianUsername.equals(librarian.getLibrarianUsername())) {
                System.out.println(librarian);
                return true;
            }
        }
        return false;
    }

    public void updateLibrarian(){
        //TODO
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

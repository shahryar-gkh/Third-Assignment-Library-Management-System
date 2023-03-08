import java.util.ArrayList;
import java.util.HashMap;
public class Library {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();
    private ArrayList<Librarian> listOfLibrarians = new ArrayList<Librarian>();
    private ArrayList<User> listOfUsers = new ArrayList<User>();
    private HashMap<Integer, Integer> copiesLeft = new HashMap<Integer, Integer>();

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
            if (name == listOfBooks.get(i).getName()) {
                listOfBooks.remove(i);
            }
        }
    }

    public boolean searchBook(String name){
        boolean bookExists = false;
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (name == listOfBooks.get(i).getName()) {
                bookExists = true;
                System.out.println(listOfBooks.get(i).toString());
            }
        }
        return bookExists;
    }

    public void updateBook(){
        //TODO
    }

    public boolean doesBookExist(String name){
        boolean exists = false;
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getName() == name) {
                exists = true;
            }
        }
        return exists;
    }

    public int nameToISBN(String name) {
        int isbn = 0;
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getName() == name) {
                isbn = listOfBooks.get(i).getIsbn();
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
        listOfUsers.set(listOfUsers.size()-1, newUser);
    }

    public void removeUser(String username){
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (username == listOfUsers.get(i).getUsername()) {
                listOfUsers.remove(i);
            }
        }
    }

    public boolean searchUser(String username){
        boolean userExists = false;
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (username == listOfUsers.get(i).getUsername()) {
                userExists = true;
                System.out.println(listOfUsers.get(i).toString());
            }
        }
        return userExists;
    }

    public void updateUserBorrowingBook(String username, String newBook){
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (username == listOfUsers.get(i).getUsername()) {
                listOfUsers.get(i).rentBook(newBook);
            }
        }
    }

    public void updateUserReturningBook(String username, String book){
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (username == listOfUsers.get(i).getUsername()) {
                listOfUsers.get(i).returnBook(book);
            }
        }
    }

    public boolean doesUserExist(String username, String password){
        boolean exists = false;
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (listOfUsers.get(i).getUsername() == username) {
                if (listOfUsers.get(i).getPassword() == password) {
                    exists = true;
                }
            }
        }
        return exists;
    }

    public boolean usernameTaken(String username){
        boolean taken = false;
        for (int i = 0; i < listOfUsers.size(); i++) {
            if (listOfUsers.get(i).getUsername() == username) {
                taken = true;
            }
        }
        return taken;
    }

    //librarian related functions

    public void addLibrarian(String librarianUsername, String librarianPassword){
        Librarian newLibrarian = new Librarian();
        newLibrarian.setLibrarianUsername(librarianUsername);
        newLibrarian.setLibrarianPassword(librarianPassword);
        listOfLibrarians.set(listOfLibrarians.size()-1, newLibrarian);
    }

    public void removeLibrarian(String librarianUsername){
        for (int i = 0; i < listOfLibrarians.size(); i++) {
            if (librarianUsername == listOfLibrarians.get(i).getLibrarianUsername()) {
                listOfLibrarians.remove(i);
            }
        }
    }

    public boolean searchLibrarian(String librarianUsername){
        boolean librarianExists = false;
        for (int i = 0; i < listOfLibrarians.size(); i++) {
            if (librarianUsername == listOfLibrarians.get(i).getLibrarianUsername()) {
                librarianExists = true;
                System.out.println(listOfLibrarians.get(i).toString());
            }
        }
        return librarianExists;
    }

    public void updateLibrarian(){
        //TODO
    }

    public boolean doesLibrarianExist(String librarianUsername, String librarianPassword){
        boolean exists = false;
        for (int i = 0; i < listOfLibrarians.size(); i++) {
            if (listOfLibrarians.get(i).getLibrarianUsername() == librarianUsername) {
                if (listOfLibrarians.get(i).getLibrarianPassword() == librarianPassword) {
                    exists = true;
                }
            }
        }
        return exists;
    }

    public boolean librarianUsernameTaken(String librarianUsername){
        boolean taken = false;
        for (int i = 0; i < listOfLibrarians.size(); i++) {
            if (listOfLibrarians.get(i).getLibrarianUsername() == librarianUsername) {
                taken = true;
            }
        }
        return taken;
    }


}

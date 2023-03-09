import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<String> listOfBooksBorrowed = new ArrayList<String>();

    //Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Book {" +
                "Username = '" + username + '\'' +
                ", Password = '" + password + '\'' +
                '}';
    }


    //User should have a list of books

    public void rentBook(String bookTitle){
        listOfBooksBorrowed.add(bookTitle);
    }

    public void returnBook(String bookTitle){
        listOfBooksBorrowed.remove(bookTitle);
    }
}

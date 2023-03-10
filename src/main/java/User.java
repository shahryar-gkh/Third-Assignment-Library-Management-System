import java.util.ArrayList;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    private ArrayList<String> listOfBooksBorrowed = new ArrayList<>();

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
    public ArrayList<String> getListOfBooksBorrowed() {
        return listOfBooksBorrowed;
    }
    @Override
    public String toString(){
        return "User {" +
                "Username = '" + username + '\'' +
                ", Password = '" + password + '\'' +
                '}';
    }
    public void rentBook(String bookTitle){
        listOfBooksBorrowed.add(bookTitle);
    }
    public void returnBook(String bookTitle){
        listOfBooksBorrowed.remove(bookTitle);
    }
}

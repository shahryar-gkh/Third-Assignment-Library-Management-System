public class Librarian {
    private String librarianUsername;
    private String librarianPassword;

    public Librarian(String librarianUsername, String librarianPassword) {
        this.librarianUsername = librarianUsername;
        this.librarianPassword = librarianPassword;
    }

    //Getters
    public String getLibrarianUsername() {
        return librarianUsername;
    }

    public String getLibrarianPassword() {
        return librarianPassword;
    }

    //Setters

    public void setLibrarianUsername(String librarianUsername) {
        this.librarianUsername = librarianUsername;
    }

    public void setLibrarianPassword(String librarianPassword) {
        this.librarianPassword = librarianPassword;
    }

    @Override
    public String toString(){
        return "Librarian {" +
                "Username = '" + librarianUsername + '\'' +
                ", Password = '" + librarianPassword + '\'' +
                '}';
    }
    /*
    * The librarian should be able to search users, librarians and books
    * The librarian should be able to add\remove\\update user add\remove\\update_
    _ librarian and add\remove\\update book
     */


}

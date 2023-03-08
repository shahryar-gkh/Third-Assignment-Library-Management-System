public class Book {
    private String name;
    private String author;
    private int yearOfPublish;
    private int isbn;

    public Book(String name, String author, int yearOfPublish, int isbn) {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.isbn = isbn;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getIsbn() {
        return isbn;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book {" +
                "name = '" + name + '\'' +
                ", author = '" + author + '\'' +
                ", yearOfPublish = " + yearOfPublish +
                ", isbn = " + isbn +
                '}';
    }
}

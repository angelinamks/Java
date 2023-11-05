public class Book {
    String title;
    String author;
    String ISBN;
    int year;

    public Book(String title, String author, String ISBN, int year){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
    }

    @Override
    public String toString(){
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", year=" + year +
                '}';
    }
}

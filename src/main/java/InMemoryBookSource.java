import java.util.List;

public class InMemoryBookSource implements BookSource {

    @Override
    public List<Book> load() {
        return List.of(
                new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling"),
                new Book("The Hobbit", "J. R. R. Tolkien"),
                new Book("1984", "George Orwell")
        );
    }
}
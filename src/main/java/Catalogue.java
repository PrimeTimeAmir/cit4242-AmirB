import java.util.List;

public class Catalogue {

    private final BookSource source;

    public Catalogue(BookSource source) {
        this.source = source;
    }

    public List<Book> books() {
        return source.load();
    }

    public List<String> titlesBy(String author) {
        return books().stream()
                .filter(book -> book.author().equals(author))
                .map(Book::title)
                .sorted()
                .toList();
    }
}
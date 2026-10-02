import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvBookSourceTest {

    @Test
    void csvSourceLoadsBooks() {
        BookSource source = new CsvBookSource("books.csv");

        List<Book> books = source.load();

        assertEquals(50, books.size());
    }
}
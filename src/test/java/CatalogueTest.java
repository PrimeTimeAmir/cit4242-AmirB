import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogueTest {

    @Test
    void catalogueUsesBookSource() {
        BookSource source = new InMemoryBookSource();
        Catalogue catalogue = new Catalogue(source);

        List<Book> books = catalogue.books();

        assertEquals(3, books.size());
    }

    @Test
    void unknownAuthorReturnsEmptyList() {
        BookSource source = new InMemoryBookSource();
        Catalogue catalogue = new Catalogue(source);

        assertEquals(List.of(), catalogue.titlesBy("Unknown Author"));
    }
}
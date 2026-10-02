import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookTest {

    @Test
    void checksBookAuthor() {
        Book book = new Book("1984", "George Orwell");

        assertTrue(book.isWrittenBy("George Orwell"));
        assertFalse(book.isWrittenBy("J. K. Rowling"));
    }
}
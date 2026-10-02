import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvBookSource implements BookSource {

    private final String resource;

    public CsvBookSource(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Book> load() {
        List<Book> books = new ArrayList<>();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(resource)) {

            if (input == null) {
                throw new IllegalArgumentException("Resource not found: " + resource);
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(input, StandardCharsets.UTF_8)
            );

            reader.readLine(); // skip header

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 3);

                if (parts.length == 3) {
                    books.add(new Book(parts[1].trim(), parts[2].trim()));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Could not load books", e);
        }

        return books;
    }
}
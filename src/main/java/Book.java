public record Book(String title, String author) {

    public boolean isWrittenBy(String author) {
        return this.author.equals(author);
    }
}
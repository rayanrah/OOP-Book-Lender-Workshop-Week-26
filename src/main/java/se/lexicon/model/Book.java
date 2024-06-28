package se.lexicon.model;

import java.util.UUID;

public class Book {

    // Specify the variables.

    private String id; // Adding final to make the id read-only
    private String title;
    private String author;
    private boolean available;
    private Person borrower;

    // Constructor 01:
    public Book(String title, String author) {
        this.id = generateIdNumber(); // instead of this: UUID.randomUUID().toString().substring(0, 8);
        setTitle(title);
        this.author = author;
        this.available=true;
    }

    // Constructor 02:
    public Book(String title, String author, Person borrower) {
        setTitle(title);
        setAuthor(author);
        setBorrower(borrower);
    }

    // setter for Author:
    public void setAuthor(String author) {
        validateInput(author, "Author");
        this.author = author;
    }

    // setter for title:
    public void setTitle(String title) {
        validateInput(title, "Title");
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable () {
        return available;
}

    // ????
    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.available = (borrower == null);
    }

    // Method to generate the bookId.
    private String generateIdNumber() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // Method to validate the fields.
    private void validateInput(String paramName, String paramFullName) {
        if (paramName == null || paramName.trim().isEmpty()) {
            throw new IllegalArgumentException(paramFullName + " is either null nor empty");
        }
    }

    // Method to check if the book is available or not and who has rented.
    /*public String getBookInformation () {
        String borrowerInfo = borrower != null ? " PersonId: " + borrower.getId() : "-";
        return String.format("Book{ id=%s, title=%s, author=%s, available=%b, borrower=%s }", id, title, author, available, borrowerInfo);
    }*/

     public String getBookInformation() {
        return "Book{ id=" + id + ", title=" + title + ", author=" + author + ", available=" + available +
                ", borrower=" + (borrower != null ? " PersonId: " + borrower.getPersonInformation() : "-") + " } ";
    }
}
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

    // ????
    public void setBorrower(Person borrower) {
        this.borrower = borrower;
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

    // Getter Method:
    public String getBookInformation() {
        String result = "The book id: " + id + "with title: " + title + " written by: " + author;
        return result;
    }

    public String getTitle() {
        return title;
    }

    // Method to check if the book is available or not and who has rented.
    public String getBorrowedBookInformation() {
        String result = "The book id: " + id + "with title: " + title + " written by: " + author;
        if (borrower != null) {
            result += " the book is not available and borrowed by: " + borrower.getPersonalInformation();
        } else {
            result += " The book is available: ";
        }
        return result;
    }
}
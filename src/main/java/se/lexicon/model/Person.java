package se.lexicon.model;

import java.util.Arrays;

public class Person {

    // Specify the variables.
    private static int sequencer = 0;

    private final int id;
    private String firstName;
    private String lastName;

    private Book[] borrowedBooks;

    // Constructor:
    public Person(String firstName, String lastName) {
        this.id = getNextId(); // Increment and assign sequencer
        setFirstName(firstName); // this.firstName = firstName;
        setLastName(lastName);
        this.borrowedBooks = new Book[0];
    }

    private static int getNextId() {
        return ++sequencer; // Increment and return the next ID
    }

    // setter for firstName:
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First Name can not be null or empty.");
        }
        this.firstName = firstName;
    }

    // setter for lastName:
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last Name can not be null or empty.");
        }
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void loanBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        if (!book.isAvailable()) throw new IllegalArgumentException("Book is not available");

        book.setBorrower(this);
        Book[] newArray = Arrays.copyOf(borrowedBooks, borrowedBooks.length + 1);
        newArray[newArray.length - 1] = book;
        borrowedBooks = newArray;
    }

    public void returnBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");

        Book[] newArray = new Book[borrowedBooks.length - 1];
        int counter = 0;
        for (Book elementArray : borrowedBooks) {
            if (elementArray.getId().equals(book.getId())) {
                book.setBorrower(null);
                continue;
            }
            newArray[counter++] = elementArray;
        }
        borrowedBooks = newArray;
    }

    public String getPersonInformation() {
        return "Person{ id=" + id + ", firstName='" + firstName + ", lastName='" + lastName +
                ",number of borrowedBooks=" + borrowedBooks.length + '}';
    }

}
package se.lexicon.model;

import javax.sound.midi.Sequencer;

public class Person {

    // Specify the variables.
    private int sequencer=0;
    private final int id;
    private String firstName;
    private String lastName;
    private Book loanBook;
    private Book returnBook;

    // Constructor:
    public Person(String firstName, String lastName) {
        this.id = getNextId(); // Increment and assign sequencer
        setFirstName(firstName); // this.firstName = firstName;
        setLastName(lastName);
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

    private int getNextId () {
        return ++sequencer; // Increment and return the next ID
    }

    public int getId() {
        return id;
    }

    // Getter Method:
    public String getPersonalInformation () {
        String result = "ID number: " +id +" with First Name: " + firstName + " and the Last Name: " + lastName;
        return result;
    }


    public void setReturnBook(Book returnBook) {
        this.returnBook = returnBook;
    }

    public String getReturnBookPersonalInfo () {
        String result = "ID number: " +id +" with First Name: " + firstName + " and the Last Name: " + lastName;
        if (returnBook != null ) {
            result+= " hasn't returned the book with the title: " + returnBook.getTitle();
        }else {
            result+= " has no book to return.";
        }
        return result;
    }

    public void setLoadBook(Book loadBook) {
        this.loanBook = loadBook;
    }

    public String getTheLoanerInfo () {
        String result = "ID number: " +id +" with First Name: " + firstName + " and the Last Name: " + lastName;
        if (loanBook != null ) {
            result+= "  currently has rented following books: " + loanBook.getTitle();
        }else {
            result+= " has no book to return.";
        }
        return result;
    }

}
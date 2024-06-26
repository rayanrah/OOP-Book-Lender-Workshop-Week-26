package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {

        // Create a book instance
        Book book1 = new Book("The last of us", "james Kamron");
        Book book2 = new Book("Finding Perfect", "poetry slam");

        // Display book information
        System.out.println(book1.getBookInformation());
        System.out.println(book2.getBookInformation());


        // Create a person instance
        Person person1 = new Person("Ryan","Rahdari");
        Person person2 = new Person("Mark","zuckerberg");

        // Display person information
        System.out.println(person1.getPersonalInformation());
        System.out.println(person2.getPersonalInformation());


        // Loan a book to the person

        // Display person information after borrowing a book
        // Display book information after borrowing a book
        book1.setBorrower(person1);
        System.out.println(book1.getBorrowedBookInformation ());
        System.out.println(book2.getBorrowedBookInformation());

        // Return the borrowed book
        person1.setReturnBook(book1);

        // Display person information after returning the book
        System.out.println(person1.getReturnBookPersonalInfo());
        System.out.println(person2.getReturnBookPersonalInfo());


        // Display book information after borrowing a book
        person1.setLoadBook(book1);
        System.out.println(person1.getTheLoanerInfo());
        System.out.println(person2.getTheLoanerInfo());

    }

}

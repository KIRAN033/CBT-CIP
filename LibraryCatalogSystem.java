import java.util.ArrayList;
import java.util.Scanner;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}
class LibraryCatalog {
    private ArrayList<Book> books;
    public LibraryCatalog() {
        books = new ArrayList<>();
    }
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }
    public void searchBooks(String keyword) {
        System.out.println("Search Results:");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching the keyword.");
        }
    }
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
        } else {
            System.out.println("Books in the catalog:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
public class LibraryCatalogSystem {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===============================================");
            System.out.println("\nLibrary Catalog System");
            System.out.println("===============================================");

            System.out.println("1. Add A New Book");
            System.out.println("2. Search For A Book");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");

            System.out.println("===============================================");

            System.out.print("Please Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("------------------------");
                    System.out.println("ADD A NEW BOOK");
                    System.out.println("------------------------");
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    catalog.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter a keyword to search: ");
                    String keyword = scanner.nextLine();
                    catalog.searchBooks(keyword);
                    break;

                case 3:
                    System.out.println("------------------------");
                    System.out.println("LIST OF ALL BOOKS");
                    System.out.println("------------------------");
                    catalog.listBooks();
                    break;

                case 4:
                    System.out.println("Thank You for using the Library System.Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
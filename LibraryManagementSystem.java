import java.util.ArrayList;

class User {
    private String name;
    private String email;
    private boolean isMember;

    public User(String name, String email, boolean isMember) {
        this.name = name;
        this.email = email;
        this.isMember = isMember;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }
}

class Book {
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String title, String author, String genre, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private ArrayList<User> users;
    private ArrayList<Book> books;

    public Library() {
        users = new ArrayList<User>();
        books = new ArrayList<Book>();
    }

    // Add user to library
    public void addUser(User user) {
        users.add(user);
    }

    // Remove user from library
    public void removeUser(User user) {
        users.remove(user);
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove book from library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Borrow book
    public void borrowBook(User user, Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(user.getName() + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("The book " + book.getTitle() + " is not available for borrowing.");
        }
    }

    // Return book
    public void returnBook(User user, Book book) {
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println(user.getName() + " has returned the book: " + book.getTitle());
        } else {
            System.out.println("The book " + book.getTitle() + " is already available.");
        }
    }

    // Search books by title, author, genre, and availability
    public ArrayList<Book> searchBooks(String title, String author, String genre, boolean isAvailable) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if ((title == null || book.getTitle().toLowerCase().contains(title.toLowerCase()))
                    && (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                    && (genre == null || book.getGenre().toLowerCase().contains(genre.toLowerCase()))
                    && (isAvailable == book.isAvailable())) {
                result.add(book);
            }
        }
        return result;
    }

    // Display all users
    public void displayAllUsers() {
        System.out.println("All Users:");
        for (User user : users) {
            System.out.println("Name: " + user.getName() + ", Email: " + user.getEmail() + ", Member: "
                    + (user.isMember() ? "Yes" : "No"));
        }
        System.out.println();
    }

    // Display all books
    public void displayAllBooks() {
        System.out.println("All Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Genre: "
                    + book.getGenre() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
        }
        System.out.println();
    }

    // Remove book from library
    public void removeBook(String title) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book \"" + title + "\" has been removed from the library.");
        } else {
            System.out.println("Book \"" + title + "\" not found in the library.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Create sample users
        User user1 = new User("John Doe", "johndoe@email.com", true);
        User user2 = new User("Jane Smith", "janesmith@email.com", false);
        User user3 = new User("Sam Johnson", "samjohnson@email.com", true);

        // Add users to the library
        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);

        // Create sample books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", false);
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", "Classic", true);
        Book book4 = new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", false);

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // Display all users and books
        library.displayAllUsers();
        library.displayAllBooks();

        // Search books by title, author, genre, and availability
        ArrayList<Book> searchResult = library.searchBooks("pride", null, "classic", true);
        System.out.println("Search Result:");
        for (Book book : searchResult) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Genre: "
                    + book.getGenre() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
        }

        // Borrow and return book
        library.borrowBook(user1, book1);
        library.returnBook(user1, book1);

               // Remove book
               library.removeBook("The Great Gatsby");

               // Display updated list of books
               library.displayAllBooks();
           }
       }
       


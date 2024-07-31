class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}

public class Library {
    Book[] books;

    Library(Book[] books) {
        this.books = books;
    }

    // Linear search by title
    Book findBookByTitleLinear(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search by title (assuming books are sorted by title)
    Book findBookByTitleBinary(String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Book A", "Author A"),
            new Book(2, "Book B", "Author B"),
            new Book(3, "Book C", "Author A")
        };

        Library library = new Library(books);

        // Linear search
        Book foundBook = library.findBookByTitleLinear("Book B");
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.title);
        } else {
            System.out.println("Book not found using linear search");
        }

        // Binary search (assuming books are sorted)
        foundBook = library.findBookByTitleBinary("Book B");
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook.title);
        } else {
            System.out.println("Book not found using binary search");
        }
    }
}

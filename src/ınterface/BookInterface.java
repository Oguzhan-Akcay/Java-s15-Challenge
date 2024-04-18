package ınterface;

import entity.Book;
import entity.Category;

import java.util.Collection;

public interface BookInterface {

    Book findBookById(int id);

    Book findBookByName(String name);

    Collection<Book> findBookByAuthor(String author);

    void updateBook(int id, Book updatedBook);

    Book deleteBook(int bookId);

    Collection<Book> getAllBooks();

    Collection<Book> findBooksByCategory(Category category);

    Collection<Book> findBooksByAuthor(String authorName);
/*    Book findBookByAuthor(String author);*/
}

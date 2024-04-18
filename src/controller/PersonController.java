package controller;

import entity.Book;
import entity.Person;

import java.util.Collection;
import java.util.List;

public class PersonController {

    public void listBooksOfUser(Person user) {
        Collection<Book> userBooks = user.getBooks(); // Kullanıcının elindeki kitapları al
        System.out.println("Kitaplar - " + user.getPersonName() + " adlı kullanıcının listesi:");
        if (userBooks.isEmpty()) {
            System.out.println("Kullanıcının elinde hiç kitap yok.");
        } else {
            for (Book book : userBooks) {
                System.out.println(book.getName() + " - " + book.getAuthor());
            }
        }
    }

}

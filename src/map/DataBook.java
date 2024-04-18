package map;

import entity.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataBook {

    //aynı anda birden fazla iş parçacığının aynı haritayı güncellemesine veya üzerinde işlem yapmasına izin verirken veri bütünlüğünü sağlar.
    private ConcurrentHashMap<Integer, Book> bookMap; //Ekleme sırasına göre tutar.
    private int nextId; //Sıralı olarak atanacak Id bilgisi

    public DataBook(){
        this.bookMap = new ConcurrentHashMap<>();
        this.nextId = 1; // ID'leri 1'den başlatmasına yarar
    }

    public void addBook(Book book){
        int id = nextId++; // Bir sonraki sıralı ID'yi alır ve otomatik olarak arttırmaya yarar
        book.setId(id); // Sıralı id'yi atar
        bookMap.put(id, book);
    }

    public Book findBookById(int id) {
        return bookMap.get(id);// HashMap'ten belirtilen ID'ye sahip kitabı döndürmek için yazıldı.
    }

    // İsme göre kitap bulma
    public Book findBookByName(String name) {
        for (Book book : bookMap.values()) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null; // İsimle eşleşen kitap bulunamazsa null döner
    }

    // Yazarına göre kitap bulma
    public Book findBookByAuthor(String author) {
        for (Book book : bookMap.values()) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null; // Yazarla eşleşen kitap bulunamazsa null döner
    }

    // Kitap bilgilerini güncellemek için
    public void updateBook(int id, Book updatedBook) {
        Book book = bookMap.get(id);
        if (book != null) {
            book.setName(updatedBook.getName());
            book.setAuthor(updatedBook.getAuthor());
            book.setEdition(updatedBook.getEdition());
            book.setPrice(updatedBook.getPrice());
            book.setStatus(updatedBook.isStatus());
            book.setDate_of_purchase(updatedBook.getDate_of_purchase());
        }
    }

    //Kitabı silmek için
    public void deleteBook(int bookId) {
        bookMap.remove(bookId);
    }

    // Tüm kitapları Listelemek için
    public Collection<Book> getAllBooks() {
        return bookMap.values();
    }
}

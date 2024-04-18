package controller;

import entity.Book;
import entity.Category;
import entity.Person;
import map.DataBook;
import ınterface.BookInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookController implements BookInterface {
    public DataBook dataBook;

    public BookController(){
        this.dataBook = new DataBook();
    }

    //Kitabu eklemek için
    public void addBook(Book book){
        dataBook.addBook(book);
    }

    @Override
    public Book findBookById(int id) {
        return dataBook.findBookById(id);
    }

    // İsme göre kitap bulma
    @Override
    public Book findBookByName(String name) {
        return dataBook.findBookByName(name);
    }

    // Yazarına göre kitap bulma

    @Override
    public Collection<Book> findBookByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : dataBook.getAllBooks()) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }


    @Override
    public void updateBook(int id, Book updatedBook) {
        dataBook.updateBook(id, updatedBook);
    }

    @Override
    public Book deleteBook(int bookId) {
        dataBook.deleteBook(bookId);
        return null;
    }

    // Tüm kitapları Listelemek için
    //eşsizlik gereksinimine ihtiyacı olmadığı iiçin Collection döndürdüm.
    @Override
    public Collection<Book> getAllBooks() {
        return dataBook.getAllBooks();
    }

    //Kategoriye göre kitap filtreleme
    public Collection<Book> findBooksByCategory(Category category) {
        List<Book> booksInCategory = new ArrayList<>();
        for (Book book : dataBook.getAllBooks()) {
            if (book.getCategory().equals(category)) {
                booksInCategory.add(book);
            }
        }
        return booksInCategory;
    }


    //Yazara göre Kitap filtreleme
    @Override
    public Collection<Book> findBooksByAuthor(String authorName) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : dataBook.getAllBooks()) {
            if (book.getAuthor().equals(authorName)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }


    //Kitap alınabilir mi ya da Kimin tarafından alındı onu yazdık.
    /*public void loanBook(Book book, Person user) {
        if (book.isStatus()) { // Kitap ödünç alınabilir durumdaysa
            book.setStatus(false); // Kitabı ödünç alındı olarak işaretle
            book.setPerson(user); // Kitabı ödünç alan kişiyi ayarla
            System.out.println(user.getPersonName() + " tarafından '" + book.getName() + "' kitabı ödünç alındı.");
            double price = book.getPrice();
            System.out.println("Fatura kesim işlemimiz yapılıyor:");
            System.out.println("Kitap Adı: " + book.getName());
            System.out.println("Ücret: " + price + " TL");
            System.out.println("Fatura kesilen kişi: " + user.getPersonName()); // Faturanın kime kesildiği bilgisi
            System.out.println("İşlemleriniz bitmiştir. Kitabı alabilirsiniz.");
        } else {
            System.out.println("'" + book.getName() + "' kitabı zaten ödünç alınmış.");
        }
    }*/

    //Bu kullanılan
    /*public void loanBook(Book book, Person user) {
        if (book.isStatus()) { // Kitap ödünç alınabilir durumdaysa
            if (user.getBookLimit() > 0) { // Kullanıcının kitap limiti kontrol ediliyor
                book.setStatus(false); // Kitabı ödünç alındı olarak işaretle
                book.setPerson(user); // Kitabı ödünç alan kişiyi ayarla
                System.out.println(user.getPersonName() + " tarafından '" + book.getName() + "' kitabı ödünç alındı.");
                double price = book.getPrice();
                System.out.println("Fatura kesim işlemimiz yapılıyor:");
                System.out.println("Kitap Adı: " + book.getName());
                System.out.println("Ücret: " + price + " TL");
                System.out.println("Fatura kesilen kişi: " + user.getPersonName()); // Faturanın kime kesildiği bilgisi
                System.out.println("İşlemleriniz bitmiştir. Kitabı alabilirsiniz.");
                user.setBookLimit(user.getBookLimit() - 1); // Kullanıcının aldığı kitap sayısını azalt
            } else {
                System.out.println(user.getPersonName() + ", kitap limitinizi aştınız. Daha fazla kitap alamazsınız.");
            }
        } else {
            System.out.println("'" + book.getName() + "' kitabı zaten ödünç alınmış.");
        }
    }*/

    public void loanBook(Book book, Person user, List<Book> userBooks) {
        if (book.isStatus()) { // Kitap ödünç alınabilir durumdaysa
            if (user.getBookLimit() > 0) { // Kullanıcının kitap limitini burada kontrol ediliyoruz
                if (user.getWallet() >= book.getPrice()) { // Kullanıcının bakiyesi yeterli mi kontrol ediliyoruz
                    book.setStatus(false); // Kitabı ödünç alındı olarak işaretle
                    book.setPerson(user); // Kitabı ödünç alan kişiyi göstermek için yazıldı
                    user.getBooks().add(book); // Kullanıcının sahip olduğu kitapların listesine ödünç alınan kitabı ekledim
                    userBooks.add(book);
                    System.out.println(user.getPersonName() + " tarafından '" + book.getName() + "' kitabı ödünç alındı.");
                    double price = book.getPrice();
                    System.out.println("Fatura kesim işlemimiz yapılıyor:");
                    System.out.println("Kitap Adı: " + book.getName());
                    System.out.println("Ücret: " + price + " TL");
                    System.out.println("Fatura kesilen kişi: " + user.getPersonName()); // Faturanın kime kesildiği bilgisi
                    System.out.println("İşlemleriniz bitmiştir. Kitabı alabilirsiniz.");
                    user.setBookLimit(user.getBookLimit() - 1); // Kullanıcının aldığı kitap sayısını azalt
                    user.setWallet(user.getWallet() - price); // Kullanıcının bakiyesinden ücreti düş
                    System.out.println("Yeni Bakiye: " + user.getWallet() + " TL"); // Yeni bakiyeyi yazdır
                } else {
                    System.out.println("Üzgünüz, " + user.getPersonName() + ", bakiyeniz yetersiz. Kitabı ödünç alamazsınız.");
                }
            } else {
                System.out.println(user.getPersonName() + ", kitap limitinizi aştınız. Daha fazla kitap alamazsınız.");
            }
        } else {
            System.out.println("'" + book.getName() + "' kitabı zaten ödünç alınmış.");
        }
    }


    //Kitabın geri teslim edilmesi için yazılan metot.
    public void giveBookBack(Book book, Person user, List<Book> userBooks) {
        if (!book.isStatus()) { // Kitap ödünç alınmış durumdaysa
            double price = book.getPrice();
            // Ödeme iadesi yapma işlemi
            System.out.println("İade ödeme işleminiz gerçekleşiyor:");
            System.out.println("İade edilen kitap: " + book.getName());
            System.out.println("İade edilen tutar: " + price + " TL");
            System.out.println("İade edilen kişi: " + user.getPersonName());
            System.out.println("Ödeme iadesi tamamlandı. İade işleminiz tamamlanmıştır. Teşekkürler!");
            userBooks.remove(book);
            user.setWallet(user.getWallet() + price);// Kullanıcıya ödeme yapma
            // Kitapın tekrar ödünç alınabilir duruma getirilmesi
            book.setStatus(true);
            book.setPerson(null); // Kitabın ödünç alan kişisi null olarak ayarlanır
            user.setBookLimit(user.getBookLimit() + 1); // Kullanıcının aldığı kitap sayısını artır
            System.out.println("Yeni Bakiye: " + user.getWallet() + " TL"); // Yeni bakiyeyi artır
        } else {
            System.out.println("'" + book.getName() + "' kitabı zaten kütüphanede bulunuyor.");
        }
    }

/*    public void giveBookBack(Book book) {
        if (!book.isStatus()) { // Kitap ödünç alınmış durumdaysa
            book.setStatus(true); // Kitabı tekrar ödünç alınabilir duruma getir
            Person person = book.getPerson();
            book.setPerson(null); // Kitabı ödünç alan kişiyi temizle
            System.out.println("'" + book.getName() + "' kitabı, " + person.getPersonName() + " tarafından başarıyla geri teslim edildi.");
        } else {
            System.out.println("'" + book.getName() + "' kitabı zaten kütüphanede bulunuyor.");
        }
    }*/






}
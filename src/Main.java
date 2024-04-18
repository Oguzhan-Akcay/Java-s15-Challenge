import controller.BookController;
import controller.PersonController;
import entity.Book;
import entity.Category;
import entity.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookController bookController = new BookController();
        PersonController personController = new PersonController();
        List<Book> userBooks = new ArrayList<>();
        Book book = new Book();
        Category roman = new Category("Roman");
        Category şiirler = new Category("Şiir kitabı");
        Category bilimKurgu = new Category("Bilim Kurgu");

/*************************************************************************************************************/
        //Sisteme yeni kitap eklenebilir.
        Book addBookFromController = new Book("Oğuzun Dünyası", "Oğuzhan Akçay", 95.80, true, "First Edition", new Date(), roman);
        Book addBookFromController1 = new Book("Şiirler", "Emirhan", 48.90, true, "Second Edition", new Date(), şiirler);
        Book addBookFromController2 = new Book("Resimler", "Alperen", 53.90, true, "First Edition", new Date(), bilimKurgu);
        Book addBookFromController3 = new Book("Severek Ayrılma", "Enes", 23.70, true, "Third Edition", new Date(), şiirler);
        Book addBookFromController4 = new Book("Mutlu Sonlar", "Oğuzhan Akçay", 150.0, true, "First Edition", new Date(), şiirler);
        Book addBookFromController5 = new Book("Yaşam Döngüsü", "Murat", 13.30, true, "First Edition", new Date(), bilimKurgu);
        Book addBookFromController6 = new Book("Hayvanlar", "Murat", 13.30, true, "First Edition", new Date(), bilimKurgu);
        Book addBookFromController7 = new Book("Dünya", "Anonim", 250, true, "First Edition", new Date(), bilimKurgu);

        bookController.addBook(addBookFromController);
        bookController.addBook(addBookFromController1);
        bookController.addBook(addBookFromController2);
        bookController.addBook(addBookFromController3);
        bookController.addBook(addBookFromController4);
        bookController.addBook(addBookFromController5);
        bookController.addBook(addBookFromController6);
        bookController.addBook(addBookFromController7);
        System.out.println("Eklenen Kitap: " + addBookFromController);
        System.out.println("Eklenen Kitap: " + addBookFromController1);
        System.out.println("Eklenen Kitap: " + addBookFromController2);
        System.out.println("Eklenen Kitap: " + addBookFromController3);
        System.out.println("Eklenen Kitap: " + addBookFromController4);
        System.out.println("Eklenen Kitap: " + addBookFromController5);
        System.out.println("Eklenen Kitap: " + addBookFromController6);
        System.out.println("Eklenen Kitap: " + addBookFromController7);



/***************************************************************************************/

        //Sistemden id, isim veya yazar bilgisine göre bir kitap seçilebilir
        /*Book bookById = bookController.findBookById(2);
        System.out.println("Id bilgisine sahip kitap: " + bookById);*/

        /*Book bookByName = bookController.findBookByName("Oğuzun Dünyası");
        System.out.println("İsim bilgisi üzerine bulunan kitap: " + bookByName);*/

        /*Collection<Book> booksByAuthor = bookController.findBooksByAuthor("Oğuzhan Akçay");
        System.out.println(booksByAuthor);*/

/*************************************************************************************/

        //Sistemde var olan bir kitabın bilgileri güncellenebilir.
        /*book = bookController.findBookById(2);
        if (book != null){
            book.setName("Müzikler");
            bookController.updateBook(2, book);
            System.out.println("Girmiş olduğunuz yeni veriler doğrultusunda  kitap bilgileri Güncellenmiştir." + book);
        }else {
            System.out.println("Bu id'ye sahip bir kitap bulunamadı");
        }
*/
 /***********************************************************************************/


        //Sistemde var olan bir kitap silinebilir.

        /*bookController.deleteBook(2);
        System.out.println("Yeni Kitap Listesi: ");
        for (Book books : bookController.getAllBooks()){
            System.out.println("Kitap Adı: " + books.getName());
        }*/

        /*
        bookController.deleteBook(2);
        System.out.println("İstediğiniz kitap başarılı bir şekilde silindi");
        System.out.println("Yeni Kitap Listesi: ");
        for (Book books : bookController.getAllBooks()){
            System.out.println("Kitap Adı: " + books.getName());
        }*/

  /**************************************************************************/

        // İstenilen kategorideki listesi
        //For Roman
        /*Category categoryToFind = new Category("Roman");
        Collection<Book> booksInCategory = bookController.findBooksByCategory(categoryToFind);
        System.out.println("Roman kategorisindeki kitaplar:");
        for (Book bookCat : booksInCategory) {
            System.out.println(bookCat);
        }*/

        /*//For Şiir
        Category categoryToFind = new Category("Şiir kitabı");
        Collection<Book> booksInCategory = bookController.findBooksByCategory(categoryToFind);
        System.out.println("Roman kategorisindeki kitaplar:");
        for (Book bookCat : booksInCategory) {
            System.out.println(bookCat);
        }*/
        /*//For Bilim kurgu
        Category categoryToFind = new Category("Bilim Kurgu");
        Collection<Book> booksInCategory = bookController.findBooksByCategory(categoryToFind);
        System.out.println("Roman kategorisindeki kitaplar:");
        for (Book bookCat : booksInCategory) {
            System.out.println(bookCat);
        }*/

        /* ************************************************************************** */

         //Yazara Göre Kitap Listeleme
       /* String authorToFind = "Oğuzhan Akçay"; // Aranan yazar
        Collection<Book> booksByAuthor = bookController.findBooksByAuthor(authorToFind); // Metodu çağırma
        System.out.println("Yazarın Tüm Kitapları:");
        for (Book bookByAuthor : booksByAuthor) {
            System.out.println(bookByAuthor);
        }*/

        /* ******************************************************************** */

        //Ödünç alma için sorgu
        Person user = new Person("Çağrı Yılmaz", 200);
        bookController.loanBook(addBookFromController5, user, userBooks);
        bookController.loanBook(addBookFromController4, user, userBooks);
        bookController.loanBook(addBookFromController, user, userBooks);
        bookController.loanBook(addBookFromController1, user, userBooks);
        bookController.loanBook(addBookFromController2, user, userBooks);
        /*bookController.loanBook(addBookFromController3, user, userBooks);
        bookController.loanBook(addBookFromController4, user, userBooks);
        bookController.loanBook(addBookFromController5, user, userBooks);*/

        /*bookController.giveBookBack(addBookFromController5,user);*/
        /*bookController.giveBookBack(addBookFromController4, user);*/
        /*bookController.loanBook(addBookFromController6, user, userBooks);*/
        /*bookController.giveBookBack(addBookFromController6, user);*/
        /*personController.listBooksOfUser(user);
        bookController.giveBookBack(addBookFromController5, user, userBooks);
        personController.listBooksOfUser(user);*/

        /*//Olumsuz Sorgu
        Person user2 = new Person("Emir A", 400);
        bookController.loanBook(addBookFromController5, user2);*/
        //Geri Teslim Etmek için çağırılan metot
        /*bookController.giveBookBack(addBookFromController, user);*/

        /*// Fatura kesme işlemi
        bookController.processInvoice(book, user);
*/
        /*// Kitabı geri iade etme işlemi
        bookController.giveBackMoney(book, user);*/


    }
}
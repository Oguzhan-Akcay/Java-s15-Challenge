package entity;

import java.util.Date;
import java.util.Objects;

public class Book extends BaseEntity{
    private String name;
    private String author;
    private double price;
    private boolean status;
    private String edition;
    private Date date_of_purchase;

    private Category category;

    private Person person;

    public Book() {
    }

    public Book(String name, String author, double price, boolean status, String edition, Date date_of_purchase, Category category) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
        this.category = category;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    // Kitabın ödünç alınıp alınamayacağını kontrol etmek için yazıldı
    public boolean canOnLoan() {
        return status && person == null; // Kitap mevcut ve ödünç alınmamışsa true dönecek
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(Date date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition='" + edition + '\'' +
                ", date_of_purchase=" + date_of_purchase +
                ", category=" + category.getName() +
                ", person=" + (person != null ? person.getPersonName() : "None") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && status == book.status && name.equals(book.name) && author.equals(book.author) && Objects.equals(edition, book.edition) && Objects.equals(date_of_purchase, book.date_of_purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, author, price, status, edition, date_of_purchase);
    }



}

package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person extends BaseEntity {
    private String personName;
    private double wallet;
    private int bookLimit = 5;
    private List<Book> books; //Kullanıcının elindeki kitapları listelemek için yazıldı

    public Person() {
        this.books = new ArrayList<>();
    }

    public Person(String personName, double wallet) {
        this.personName = personName;
        this.wallet = wallet;
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.wallet, wallet) == 0 && bookLimit == person.bookLimit && personName.equals(person.personName) && books.equals(person.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, wallet, bookLimit, books);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", wallet=" + wallet +
                ", bookLimit=" + bookLimit +
                ", books=" + books +
                '}';
    }
}

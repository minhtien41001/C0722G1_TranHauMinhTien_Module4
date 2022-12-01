package com.example.bookloan.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBook;
    private int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_loan_id",referencedColumnName = "id")
    private BookLoan bookLoan;

    public Book() {
    }

    public Book(int id, String nameBook, int amount, BookLoan bookLoan) {
        this.id = id;
        this.nameBook = nameBook;
        this.amount = amount;
        this.bookLoan = bookLoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BookLoan getBookLoan() {
        return bookLoan;
    }

    public void setBookLoan(BookLoan bookLoan) {
        this.bookLoan = bookLoan;
    }
}

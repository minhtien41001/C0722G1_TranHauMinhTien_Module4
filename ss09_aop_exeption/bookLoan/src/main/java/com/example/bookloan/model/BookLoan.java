package com.example.bookloan.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String BorrowerName;
    private String borrowedCode;
    private Integer payAsc;
    private Integer orderAsc;

    @OneToMany(mappedBy = "bookLoan",cascade = CascadeType.ALL)
    private Set<Book> book;

    public BookLoan() {
    }

    public BookLoan(int id, String borrowerName, Set<Book> book) {
        this.id = id;
        BorrowerName = borrowerName;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return BorrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        BorrowerName = borrowerName;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public String getBorrowedCode() {
        return borrowedCode;
    }

    public void setBorrowedCode(String borrowedCode) {
        this.borrowedCode = borrowedCode;
    }

    public Integer getPayAsc() {
        return payAsc;
    }

    public void setPayAsc(Integer payAsc) {
        this.payAsc = payAsc;
    }

    public Integer getOrderAsc() {
        return orderAsc;
    }

    public void setOrderAsc(Integer orderAsc) {
        this.orderAsc = orderAsc;
    }
}

package book;

import java.util.List;

import book.Book;

public class Category {
    private String nameCategory;
    private List<Book> bds;

    public Category(String nameCategory, List<Book> bds) {
        this.nameCategory = nameCategory;
        this.bds = bds;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Book> getBds() {
        return bds;
    }

    public void setBds(List<Book> bds) {
        this.bds = bds;
    }
}
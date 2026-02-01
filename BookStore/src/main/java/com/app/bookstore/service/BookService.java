package com.app.bookstore.service;

import com.app.bookstore.entity.Book;
import com.app.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public Book getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<Book> getByAuthor(String author) {
        return repo.findByAuthor(author);
    }

    public List<Book> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Book> getByPriceLessThan(Double price) {
        return repo.findByPriceLessThan(price);
    }

    public List<Book> searchByTitle(String keyword) {
        return repo.searchByTitle(keyword);
    }

    public List<Book> findByPriceRange(double min, double max) {
        return repo.findByPriceRange(min, max);
    }
}

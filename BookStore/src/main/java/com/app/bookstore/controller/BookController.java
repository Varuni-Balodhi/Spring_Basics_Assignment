package com.app.bookstore.controller;

import com.app.bookstore.entity.Book;
import com.app.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book add(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return service.getByAuthor(author);
    }

    @GetMapping("/category/{category}")
    public List<Book> byCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/price/less/{price}")
    public List<Book> byPrice(@PathVariable Double price) {
        return service.getByPriceLessThan(price);
    }

    @GetMapping("/search/{keyword}")
    public List<Book> search(@PathVariable String keyword) {
        return service.searchByTitle(keyword);
    }

    @GetMapping("/price-range")
    public List<Book> priceRange(
            @RequestParam double min,
            @RequestParam double max) {
        return service.findByPriceRange(min, max);
    }
}

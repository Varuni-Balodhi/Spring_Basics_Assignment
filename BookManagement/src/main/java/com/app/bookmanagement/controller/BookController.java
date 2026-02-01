package com.app.bookmanagement.controller;

import com.app.bookmanagement.dto.BookDto;
import com.app.bookmanagement.entity.Book;
import com.app.bookmanagement.service.BookService;
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
    public Book add(@RequestBody BookDto dto) {
        return service.addBook(dto);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return service.getBook(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @RequestBody BookDto dto) {
        return service.updateBook(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteBook(id);
    }
}

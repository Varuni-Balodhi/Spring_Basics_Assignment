package com.app.bookstore.repository;

import com.app.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthor(String author);

    List<Book> findByCategory(String category);

    List<Book> findByPriceLessThan(Double price);

    boolean existsByIsbn(String isbn);

    void deleteByTitle(String title);
    
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> searchByTitle(@Param("keyword") String keyword);

    @Query("SELECT b FROM Book b ORDER BY b.price DESC")
    List<Book> sortByPriceDesc();
    @Query(
        value = "SELECT * FROM books WHERE price BETWEEN ?1 AND ?2",
        nativeQuery = true
    )
    List<Book> findByPriceRange(double min, double max);
}

package com.example.eliasbookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.eliasbookstore.domain.Book;
import com.example.eliasbookstore.domain.BookRepository;
import com.example.eliasbookstore.domain.CategoryRepository;

import org.junit.jupiter.api.Test;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;
    @Autowired
    private CategoryRepository crepository;

    @Test
    public void searchBook() {
        List<Book> books = brepository.findByTitle("First Title");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("First Author");
    }

    @Test
    public void createBook() {
        Book book = new Book("Test Author", "Test Title", 2020, "987654-3210", 123, crepository.findByName("FirstCategory").get(0));
        brepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = brepository.findByTitle("First Title");
        Book book = books.get(0);
        brepository.delete(book);
        List<Book> newBooks = brepository.findByTitle("First Title");
        assertThat(newBooks).hasSize(0);
    }

    @Test
	 public void createAndDeleteBook() {
		 Book book = new Book("AUTHOR", "TITLE", 2000, "000000-0000", 0, crepository.findByName("FirstCategory").get(0));
		 brepository.save(book);
		 assertThat(brepository.findById(book.getId())).isNotEmpty();
         assertThat(book.getTitle().matches("TITLE"));
		 brepository.delete(book);
		 assertThat(brepository.findById(book.getId())).isEmpty();
	 }
}
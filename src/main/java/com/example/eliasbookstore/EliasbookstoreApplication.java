package com.example.eliasbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.eliasbookstore.domain.Book;
import com.example.eliasbookstore.domain.BookRepository;
import com.example.eliasbookstore.domain.Category;
import com.example.eliasbookstore.domain.CategoryRepository;

@SpringBootApplication
public class EliasbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EliasbookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStore(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("FirstCategory"));
			crepository.save(new Category("SecondCategory"));

			brepository.save(new Book("First Author", "First Title", 2001, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));
			brepository.save(new Book("Second Author", "Second Title", 2002, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));
			brepository.save(new Book("Third Author", "Third Title", 2003, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));
			brepository.save(new Book("Fourth Author", "Fourth Title", 2004, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));
		};
	}
}

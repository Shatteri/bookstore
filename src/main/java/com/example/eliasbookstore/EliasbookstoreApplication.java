package com.example.eliasbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.eliasbookstore.domain.Book;
import com.example.eliasbookstore.domain.BookRepository;
import com.example.eliasbookstore.domain.Category;
import com.example.eliasbookstore.domain.CategoryRepository;
import com.example.eliasbookstore.domain.User;
import com.example.eliasbookstore.domain.UserRepository;


@SpringBootApplication
public class EliasbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EliasbookstoreApplication.class, args);
	}
		
	@Bean
	public CommandLineRunner bookStore(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			// crepository.save(new Category("FirstCategory"));
			// crepository.save(new Category("SecondCategory"));

			// brepository.save(new Book("First Author", "First Title", 2001, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));
			// brepository.save(new Book("Second Author", "Second Title", 2002, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));
			// brepository.save(new Book("Third Author", "Third Title", 2003, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));
			// brepository.save(new Book("Fourth Author", "Fourth Title", 2004, "123456-7890", 50, crepository.findByName("FirstCategory").get(0)));

			// urepository.save(new User("user", "$2y$10$iyEr.tfpe9q2NrY0B9ayAeVsd4ljb5VHP8y/ioV/rFXrz2fv624yG", "USER"));
			// urepository.save(new User("admin", "$2y$10$6P79CpftG0MpMstXlAgieuIZA3fRCD89iXHc8L6zTAcTLPyxjDAse", "ADMIN"));
		};
	}
}

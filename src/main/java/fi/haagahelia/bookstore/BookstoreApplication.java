package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Author;
import fi.haagahelia.bookstore.domain.AuthorRepository;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepo, AuthorRepository authorRepo) {
		return (args) -> {
			// Your code...add some demo data to db
			Author author1 = new Author("Tolstoi", "Leo");
			Author author2 = new Author("Dostojevski", "Fedor");
			Author author3 = new Author("Westö", "Kjell");
			
			authorRepo.save(author1);
			authorRepo.save(author2);
			authorRepo.save(author3);
			
			Book book1 = new Book(author1, "Sota ja Rauha");
			Book book2 = new Book(author2, "Rikos ja Rangaistus");
			Book book3 = new Book(author3, "Leijat helsingin yllä"); 
			
			book1.setPrice(29.99);
			book2.setPrice(19.99);
			book3.setPrice(14.99);
			
			bookRepo.save(book1);
			bookRepo.save(book2);
			bookRepo.save(book3);
		};
	}
}

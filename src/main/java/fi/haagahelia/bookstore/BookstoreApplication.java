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
	public CommandLineRunner demo(BookRepository repository, AuthorRepository autRep) {
		return (args) -> {
			// Your code...add some demo data to db
			Author author1 = new Author("Leo", "Tolstoi");
			Author author2 = new Author("Fedor", "Dostojevski");
			Author author3 = new Author("Westö", "Kjell");
			
			autRep.save(author1);
			autRep.save(author2);
			autRep.save(author3);
			
			Book book1 = new Book(author1, "Sota ja Rauha");
			Book book2 = new Book(author2, "Rikos ja Rangaistus");
			Book book3 = new Book(author3, "Leijat helsingin yllä"); 
			
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
		};
	}
}

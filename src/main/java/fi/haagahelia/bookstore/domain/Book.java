package fi.haagahelia.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long book_id;

	@ManyToOne
	@JoinColumn(name = "AuthorId")
	private Author author;

	private String name;
	private Double price;

	public Book() {
	}

	public Book(Author author, String name, Double price) {
		super();
		this.author = author;
		this.name = name;
		this.price = price;
	}

	public Book(Author author, String name) {
		super();
		this.author = author;
		this.name = name;
	}

	public long getId() {
		return book_id;
	}

	public void setId(long id) {
		this.book_id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

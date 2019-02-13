package fi.haagahelia.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long authorId;
	public String firstName;
	public String lastName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
	private List<Book> books;

	public Author() {
	}

	public Author(String wholeName) {
		super();
		String[] palat = wholeName.split(",");
		this.firstName = palat[1];
		this.lastName = palat[0];
	}
	public Author(String lastName, String firstName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return authorId;
	}

	public void setId(long id) {
		this.authorId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return this.lastName + ", " + this.firstName;
	}
	/*
	 * @Override public String toString() { return "Author [id=" + authorId +
	 * ", firstName=" + firstName + ", lastName=" + lastName + "]"; }
	 */
}

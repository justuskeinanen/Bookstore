package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.bookstore.domain.AuthorRepository;
import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepo;// lets introduce our repository, aka repository injection.

	@Autowired
	private AuthorRepository authorRepo;

	@RequestMapping("/allbooks")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		model.addAttribute("authors", authorRepo.findAll());
		return "allbooks";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("authors", authorRepo.findAll());
		return "addBook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepo.save(book);
		return "redirect:allbooks";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepo.deleteById(bookId);
		return "redirect:../allbooks";
	}
}

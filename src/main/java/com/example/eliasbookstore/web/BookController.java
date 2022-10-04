package com.example.eliasbookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.eliasbookstore.domain.Book;
import com.example.eliasbookstore.domain.BookRepository;
import com.example.eliasbookstore.domain.CategoryRepository;
@Controller
public class BookController {

	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;

	
	@RequestMapping(value={"/", "/booklist"})
	public String bookStore(Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		brepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") long bookId, Model model) {
		model.addAttribute("book", brepository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveBook(@ModelAttribute Book newbook, Model model) {
		brepository.save(newbook);
		return "redirect:booklist";
	}

	//REST list all books (json)
	@RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) brepository.findAll();
    }  

	//REST list individual book by id (json)
	//ID'S START FROM 3 DUE TO CATEGORIES IN COMMAND LINE RUNNER
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
    	return brepository.findById(id);
    } 
}
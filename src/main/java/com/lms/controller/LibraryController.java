package com.lms.controller;

import com.lms.entity.Book;
import com.lms.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {
        libraryService.addBook(book);
    }

    @DeleteMapping("/removeBook/{isbn}")
    public void removeBook(@PathVariable String isbn) {
        libraryService.removeBook(isbn);
    }

    @GetMapping("/findBookByTitle/{title}")
    public List<Book> findBookByTitle(@PathVariable String title) {
        return libraryService.findBookByTitle(title);
    }

    @GetMapping("/findBookByAuthor/{author}")
    public List<Book> findBookByAuthor(@PathVariable String author) {
        return libraryService.findBookByAuthor(author);
    }

    @GetMapping("/listAllBooks")
    public List<Book> listAllBooks() {
        return libraryService.listAllBooks();
    }

    @GetMapping("/listAvailableBooks")
    public List<Book> listAvailableBooks() {
        return libraryService.listAvailableBooks();
    }
}

package com.example.study.controller.book;

import com.example.study.entity.Book;
import com.example.study.model.AddBookInput;
import com.example.study.repository.BookRepository;
import com.example.study.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable; //주의
import java.util.List;

@RestController
public class BookController {

    private BookService bookService;
    private BookRepository bookRepository;

    public BookController(BookService bookService,BookRepository bookRepository){
        this.bookService=bookService;
        this.bookRepository=bookRepository;
    }

//    @GetMapping("/books")
//    public List<Book> getAllBooks() {
//        List<Book> books = bookRepository.findAll();
//        return books;
//    }


    @PostMapping("/book")
    public long addBook(@RequestBody @Valid AddBookInput input){
        long id=bookService.addBook(input);
        return id;
    }

    @PutMapping("/book/{id}")
    public void updateBook(
            @PathVariable long id,
            @RequestBody AddBookInput input
    ) {
        bookService.updateBook(id, input);
    }

    @GetMapping("/book")
    public ResponseEntity<Page<Book>> getBooks(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(
                bookService.getBooks(pageable)
        );
    }
}
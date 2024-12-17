package com.example.study.service;

import com.example.study.entity.Book;
import com.example.study.entity.BookUpdateHistory;
import com.example.study.model.AddBookInput;
import com.example.study.repository.BookRepository;
import com.example.study.repository.BookUpdateHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookUpdateHistoryRepository bookUpdateHistoryRepository;

    public BookService(BookRepository bookRepository,
                       BookUpdateHistoryRepository bookUpdateHistoryRepository) {
        this.bookRepository = bookRepository;
        this.bookUpdateHistoryRepository = bookUpdateHistoryRepository;
    }


    public long addBook(AddBookInput input) {
        Book book = Book.builder()
                .name(input.getBookName())
                .price(String.valueOf(input.getBookPrice()))
                .build();
        Book saved = bookRepository.save(book);
        return saved.getId();
    }
    @Transactional
    public void updateBook(long id, AddBookInput input) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 Book 없음"));
        BookUpdateHistory bookUpdateHistory =BookUpdateHistory
                .builder()
                .book(book)
                .prevName(book.getName())
                .prevPrice(book.getPrice())
                .newName(input.getBookName())
                .newPrice(input.getBookPrice())
                .at(LocalDateTime.now())
                .build();
        book.setName(input.getBookName());
        book.setPrice(String.valueOf(input.getBookPrice()));
        bookRepository.save(book);
        bookUpdateHistoryRepository.save(bookUpdateHistory);
    }
    public Page<Book> getBooks(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}

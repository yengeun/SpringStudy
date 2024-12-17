package com.example.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.study.entity.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{

}
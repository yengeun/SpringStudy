package com.example.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.study.entity.BookUpdateHistory;

public interface BookUpdateHistoryRepository extends
    JpaRepository<BookUpdateHistory, Long>{
    }

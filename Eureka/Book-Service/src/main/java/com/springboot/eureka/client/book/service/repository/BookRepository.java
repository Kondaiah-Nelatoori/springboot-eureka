package com.springboot.eureka.client.book.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.eureka.client.book.service.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}

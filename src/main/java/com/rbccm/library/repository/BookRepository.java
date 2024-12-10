package com.rbccm.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbccm.library.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>  {

}

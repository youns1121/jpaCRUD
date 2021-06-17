package com.jpacrud.repository;

import com.jpacrud.domain.Book;
import com.jpacrud.domain.Lend;
import com.jpacrud.domain.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus lendStatus);


}

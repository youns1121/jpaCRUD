package com.jpacrud.repository;

import com.jpacrud.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    Board findByName(String name); // Board 이름으로 조회하기


}


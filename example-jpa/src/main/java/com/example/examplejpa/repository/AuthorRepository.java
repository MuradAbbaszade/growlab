package com.example.examplejpa.repository;

import com.example.examplejpa.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.FetchType;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"bookList"})
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.bookList b")
    public List<Author> findAll();
}

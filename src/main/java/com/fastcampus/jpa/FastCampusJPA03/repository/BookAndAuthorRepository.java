package com.fastcampus.jpa.FastCampusJPA03.repository;

import com.fastcampus.jpa.FastCampusJPA03.domain.BookAndAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAndAuthorRepository extends JpaRepository<BookAndAuthor,Long> {
}

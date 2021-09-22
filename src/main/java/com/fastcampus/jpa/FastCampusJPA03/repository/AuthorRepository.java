package com.fastcampus.jpa.FastCampusJPA03.repository;

import com.fastcampus.jpa.FastCampusJPA03.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}

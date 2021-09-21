package com.fastcampus.jpa.FastCampusJPA03.repository;

import com.fastcampus.jpa.FastCampusJPA03.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}

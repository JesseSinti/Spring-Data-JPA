package com.example.festivalorganizer.repository;

import com.example.festivalorganizer.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
}

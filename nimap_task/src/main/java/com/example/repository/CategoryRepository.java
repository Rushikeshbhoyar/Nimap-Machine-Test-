package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Catagory;

public interface CategoryRepository extends JpaRepository<Catagory, Long> {
}


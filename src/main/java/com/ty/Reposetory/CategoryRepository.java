package com.ty.Reposetory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
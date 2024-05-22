package com.tapf.indigenousknowledgesystembe.repositories;

import com.tapf.indigenousknowledgesystembe.entities.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByCatName(String catName);

    @EntityGraph(attributePaths = {"categoryValues", "categoryValues.characteristicEvaluation"})
    List<Category> findAll();
}

package com.tapf.indigenousknowledgesystembe.repositories;

import com.tapf.indigenousknowledgesystembe.entities.Category;
import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryValueRepository extends JpaRepository<CategoryValue, Long> {
    List<CategoryValue> findCategoryValueByCategory(Category category);
    CategoryValue findCategoryValueByVal(String val);
}

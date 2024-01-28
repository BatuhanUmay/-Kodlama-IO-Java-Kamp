package org.example.dataAccess.dao;

import org.example.entity.Category;

import java.util.List;

public interface CategoryDao {

    void add(Category category);

    void delete(Category category);

    List<Category> getAll();

    Category getByName(String name);
}

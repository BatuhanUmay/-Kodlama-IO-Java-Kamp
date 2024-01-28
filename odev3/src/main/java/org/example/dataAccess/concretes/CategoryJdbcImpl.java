package org.example.dataAccess.concretes;

import org.example.dataAccess.dao.CategoryDao;
import org.example.dataAccess.db.Database;
import org.example.entity.Category;

import java.util.List;

public class CategoryJdbcImpl implements CategoryDao {

    private final Database database = new Database();

    @Override
    public void add(Category category) {
        database.categories.add(category);
        System.out.println("Category added with JDBC:" + category.getCategoryName());
    }

    @Override
    public void delete(Category category) {
        try {
            database.categories.remove(category);
            System.out.println("Category deleted with JDBC:" + category.getCategoryName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Category> getAll() {
        return database.categories;
    }

    @Override
    public Category getByName(String name) {
        return database.categories.stream().filter(category -> category.getCategoryName().equals(name)).findFirst().orElse(null);
    }
}

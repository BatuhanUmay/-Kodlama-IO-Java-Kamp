package org.example.business.managers;

import org.example.business.services.CategoryService;
import org.example.dataAccess.dao.CategoryDao;
import org.example.entity.Category;

import java.util.List;

public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category getByName(String name) {
        return categoryDao.getByName(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }


    @Override
    public boolean add(Category category) {
        if (categoryDao.getByName(category.getCategoryName()) != null) {
            System.out.println("Kategori ismi mevcut!");
            return false;
        }
        categoryDao.add(category);
        return true;
    }

    @Override
    public boolean delete(String name) {
        Category category = getByName(name);
        if (category == null) {
            System.out.println("Kategori bulunamadı!");
            return false;
        }
        categoryDao.delete(category);
        return true;
    }
}
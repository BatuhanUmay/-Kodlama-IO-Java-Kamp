package org.example;

import org.example.business.managers.CategoryManager;
import org.example.dataAccess.concretes.CategoryHibernateImpl;
import org.example.entity.Category;

public class Main {
    public static void main(String[] args) {

        CategoryManager categoryManager = new CategoryManager(new CategoryHibernateImpl());
        categoryManager.add(new Category("Calculus I", 1));
        categoryManager.add(new Category("Calculus II", 2));
        categoryManager.delete("Calculus II");
        categoryManager.delete("Calculus III");
        for (Category category : categoryManager.getAll()) {
            System.out.println(category.getCategoryName());
        }

    }
}
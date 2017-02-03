package com.igypap.dao;

import com.igypap.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by igypap on 03.02.17.
 */
@Repository
public class CategoryDaoHibernate implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return entityManager.createQuery("SELECT c FROM Category c").getResultList();
    }

    @Override
    @Transactional
    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }
}

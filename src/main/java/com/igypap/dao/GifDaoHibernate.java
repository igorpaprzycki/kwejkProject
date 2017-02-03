package com.igypap.dao;

import com.igypap.model.Gif;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igypap on 03.02.17.
 */
@Repository
public class GifDaoHibernate implements GifDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addGif(Gif gif) {
        entityManager.persist(gif);
    }

    @Override
    @Transactional
    public Gif findGifById(String gifName) {
        return entityManager.find(Gif.class, gifName);
    }

    @Override
    public List<Gif> getAllGifs() {
        return entityManager.createQuery("SELECT g FROM Gif g").getResultList();

    }

    @Override
    public List<Gif> getFavorites() {
        List<Gif> gifList = new ArrayList<>();
        for (Gif gif : getAllGifs()) {
            if (gif.isFavorite()) {
                gifList.add(gif);
            }
        }
        return gifList;
    }
}

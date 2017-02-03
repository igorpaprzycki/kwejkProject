package com.igypap.dao;

import com.igypap.model.Gif;

import java.util.List;

/**
 * Created by igypap on 03.02.17.
 */
public interface GifDao {
    void addGif(Gif gif);

    Gif findGifById(String gifName);

    List<Gif> getAllGifs();

    List<Gif> getFavorites();

    List<Gif> findByCategoryId(int id);
}

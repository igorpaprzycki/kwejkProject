package com.igypap.repository;

import com.igypap.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by igypap on 29.01.17.
 */
@Repository
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "Chris Ramacciotti", false),
            new Gif("ben-and-mike", "Ben Jakuben", true),
            new Gif("book-dominos", "Craig Dennis", false),
            new Gif("compiler-bot", "Ada Lovelace", true),
            new Gif("cowboy-coder", "Grace Hopper", false),
            new Gif("infinite-andrew", "Marissa Mayer", true)
    );

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return new Gif("", "", false);
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> getFavorites() {
        List<Gif> gifList = new ArrayList<>();
        for (Gif gif :
                ALL_GIFS) {
            if (gif.isFavorite()) {
                gifList.add(gif);
            }
        }
        return gifList;
    }
}

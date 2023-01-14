package com.driver.repositories;

import com.driver.models.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository {

    void delete(Image image);

    List<Object> findById(int id);
}

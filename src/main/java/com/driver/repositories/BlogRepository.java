package com.driver.repositories;

import com.driver.models.Blog;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository {

    void save(Blog blog);

    void deleteById(int blogId);

    List<Blog> findAll();

    List<Object> findById(int blogId);
}

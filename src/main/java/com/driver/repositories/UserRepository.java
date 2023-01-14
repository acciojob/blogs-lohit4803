package com.driver.repositories;

import com.driver.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    public User findByUsername(String username);

    void save(User user);

    void deleteById(int userId);

    List<Object> findById(Integer userId);
}

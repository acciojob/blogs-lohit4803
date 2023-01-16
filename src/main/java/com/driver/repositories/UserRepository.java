package com.driver.repositories;

import com.driver.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String username);

    Optional<User> findById(Integer userId);

    Object save(User currentUser);
}

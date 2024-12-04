package com.bombo.template.multijava.domain.user;

import java.util.Optional;

public interface UserRepository {

    void save(User user);
    Optional<User> findById(Long id);
}

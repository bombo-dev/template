package com.bombo.template.multijava.persistence.user;

import com.bombo.template.multijava.domain.user.User;
import com.bombo.template.multijava.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserEntityRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserEntityRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        userJpaRepository.save(userEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id)
                .map(UserMapper::toDomain);
    }
}

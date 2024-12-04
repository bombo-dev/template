package com.bombo.template.multijava.persistence.user;

import com.bombo.template.multijava.domain.user.User;

public class UserMapper {

    private UserMapper() {
    }

    public static UserEntity toEntity(User user) {
        return UserEntity.newInstance(user.getId(), user.getName());
    }

    public static User toDomain(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName());
    }
}

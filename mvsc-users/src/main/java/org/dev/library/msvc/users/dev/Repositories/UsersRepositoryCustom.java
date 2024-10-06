package org.dev.library.msvc.users.dev.Repositories;

import org.dev.library.msvc.users.dev.Models.UserResponse;
import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepositoryCustom {

    List<UsersModel> GetAllUsers();

    Optional<UsersModel> GetByIdUser(Long id);

    UsersModel SaveUser(UsersModel usuario);

    UsersModel UpdateUser(Long id, UsersModel usuario);

    UserResponse DeleteByUser(Long id);
}
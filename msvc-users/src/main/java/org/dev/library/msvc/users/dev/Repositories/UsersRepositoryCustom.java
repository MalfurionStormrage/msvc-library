package org.dev.library.msvc.users.dev.Repositories;

import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepositoryCustom {

    List<UsersModel> GetAllUsers();

    Optional<UsersModel> GetByIdUser(Long id);

    boolean SaveUser(UsersModel usuario);

    boolean UpdateUser(Long id, UsersModel usuario);

    boolean DeleteByUser(Long id);
}
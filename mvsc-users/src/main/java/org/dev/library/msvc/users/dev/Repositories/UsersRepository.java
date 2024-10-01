package org.dev.library.msvc.users.dev.Repositories;

import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersModel, Long> {}

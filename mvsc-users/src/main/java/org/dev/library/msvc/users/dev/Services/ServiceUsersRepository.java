package org.dev.library.msvc.users.dev.Services;

import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.dev.library.msvc.users.dev.Repositories.UsersRepositoryCustom;
import org.dev.library.msvc.users.dev.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsersRepository implements UsersRepositoryCustom {

    private final UsersRepository usersRepository;
    @Autowired
    public ServiceUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsersModel> GetAllUsers() {
        return (List<UsersModel>) usersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsersModel> GetByIdUser(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    @Transactional()
    public UsersModel SaveUser(UsersModel usuario) {
        return usersRepository.save(usuario);
    }

    @Override
    @Transactional()
    public UsersModel UpdateUser(UsersModel usuario) {
        UsersModel existingUser = usersRepository.findById(usuario.getId()).orElseThrow();
        existingUser.setFirstname(usuario.getFirstname());
        existingUser.setLastname(usuario.getLastname());
        existingUser.setEmail(usuario.getEmail());
        return usersRepository.save(existingUser);
    }

    @Override
    @Transactional()
    public void DeleteUser(Long id) {
    usersRepository.deleteById(id);
    }
}

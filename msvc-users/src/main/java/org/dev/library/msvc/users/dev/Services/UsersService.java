package org.dev.library.msvc.users.dev.Services;

import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.dev.library.msvc.users.dev.Repositories.UsersRepository;
import org.dev.library.msvc.users.dev.Repositories.UsersRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UsersRepositoryCustom {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
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
    public boolean SaveUser(UsersModel usersmodel) {
        Optional<UsersModel> createdByUser = usersRepository.findById(usersmodel.getCreatedBy().getId());
        if (createdByUser.isPresent()) {
            usersRepository.save(usersmodel);
            return true;
        }
        return false;
    }

    @Override
    @Transactional()
    public boolean UpdateUser(Long id, UsersModel usuario) {
        Optional<UsersModel> existingUser = usersRepository.findById(id);
        if (existingUser.isPresent()) {
            UsersModel existingUserModel = existingUser.get();
            existingUserModel.setFirstname(usuario.getFirstname());
            existingUserModel.setLastname(usuario.getLastname());
            existingUserModel.setEmail(usuario.getEmail());
            existingUserModel.setUsername(usuario.getUsername());
            existingUserModel.setPhonenumber(usuario.getPhonenumber());
            existingUserModel.setAddress(usuario.getAddress());
            existingUserModel.setPassword(usuario.getPassword());
            existingUserModel.setBirth(usuario.getBirth());
            existingUserModel.setUpdatedBy(usuario.getUpdatedBy());
            usersRepository.save(existingUserModel);
            return true;
        }
        return false;
    }

    @Override
    @Transactional()
    public boolean DeleteByUser(Long id) {
        Optional<UsersModel> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

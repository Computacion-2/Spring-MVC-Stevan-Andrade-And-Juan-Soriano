package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.exception.RoleEmptyExcepcion;
import com.example.exception.RoleNoFoundException;
import com.example.model.Role;
import com.example.repository.IRoleRepository;
import com.example.service.interf.IRoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class RoleService implements IRoleService {

    private final IRoleRepository roleRepository;
    
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) throws RoleEmptyExcepcion, RoleNoFoundException {

        if (id < 0) throw new RoleEmptyExcepcion("Wrong info provided, check again!");

        Optional<Role> roleFound = roleRepository.findById(id);

        if (roleFound.isEmpty()) throw new RoleNoFoundException("Role didn't found in DB");

        return roleFound.get();

    }

    @Override
    public void create(Role roleToAdd) throws RoleEmptyExcepcion {
        
        if (roleToAdd == null) throw new RoleEmptyExcepcion("Information not found, check the fields");

        roleRepository.save(roleToAdd);

    }

    @Override
    public void update(Role roleToUpdate) throws RoleEmptyExcepcion, RoleNoFoundException {
        
        if (roleToUpdate == null) throw new RoleEmptyExcepcion("Information not found, check the fields");

        findById(roleToUpdate.getId());

        roleRepository.save(roleToUpdate);

    }

    @Override
    public void delete(Role roleToDelete) throws RoleEmptyExcepcion, RoleNoFoundException {
        
        if (roleToDelete == null) throw new RoleEmptyExcepcion("Information not found, check the fields");

        findById(roleToDelete.getId());

        roleRepository.delete(roleToDelete);

    }

    @Override
    public boolean existsByName(String name) {

        if (name == null || name.trim().isEmpty()) return false;

        return roleRepository.existsByName(name.trim());

    }
}

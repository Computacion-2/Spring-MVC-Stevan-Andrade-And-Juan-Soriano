package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Permission;

public interface IPermissionRepository extends JpaRepository<Permission, Integer> {

    
}

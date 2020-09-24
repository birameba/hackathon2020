package com.htc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.model.Role;
import com.htc.model.RoleName;

import java.util.Optional;

/**
 * Created by Birame Ba on 11/09/19.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}

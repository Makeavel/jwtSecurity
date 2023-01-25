package com.api.jwtsecurity.repository;

import com.api.jwtsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, String> {


}

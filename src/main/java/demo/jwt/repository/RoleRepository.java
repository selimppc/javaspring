package demo.jwt.repository;

import demo.jwt.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByTitle(String title);
}

package com.beulladeu.spring_demo.dao;

import com.beulladeu.spring_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//для создания слоя, обеспечивающего доступ к БД
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
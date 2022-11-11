package com.fundamentosplatzi.springbootH.fundamentosH.repository;

import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE  u.email = ?1")
    Optional<User> findByUserEmail(String email);

    //JPQL
    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);
}

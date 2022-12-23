package com.fundamentosplatzi.springbootH.fundamentosH.repository;

import com.fundamentosplatzi.springbootH.fundamentosH.dto.UserDto;
import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE  u.email = ?1")
    Optional<User> findByUserEmail(String email);

    //JPQL
    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    @Query("SELECT new com.fundamentosplatzi.springbootH.fundamentosH.dto.UserDto(u.id, u.name, u.birthDate)" +
           " FROM User u " +
           " WHERE u.birthDate=:parametroFecha " +
           " AND u.email=:paremetroEmail ")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                               @Param("paremetroEmail") String email);
}

package com.fundamentosplatzi.springbootH.fundamentosH.repository;

import com.fundamentosplatzi.springbootH.fundamentosH.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

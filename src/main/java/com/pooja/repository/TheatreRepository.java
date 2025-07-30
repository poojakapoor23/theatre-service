package com.pooja.repository;

import com.pooja.entity.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, String> {
    //Optional<User> findByEmail(String email);
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entry.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query(value = "TRUNCATE TABLE people", nativeQuery = true)
    void truncateTable();
}
package com.example.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import com.example.inventory.model.company;
@Repository
public interface CompanyRepository extends JpaRepository<company, Integer> {
    @Query(value = "SELECT c.* FROM Companies c WHERE c.category LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<company> findbyitem(String item);
}

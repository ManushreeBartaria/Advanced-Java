package com.example.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import com.example.inventory.model.DeliveryCompanies;
@Repository
public interface DeliveryCompanyRepository extends JpaRepository<DeliveryCompanies, Integer> {
    @Query(value = "SELECT d.* FROM delivery_companies d WHERE d.region LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<DeliveryCompanies> findByregion(String location);
}
package com.example.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import com.example.inventory.model.DeliveryCompanies;
@Repository
public interface DeliveryCompanyRepository extends JpaRepository<DeliveryCompanies, Integer> {
}
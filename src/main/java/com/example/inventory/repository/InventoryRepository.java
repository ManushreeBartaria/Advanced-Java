package com.example.inventory.repository;
import com.example.inventory.model.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.LocalDate;
@Repository
public interface InventoryRepository extends JpaRepository<item, Integer> {
    List<item> findByExpiryBefore(LocalDate date);
}

package com.example.inventory.repository;
import com.example.inventory.model.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface InventoryRepository extends JpaRepository<item, Integer> {
    List<item> findByExpiryBefore(LocalDate date);
    @Query(value = "SELECT * FROM items WHERE expiry BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 7 DAY)", nativeQuery = true)
    List<item> findByabouttogetexpired();
}

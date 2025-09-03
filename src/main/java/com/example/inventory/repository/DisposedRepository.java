package com.example.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventory.model.disposed;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface DisposedRepository extends JpaRepository<disposed, Integer> {
}
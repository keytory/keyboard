package com.keytory.keyboard.persistence.repository;

import com.keytory.keyboard.persistence.entity.Keytory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeytoryRepository extends JpaRepository<Keytory, Long> {
    List<Keytory> findAllByUserId(Long userId);
}

package com.keytory.keyboard.persistence.repository;

import com.keytory.keyboard.persistence.entity.CustomAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomAttributesRepository extends JpaRepository<CustomAttributes, Long> {
}

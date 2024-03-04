package com.piercegroup.cernev.repository;

import com.piercegroup.cernev.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

  Optional<Attribute> findByCode(String code);

}

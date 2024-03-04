package com.piercegroup.cernev.service;

import com.piercegroup.cernev.entity.Attribute;
import com.piercegroup.cernev.repository.AttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeService {
  private final AttributeRepository attributeRepository;

  public Attribute save(Attribute attribute) {
    return attributeRepository.save(attribute);
  }

  public Attribute update(Attribute attribute) {
    return attributeRepository.save(attribute);
  }

  public Attribute findById(Long id) {
    return attributeRepository.findById(id).orElse(null);
  }

  public List<Attribute> findAll() {
    return attributeRepository.findAll();
  }

  public void deleteById(Long id) {
    attributeRepository.deleteById(id);
  }
}

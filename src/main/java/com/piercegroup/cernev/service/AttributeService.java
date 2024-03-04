package com.piercegroup.cernev.service;

import com.piercegroup.cernev.dto.CreateAttributeRequest;
import com.piercegroup.cernev.dto.UpdateAttributeRequest;
import com.piercegroup.cernev.entity.Attribute;
import com.piercegroup.cernev.exception.CustomException;
import com.piercegroup.cernev.repository.AttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttributeService {
  private final AttributeRepository attributeRepository;

  public Attribute save(CreateAttributeRequest request) {
    Attribute attribute = new Attribute();
    attribute.setCode(request.getCode());
    attribute.setLabels(request.getLabels());
    return attributeRepository.save(attribute);
  }

  public Attribute update(Long id, UpdateAttributeRequest updateAttributeRequest) {
    Map<String, String> labels = updateAttributeRequest.getLabels();
    Attribute attribute = attributeRepository.findById(id)
        .orElseThrow(() -> new CustomException("Attribute not found"));
    attribute.setLabels(labels);
    return attributeRepository.save(attribute);
  }

  public Attribute findById(Long id) {
    return attributeRepository.findById(id).orElse(null);
  }

  public List<Attribute> findAll() {
    return attributeRepository.findAll();
  }

  public Attribute findByCode(String code) {
    return attributeRepository.findByCode(code).orElseThrow(() -> new CustomException("Attribute not found"));
  }

  public void deleteById(Long id) {
    attributeRepository.deleteById(id);
  }
}

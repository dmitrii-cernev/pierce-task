package com.piercegroup.cernev.service;

import com.piercegroup.cernev.dto.CreateAttributeRequest;
import com.piercegroup.cernev.dto.UpdateAttributeRequest;
import com.piercegroup.cernev.entity.Attribute;
import com.piercegroup.cernev.repository.AttributeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class AttributeServiceTest {

  @InjectMocks
  AttributeService attributeService;

  @Mock
  AttributeRepository attributeRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testSave() {
    CreateAttributeRequest request = new CreateAttributeRequest();
    request.setCode("code");
    request.setLabels(Map.of("key", "value"));

    Attribute attribute = new Attribute();
    attribute.setCode(request.getCode());
    attribute.setLabels(request.getLabels());

    when(attributeRepository.save(any(Attribute.class))).thenReturn(attribute);

    Attribute savedAttribute = attributeService.save(request);

    assertEquals(savedAttribute.getCode(), request.getCode());
    assertEquals(savedAttribute.getLabels(), request.getLabels());
  }

  @Test
  public void testUpdate() {
    UpdateAttributeRequest request = new UpdateAttributeRequest();
    request.setLabels(Map.of("key", "value"));

    Attribute attribute = new Attribute();
    attribute.setId(1L);
    attribute.setCode("code");
    attribute.setLabels(Map.of());

    when(attributeRepository.findById(1L)).thenReturn(Optional.of(attribute));
    when(attributeRepository.save(any(Attribute.class))).thenReturn(attribute);

    Attribute updatedAttribute = attributeService.update(1L, request);

    assertEquals(updatedAttribute.getLabels(), request.getLabels());
  }

  @Test
  public void testFindById() {
    Attribute attribute = new Attribute();
    attribute.setId(1L);
    attribute.setCode("code");
    attribute.setLabels(Map.of("key", "value"));

    when(attributeRepository.findById(1L)).thenReturn(Optional.of(attribute));

    Attribute foundAttribute = attributeService.findById(1L);

    assertEquals(foundAttribute, attribute);
  }
}

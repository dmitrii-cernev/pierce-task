package com.piercegroup.cernev.service;

import com.piercegroup.cernev.dto.CreateOptionRequest;
import com.piercegroup.cernev.dto.UpdateOptionRequest;
import com.piercegroup.cernev.entity.Attribute;
import com.piercegroup.cernev.entity.Option;
import com.piercegroup.cernev.repository.OptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OptionServiceTest {

  @InjectMocks
  OptionService optionService;

  @Mock
  OptionRepository optionRepository;

  @Mock
  AttributeService attributeService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testSave() {
    CreateOptionRequest request = new CreateOptionRequest();
    request.setCode("code");
    request.setAttributeCode("attributeCode");
    request.setSortOrder(1);
    request.setLabels(Map.of("key", "value"));

    Attribute attribute = new Attribute();
    attribute.setCode(request.getAttributeCode());

    Option option = new Option();
    option.setCode(request.getCode());
    option.setAttribute(attribute);
    option.setSortOrder(request.getSortOrder());
    option.setLabels(request.getLabels());

    when(attributeService.findByCode(anyString())).thenReturn(attribute);
    when(optionRepository.save(any(Option.class))).thenReturn(option);

    Option savedOption = optionService.save(request);

    assertEquals(savedOption.getCode(), request.getCode());
    assertEquals(savedOption.getAttribute().getCode(), request.getAttributeCode());
    assertEquals(savedOption.getSortOrder(), request.getSortOrder());
    assertEquals(savedOption.getLabels(), request.getLabels());
  }

  @Test
  public void testUpdate() {
    UpdateOptionRequest request = new UpdateOptionRequest();
    request.setSortOrder(1);
    request.setLabels(Map.of("key", "value"));

    Option option = new Option();
    option.setId(1L);
    option.setCode("code");
    option.setSortOrder(0);
    option.setLabels(Map.of());

    when(optionRepository.findById(1L)).thenReturn(Optional.of(option));
    when(optionRepository.save(any(Option.class))).thenReturn(option);

    Option updatedOption = optionService.update(1L, request);

    assertEquals(updatedOption.getSortOrder(), request.getSortOrder());
    assertEquals(updatedOption.getLabels(), request.getLabels());
  }

  @Test
  public void testFindById() {
    Option option = new Option();
    option.setId(1L);
    option.setCode("code");
    option.setSortOrder(1);
    option.setLabels(Map.of("key", "value"));

    when(optionRepository.findById(1L)).thenReturn(Optional.of(option));

    Option foundOption = optionService.findById(1L);

    assertEquals(foundOption, option);
  }
}

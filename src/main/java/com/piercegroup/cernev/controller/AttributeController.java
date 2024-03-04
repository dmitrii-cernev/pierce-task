package com.piercegroup.cernev.controller;

import com.piercegroup.cernev.dto.CreateAttributeRequest;
import com.piercegroup.cernev.dto.UpdateAttributeRequest;
import com.piercegroup.cernev.entity.Attribute;
import com.piercegroup.cernev.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attributes")
@RequiredArgsConstructor
public class AttributeController {

  private final AttributeService attributeService;

  @GetMapping
  public List<Attribute> findAll() {
    return attributeService.findAll();
  }

  @GetMapping("/{id}")
  public Attribute findById(@PathVariable Long id) {
    return attributeService.findById(id);
  }

  @PostMapping
  public Attribute save(@RequestBody CreateAttributeRequest attribute) {
    return attributeService.save(attribute);
  }

  @PutMapping("/{id}")
  public Attribute update(@PathVariable Long id, @RequestBody UpdateAttributeRequest attribute) {
    return attributeService.update(id, attribute);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    attributeService.deleteById(id);
  }
}

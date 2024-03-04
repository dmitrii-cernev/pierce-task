package com.piercegroup.cernev.controller;

import com.piercegroup.cernev.dto.CreateOptionRequest;
import com.piercegroup.cernev.entity.Option;
import com.piercegroup.cernev.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
@RequiredArgsConstructor
public class OptionController {

  private final OptionService optionService;

  @GetMapping
  public List<Option> findAll() {
    return optionService.findAll();
  }

  @GetMapping("/{id}")
  public Option findById(@PathVariable Long id) {
    return optionService.findById(id);
  }

  @PostMapping
  public Option save(@RequestBody CreateOptionRequest option) {
    return optionService.save(option);
  }

  @PutMapping
  public Option update(@RequestBody Option option) {
    return optionService.update(option);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    optionService.deleteById(id);
  }
}

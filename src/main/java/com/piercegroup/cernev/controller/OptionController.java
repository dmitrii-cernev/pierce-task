package com.piercegroup.cernev.controller;

import com.piercegroup.cernev.dto.CreateOptionRequest;
import com.piercegroup.cernev.dto.UpdateOptionRequest;
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

  @PutMapping("/{id}")
  public Option update(@PathVariable Long id, @RequestBody UpdateOptionRequest updateOptionRequest) {
    return optionService.update(id, updateOptionRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    optionService.deleteById(id);
  }
}

package com.piercegroup.cernev.service;

import com.piercegroup.cernev.dto.CreateOptionRequest;
import com.piercegroup.cernev.dto.UpdateOptionRequest;
import com.piercegroup.cernev.entity.Attribute;
import com.piercegroup.cernev.entity.Option;
import com.piercegroup.cernev.exception.CustomException;
import com.piercegroup.cernev.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {
  private final OptionRepository optionRepository;
  private final AttributeService attributeService;

  public Option save(CreateOptionRequest request) {
    Option option = new Option();
    option.setCode(request.getCode());
    Attribute attribute = attributeService.findByCode(request.getAttributeCode());
    option.setAttribute(attribute);
    option.setSortOrder(request.getSortOrder());
    option.setLabels(request.getLabels());
    return optionRepository.save(option);
  }

  public Option findById(Long id) {
    return optionRepository.findById(id).orElse(null);
  }

  public List<Option> findAll() {
    return optionRepository.findAll();
  }

  public void deleteById(Long id) {
    optionRepository.deleteById(id);
  }

  public Option update(Long id, UpdateOptionRequest request) {
    Option option = optionRepository.findById(id).orElseThrow(() -> new CustomException("Option not found"));
    option.setSortOrder(request.getSortOrder());
    option.setLabels(request.getLabels());
    return optionRepository.save(option);
  }
}

package com.piercegroup.cernev.service;

import com.piercegroup.cernev.entity.Option;
import com.piercegroup.cernev.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {
  private final OptionRepository optionRepository;

  public Option save(Option option) {
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

  public Option update(Option option) {
    return optionRepository.save(option);
  }
}

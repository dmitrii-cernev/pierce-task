package com.piercegroup.cernev.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Map;

@Data
public class CreateAttributeRequest {
  @NotEmpty
  private String code;
  private Map<String, String> labels;
}

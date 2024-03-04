package com.piercegroup.cernev.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Map;

@Data
public class CreateOptionRequest {
  @NotEmpty
  private String attributeCode;
  @NotEmpty
  private String code;
  private Integer sortOrder;
  private Map<String, String> labels;
}

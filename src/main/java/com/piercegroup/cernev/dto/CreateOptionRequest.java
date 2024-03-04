package com.piercegroup.cernev.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateOptionRequest {
  private String attributeCode;
  private String code;
  private Integer sortOrder;
  private Map<String, String> labels;
}

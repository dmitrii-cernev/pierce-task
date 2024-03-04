package com.piercegroup.cernev.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CreateAttributeRequest {
  private String code;
  private Map<String, String> labels;
}

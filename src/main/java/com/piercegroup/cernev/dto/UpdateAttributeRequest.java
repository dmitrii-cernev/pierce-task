package com.piercegroup.cernev.dto;

import lombok.Data;

import java.util.Map;

@Data
public class UpdateAttributeRequest {
  private Map<String, String> labels;
}

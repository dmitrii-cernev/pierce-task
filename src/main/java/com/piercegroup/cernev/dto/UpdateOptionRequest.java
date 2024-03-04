package com.piercegroup.cernev.dto;

import lombok.Data;

import java.util.Map;

@Data
public class UpdateOptionRequest {
  private Integer sortOrder;
  private Map<String, String> labels;
}

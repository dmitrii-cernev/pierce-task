package com.piercegroup.cernev.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Option {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String code;
  private Integer sortOrder;
  @ManyToOne
  @JoinColumn(name = "attribute_id", referencedColumnName = "id", nullable = false)
  private Attribute attribute;
}

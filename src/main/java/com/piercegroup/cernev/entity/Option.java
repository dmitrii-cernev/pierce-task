package com.piercegroup.cernev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

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
  @JsonBackReference
  private Attribute attribute;

  @ElementCollection
  @CollectionTable(name = "option_labels")
  @MapKeyColumn(name = "language")
  @Column(name = "label")
  private Map<String, String> labels = new HashMap<>();
}

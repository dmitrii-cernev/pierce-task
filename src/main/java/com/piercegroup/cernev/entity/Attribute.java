package com.piercegroup.cernev.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Attribute {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String code;
  @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Option> options;
  @ElementCollection
  @CollectionTable(name = "attribute_labels")
  @MapKeyColumn(name = "language")
  @Column(name = "label")
  private Map<String, String> labels = new HashMap<>();
}

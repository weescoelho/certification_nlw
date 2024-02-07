package com.weescoelho.certification_nlw.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Criação automatica dos getters e setters
@AllArgsConstructor // Cria um construtor com todas as variaveis da classe
@NoArgsConstructor // Cria um construtor vazio
@Entity(name = "students")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true, nullable = false)
  private String email;

  @OneToMany(mappedBy = "studentEntity")
  private List<CertificationStudentEntity> certificationStudentEntity;

  @CreationTimestamp
  private LocalDateTime createdAt;
}

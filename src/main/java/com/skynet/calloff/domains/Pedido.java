package com.skynet.calloff.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_Pedido")
public class Pedido {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numOrdem;

  private LocalDate dataProducao;

  @ManyToOne
  @JoinColumn
  private Colaborador requisitante;

  @UpdateTimestamp
  private LocalDateTime dataCriacao;

  private String status;

}
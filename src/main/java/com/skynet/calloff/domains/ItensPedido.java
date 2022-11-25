package com.skynet.calloff.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Time;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_Itenspedido")
public class ItensPedido {
  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn
  private Pedido pedido;

  @ManyToOne
  @JoinColumn
  private Partnumber codigo;

  private Integer quantidade;

  private LocalDate dataProducao;

  private Time horaProducao;

}
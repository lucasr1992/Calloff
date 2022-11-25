package com.skynet.calloff.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_Colaborador")
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"registro"})})
public class Colaborador {

  @Id
  @EqualsAndHashCode.Include
  private String registro;

  @Column
  private String nome;

  @Column
  private String email;

  @Column
  private String status;


  @Column
  private String senha;

  @Column
  private String cargo;

}

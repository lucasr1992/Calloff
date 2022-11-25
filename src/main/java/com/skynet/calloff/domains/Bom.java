package com.skynet.calloff.domains;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "tb_Bom")
public class Bom {

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn
  private Partnumber partnumber;

  @ManyToOne
  @JoinColumn
  private Pecas pecas;

  private Integer quantidade;


}

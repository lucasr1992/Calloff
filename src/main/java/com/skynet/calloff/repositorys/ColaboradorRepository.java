package com.skynet.calloff.repositorys;

import com.skynet.calloff.domains.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, String> {
  List<Colaborador> findListaByStatus(String status);

  Optional<Colaborador> findByRegistro(String registro);

  Colaborador deleteByRegistro(String registro);

  Optional<Colaborador> findByRegistroAndSenha(String registro, String senha);

}

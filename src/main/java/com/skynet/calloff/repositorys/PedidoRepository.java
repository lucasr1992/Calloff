package com.skynet.calloff.repositorys;

import com.skynet.calloff.domains.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

  List<Pedido> findByStatus(String status);


  Optional<Pedido> findByNumOrdem(String numOrdem);


  Pedido findTesteById(Long numOrdem);

}


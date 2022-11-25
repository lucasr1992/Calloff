package com.skynet.calloff.repositorys;

import com.skynet.calloff.domains.ItensPedido;
import com.skynet.calloff.domains.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {

  List<ItensPedido> findByPedido(Pedido docId);


}

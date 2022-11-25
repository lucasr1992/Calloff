package com.skynet.calloff.services;

import com.skynet.calloff.domains.Pedido;
import com.skynet.calloff.repositorys.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private ItensPedidoService itensPedidoService;

  public List<Pedido> listarStatus(String status){
    return pedidoRepository.findByStatus(status);
  }

  public Pedido buscarPedido(String numOrdem){
    return pedidoRepository.findByNumOrdem(numOrdem)
      .orElseThrow(() -> new RuntimeException());
  }

  public Pedido buscarId(Long id){
    return pedidoRepository.findById(id)
      .orElseThrow(() -> new RuntimeException());
  }

  public Pedido salvar(Pedido pedido){
    try {
      Pedido pedidoSalvo = pedidoRepository.save(pedido);
      Long val = pedidoSalvo.getId();
      Long doc = val + 10000;
      pedidoSalvo.setNumOrdem("RQ"+doc);
      return pedidoRepository.save(pedidoSalvo);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }

  public Pedido finalizarReq(Long id){
    try{
      Pedido item = buscarId(id);
      item.setStatus("EMITIDO");
      return pedidoRepository.save(item);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }

  public void excluirPedido(Long id){
    try{
      Pedido item = buscarId(id);
      itensPedidoService.removerAll(item);
      pedidoRepository.deleteById(id);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }
}

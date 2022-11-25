package com.skynet.calloff.services;

import com.skynet.calloff.domains.ItensPedido;
import com.skynet.calloff.domains.Partnumber;
import com.skynet.calloff.domains.Pedido;
import com.skynet.calloff.repositorys.BomRepository;
import com.skynet.calloff.repositorys.ItensPedidoRepository;
import com.skynet.calloff.repositorys.PartnumberRepository;
import com.skynet.calloff.repositorys.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensPedidoService {
  @Autowired
  private ItensPedidoRepository itensPedidoRepository;

  @Autowired
  private PedidoRepository pedidoRepository;

  @Autowired
  private BomRepository bomRepository;

  @Autowired
  private PartnumberRepository partnumberRepository;

//    @Autowired
//    private PedidoService pedidoService;

  public List<ItensPedido> buscarDoc(Pedido id){
    System.out.println(id);
    return itensPedidoRepository.findByPedido(id);
  }

  public ItensPedido salvar(ItensPedido itensPedido){
    try{
      return itensPedidoRepository.save(itensPedido);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }

  public void remover(Long id){
    try{
      itensPedidoRepository.deleteById(id);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }

  public void removerAll(Pedido pedido){
    try{
      List<ItensPedido> itens = itensPedidoRepository.findByPedido(pedido);
      itensPedidoRepository.deleteAll(itens);
    }catch (RuntimeException e){
      throw new RuntimeException(e);
    }
  }


  public void multiplicarBom(Long idPedido){
    Pedido item = pedidoRepository.findTesteById(idPedido);
    List<ItensPedido> itens = itensPedidoRepository.findByPedido(item);

    for(ItensPedido itemLista : itens){
      Optional<Partnumber> partnumber =
        partnumberRepository.findById(itemLista.getCodigo().getId());



    }


  }
}

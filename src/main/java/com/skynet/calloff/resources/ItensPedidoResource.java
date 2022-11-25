package com.skynet.calloff.resources;

import com.skynet.calloff.domains.ItensPedido;
import com.skynet.calloff.domains.Pedido;
import com.skynet.calloff.repositorys.ItensPedidoRepository;
import com.skynet.calloff.services.ItensPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itenspedido")
@CrossOrigin
public class ItensPedidoResource {
  @Autowired
  private ItensPedidoService itensPedidoService;

  @Autowired
  private ItensPedidoRepository itensPedidoRepository;

  @GetMapping("/itens/{id}")
  public List<ItensPedido> listarItens(@PathVariable Pedido id){
    return itensPedidoService.buscarDoc(id);
  }

  @PostMapping("/cadastro")
  public ItensPedido cadastrar(@RequestBody ItensPedido itensPedido){
    return itensPedidoService.salvar(itensPedido);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> remover(@PathVariable Long id){
    try{
      itensPedidoService.remover(id);
      return ResponseEntity.noContent().build();
    }catch (RuntimeException e){
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/teste/{idPedido}")
  public void teste(@PathVariable Long idPedido){
    itensPedidoService.multiplicarBom(idPedido);
  }

}

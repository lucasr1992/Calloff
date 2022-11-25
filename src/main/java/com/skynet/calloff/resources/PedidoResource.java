package com.skynet.calloff.resources;

import com.skynet.calloff.domains.Pedido;
import com.skynet.calloff.services.ItensPedidoService;
import com.skynet.calloff.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin
public class PedidoResource {
  @Autowired
  private PedidoService pedidoService;

  @Autowired
  private ItensPedidoService itensPedidoService;

  @GetMapping("/{status}")
  public List<Pedido> listarStatus(@PathVariable String status){
    return pedidoService.listarStatus(status);
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<?> remover(@PathVariable Long id){
    try{
      System.out.println(id);
      pedidoService.excluirPedido(id);
      return ResponseEntity.noContent().build();
    }catch (RuntimeException e){
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public Pedido cadastrar(@RequestBody Pedido pedido){
    return pedidoService.salvar(pedido);
  }

  @PutMapping("/finalizar/{id}")
  public Pedido finalizar(@PathVariable Long id){
    return pedidoService.finalizarReq(id);
  }
}

